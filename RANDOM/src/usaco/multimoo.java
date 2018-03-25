
// package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;

public class multimoo
{
	public static int[][] map;
	public static ArrayList<Integer> switched = new ArrayList<>();
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("multimoo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int size = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		visited = new boolean[size][size];
		for (int i = 0; i < size; i++)
		{
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < size; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (!visited[i][j])
					max = Math.max(max, ff(i, j, map[i][j], map[i][j]));
		out.println(max);
		max = 0;
		int[] dx =
			{ 0, 0, 1, -1 };
		int[] dy =
			{ 1, -1, 0, 0 };
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				for (int k = 0; k < 4; k++)
					if (i + dx[k] > -1 && i + dx[k] < size && j + dy[k] > -1 && j + dy[k] < size
							&& map[i + dx[k]][j + dy[k]] != map[i][j])
					{
						visited = new boolean[size][size];
						max = Math.max(max, ff(i, j, map[i][j], map[i + dx[k]][j + dy[k]]));
					}

		out.println(max);
		out.close();
		f.close();
	}

	public static int ff(int x, int y, int id, int id2)
	{
		visited[x][y] = true;
		int count = 1;
		int[] dx =
			{ 0, 0, 1, -1 };
		int[] dy =
			{ 1, -1, 0, 0 };
		for (int i = 0; i < 4; i++)
			if (x + dx[i] > -1 && x + dx[i] < map.length && y + dy[i] > -1 && y + dy[i] < map.length)
				if (!visited[x + dx[i]][y + dy[i]]
						&& (map[x + dx[i]][y + dy[i]] == id || map[x + dx[i]][y + dy[i]] == id2))
					count += ff(x + dx[i], y + dy[i], id, id2);
		return count;
	}
}


// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class Horseshoes_2012NovBronze3 {
	public static int[][] maze;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("hshoe.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hshoe.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int sidelen = Integer.parseInt(st.nextToken());
		maze = new int[sidelen][sidelen];
		for (int i = 0; i < sidelen; i++) {
			st = new StringTokenizer(f.readLine());
			String[] row = st.nextToken().split("");
			for (int j = 0; j < sidelen; j++)
				maze[i][j] = row[j].equals("(") ? 1 : -1;
		}

		if (maze[0][0] == -1) {
			out.println(0);
		}
		else {
			out.println(dfs(0, 0, 0, 0));
		}

		f.close();
		out.close();
	}

	public static int dfs(int r, int c, int open, int closed) {
		if (r < 0 || r > maze.length - 1 || c < 0 || c > maze.length - 1 || maze[r][c] == 0
				|| (maze[r][c] == 1 && closed > 0))
			return 0;
		if (maze[r][c] == 1)
			open++;
		else
			closed++;
		if (open == closed && closed != 0)
			return open * 2;

		int max = 0;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int temp = maze[r][c];
		maze[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int next = dfs(r + dy[i], c + dx[i], open, closed);
			if (next > max)
				max = next;
		}
		maze[r][c] = temp;
		return max;
	}
}

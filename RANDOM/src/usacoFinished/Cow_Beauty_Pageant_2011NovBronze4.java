
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cow_Beauty_Pageant_2011NovBronze4 {
	public static int[][] grid;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pageant.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pageant.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int rows = Integer.parseInt(st.nextToken()), cols = Integer.parseInt(st.nextToken());
		grid = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			st = new StringTokenizer(f.readLine());
			String[] line = st.nextToken().split("");
			for (int j = 0; j < cols; j++)
				if (line[j].equals("X"))
					grid[i][j] = -1;
		}

		int count = 1;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (grid[i][j] == -1) {
					flood(i, j, count);
					count++;
				}

		int min = rows + cols;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (grid[i][j] == 1)
					for (int k = 0; k < rows; k++)
						for (int l = 0; l < cols; l++)
							if (grid[k][l] == 2)
								min = Math.min(Math.abs(k - i) + Math.abs(l - j) - 1, min);

		out.print(min);
		f.close();
		out.close();
	}

	public static void flood(int row, int col, int fill) {
		grid[row][col] = fill;

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		for (int i = 0; i < 4; i++)
			if (row + dx[i] > -1 && row + dx[i] < grid.length && col + dy[i] > -1 && col + dy[i] < grid[0].length
					&& grid[row + dx[i]][col + dy[i]] == -1)
				flood(row + dx[i], col + dy[i], fill);
	}
}

package scam;

import java.util.Scanner;

public class lake
{
	public static boolean[][] grid;

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt(), cols = scan.nextInt(), sub = scan.nextInt();
		grid = new boolean[rows][cols];
		for (int i = 0; i < sub; i++)
			grid[scan.nextInt() - 1][scan.nextInt() - 1] = true;

		int max = 0;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (grid[i][j])
					max = Math.max(flood(i, j), max);

		System.out.println(max);
		scan.close();
	}

	public static int flood(int row, int col)
	{
		grid[row][col] = false;
		int sum = 1;

		int[] dx =
			{ 0, 0, 1, -1 };
		int[] dy =
			{ 1, -1, 0, 0 };
		for (int i = 0; i < 4; i++)
			if (row + dx[i] > -1 && row + dx[i] < grid.length && col + dy[i] > -1 && col + dy[i] < grid[0].length
					&& grid[row + dx[i]][col + dy[i]])
				sum += flood(row + dx[i], col + dy[i]);
		return sum;
	}
}

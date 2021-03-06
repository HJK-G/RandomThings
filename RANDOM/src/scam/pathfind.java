
package scam;

import java.util.LinkedList;
import java.util.Scanner;

public class pathfind
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int start = scan.nextInt() - 1;
		int[][] canGo = new int[size][size];
		for (int i = 0; i < size; i++)
		{
			int count = 0;
			for (int j = 0; j < size; j++)
				if (scan.nextInt() == 1)
				{
					canGo[i][count] = j;
					count++;
				}
			canGo[i][count] = -1;
		}

		int[] dist = new int[size];
		LinkedList<Integer> q = new LinkedList<>();
		q.push(start);
		boolean[] visited = new boolean[size];
		dist[start] = 0;
		visited[start] = true;
		while (!q.isEmpty())
		{
			int current = q.pop();
			int count = 0;
			while (canGo[current][count] != -1)
			{
				if (!visited[canGo[current][count]])
				{
					q.add(canGo[current][count]);
					visited[canGo[current][count]] = true;
					dist[canGo[current][count]] = dist[current] + 1;
				}
				count++;
			}
		}
		for (int i = 0; i < size; i++)
		{
			boolean first = true;
			for (int j = 0; j < size; j++)
				if (dist[j] == i && visited[j])
					if (!first)
						System.out.print(" " + (j + 1));
					else
					{
						first = false;
						System.out.print(j + 1);
					}
			System.out.println();
		}
		scan.close();
	}
}

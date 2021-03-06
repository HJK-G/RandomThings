package TRULYRANDOM;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class stuff
{
	private static class pos implements Comparable<pos> {
		int x;
		int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(pos o) {
			if (x > o.x) {
				return 1;
			}
			else if (x < o.x) {
				return -1;
			}
			else {
				return y - o.y;
			}

		}
	}

	static boolean[][] visited;
	static int[][] map;

	public static int floodfill(int x, int y, int id)
	{
		visited[x][y] = true;
		int count = 1;
		int[] dx =
			{ 0, 0, 1, -1 };
		int[] dy =
			{ 1, -1, 0, 0 };
		for (int i = 0; i < 4; i++)
			if (x + dx[i] > -1 && x + dx[i] < map.length && y + dy[i] > -1 && y + dy[i] < map.length)
				if (!visited[x + dx[i]][y + dy[i]] && map[x + dx[i]][y + dy[i]] == id)
					count += floodfill(x + dx[i], y + dy[i], id);
		return count;
	}

	void bfs(int sx, int sy, int ex, int ey)
	{
		int[] dx =
			{ 0, 0, 1, -1 };
		int[] dy =
			{ 1, -1, 0, 0 };
		Queue<pos> q = new LinkedList<>();
		q.add(new pos(sx, sy));
		while (!q.isEmpty())
		{
			pos curr = q.remove();
			if (curr.x == ex && curr.y == ey)
				return;
			for (int i = 0; i < 4; i++)
				if (curr.x + dx[i] > -1 && curr.x + dx[i] < map.length && curr.y + dy[i] > -1
						&& curr.y + dy[i] < map.length && !visited[curr.x + dx[i]][curr.y + dy[i]])
					q.add(new pos(curr.x + dx[i], curr.y + dy[i]));
		}
	}

	void bubblesort(int[] list)
	{
		for (int i = 0; i < list.length; i++)
			for (int j = list.length - 1; j > 0; j--)
				if (list[j] < list[j - 1])
				{
					int temp = list[j];
					list[j] = list[j - 1];
					list[j - 1] = temp;
				}

		for (int i = 0; i < list.length; i++)
			System.out.println(list[i]);
	}

	void merge(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2)
		{
			if (L[i] <= R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1)
		{
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2)
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r)
	{
		if (l < r)
		{
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	public static int binarySearch(ArrayList<Integer> B, int num)
	{
		int min = 0;
		int max = B.size() - 1;
		while (min < max)
		{
			int mid = (min + max) / 2;
			if (B.get(mid) == num)
				return mid;
			if (B.get(mid) > num)
				max = mid - 1;
			else
				min = mid + 1;
		}
		return min;
	}

	static String[][] permute(String[] wordList)
	{
		if (wordList.length == 1)
		{
			String[][] res =
				{ wordList };
			return res;
		}
		String[][] res = new String[factorial(wordList.length)][wordList.length];
		int count = 0;
		for (int i = 0; i < wordList.length; i++)
		{
			String[][] next = permute(rem(wordList, wordList[i]));
			for (int j = 0; j < next.length; j++)
			{
				res[count][0] = wordList[i];
				for (int k = 0; k < next[0].length; k++)
				{
					res[count][k + 1] = next[j][k];
				}
				count++;
			}
		}

		return res;
	}

	static String[] rem(String[] wordList, String word)
	{
		String[] res = new String[wordList.length - 1];
		int count = 0;
		for (int i = 0; i < wordList.length; i++)
		{
			if (!wordList[i].equals(word))
			{
				res[count] = wordList[i];
				count++;
			}
		}
		return res;
	}

	static int factorial(int a)
	{
		int res = 1;
		for (; a > 1; a--)
			res *= a;
		return res;
	}
}

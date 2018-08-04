
//package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class sort
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("sort.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int num = Integer.parseInt(st.nextToken());
		int[] A = new int[num];
		ArrayList<Integer> B = new ArrayList<>();
		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer(f.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B.add(A[i]);
		}

		Collections.sort(B);
		for (int i = 0; i < num; i++)
			A[i] = idxOf(B, A[i]);
		int max = 0;
		for (int i = 0; i < num; i++)
			max = Math.max(max, i - A[i]);

		out.println(max + 1);
		out.close();
		f.close();
	}

	public static int idxOf(ArrayList<Integer> B, int num)
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
}

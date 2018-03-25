
// package usaco;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class sort
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("sort.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int num = Integer.parseInt(st.nextToken());
		int[] A = new int[num];
		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer(f.readLine());
			A[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		boolean sorted = false;
		while (!sorted)
		{
			sorted = true;

			for (int i = 0; i < num - 1 - count; i++)
				if (A[i + 1] < A[i])
				{
					int temp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = temp;
					sorted = false;
				}
			count++;
		}
		out.println(count);
		out.close();
		f.close();
	}
}
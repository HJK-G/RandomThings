package usaco;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class countcross
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("countcross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int size = Integer.parseInt(st.nextToken());
		int cows = Integer.parseInt(st.nextToken());
		int roads = Integer.parseInt(st.nextToken());
		boolean[][][] canMove = new boolean[size][size][4];
		
		
		out.println();
		out.close();
		f.close();
	}
}
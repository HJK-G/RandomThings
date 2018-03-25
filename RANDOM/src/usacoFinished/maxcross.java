
// package usacoFinished;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class maxcross
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("maxcross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int lights = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int damaged = Integer.parseInt(st.nextToken());
		boolean[] allLights = new boolean[lights];
		for (int i = 0; i < damaged; i++)
		{
			st = new StringTokenizer(f.readLine());
			allLights[Integer.parseInt(st.nextToken()) - 1] = true;
		}
		int inARow = 0;
		for (int i = 0; i < row; i++)
			if (!allLights[i])
				inARow++;

		int min = row - inARow;
		for (int i = row; i < lights; i++)
		{
			if (!allLights[i - row])
				inARow--;
			if (!allLights[i])
				inARow++;
			min = Math.min(min, row - inARow);
		}
		out.println(min);
		out.close();
		f.close();
	}
}

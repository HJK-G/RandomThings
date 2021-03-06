
// package usacoFinished;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Moocast_2016DecSilver3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int numcows = Integer.parseInt(st.nextToken());
		boolean[][] cowsreach = new boolean[numcows][numcows];
		int[] x = new int[numcows];
		int[] y = new int[numcows];
		int[] power = new int[numcows];
		for (int i = 0; i < numcows; i++) {
			st = new StringTokenizer(f.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			power[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < numcows; i++)
			for (int j = 0; j < numcows; j++)
				if ((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]) <= power[i] * power[i])
					cowsreach[i][j] = true;

		int max = 1;
		boolean[] used;
		for (int i = 0; i < numcows; i++) {
			used = new boolean[numcows];
			max = Math.max(max, dfs(i, cowsreach, used));
		}

		out.println(max);
		out.close();
		f.close();
	}

	public static int dfs(int curr, boolean[][] cowsreach, boolean[] used) {
		used[curr] = true;
		int count = 1;
		for (int i = 0; i < cowsreach.length; i++)
			if (cowsreach[curr][i] && !used[i])
				count += dfs(i, cowsreach, used);
		return count;
	}
}

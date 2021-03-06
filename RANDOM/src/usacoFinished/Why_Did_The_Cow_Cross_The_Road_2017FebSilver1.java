
// package usacoFinished;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Arrays;

public class Why_Did_The_Cow_Cross_The_Road_2017FebSilver1 {
	private static class pair implements Comparable<pair> {
		public int x1;
		public int x2;

		public pair(int x1, int x2) {
			this.x1 = x1;
			this.x2 = x2;
		}

		public int compareTo(pair o) {
			if (o.x1 > x1 && o.x2 < x2)
				return 1;
			if (x1 > o.x1 && x2 < o.x2)
				return -1;
			if (x1 == o.x1)
				return x2 - o.x2;
			return x1 - o.x1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("helpcross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int chickennum = Integer.parseInt(st.nextToken());
		int cownum = Integer.parseInt(st.nextToken());
		int[] chickentimes = new int[chickennum];
		pair[] cowtimes = new pair[cownum];
		for (int i = 0; i < chickennum; i++) {
			st = new StringTokenizer(f.readLine());
			chickentimes[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < cownum; i++) {
			st = new StringTokenizer(f.readLine());
			cowtimes[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(chickentimes);
		Arrays.sort(cowtimes);
		int count = 0;
		boolean[] used = new boolean[chickennum];
		for (int i = 0; i < cownum; i++) {
			for (int j = 0; j < chickennum; j++)
				if (!used[j] && chickentimes[j] <= cowtimes[i].x2 && chickentimes[j] >= cowtimes[i].x1) {
					count++;
					used[j] = true;
					break;
				}
		}
		out.println(count);
		out.close();
		f.close();
	}
}

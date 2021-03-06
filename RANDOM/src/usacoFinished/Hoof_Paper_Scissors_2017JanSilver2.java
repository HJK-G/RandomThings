
// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class Hoof_Paper_Scissors_2017JanSilver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("hps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int matches = Integer.parseInt(st.nextToken());
		int[] predict = new int[matches];
		int[] counting = new int[3];
		int[] revcounting = new int[3];
		for (int i = 0; i < matches; i++) {
			st = new StringTokenizer(f.readLine());
			String picked = st.nextToken();
			if (picked.equals("H")) {
				revcounting[1]++;
				predict[i] = 0;
			}
			else if (picked.equals("P")) {
				revcounting[2]++;
				predict[i] = 1;
			}
			else {
				revcounting[0]++;
				predict[i] = 2;
			}
		}

		int max = 0;
		for (int choose1 = 0; choose1 < 3; choose1++)
			for (int choose2 = 0; choose2 < 3; choose2++) {
				int temp = revcounting[choose2];
				for (int splittingPoint = 0; splittingPoint < matches; splittingPoint++) {
					counting[choose1] += beat(choose1, predict[splittingPoint]) ? 1 : 0;
					revcounting[choose2] += beat(choose2, predict[splittingPoint]) ? -1 : 0;
					max = Math.max(max, counting[choose1] + revcounting[choose2]);
				}
				counting[choose1] = 0;
				revcounting[choose2] = temp;
			}

		out.println(max);
		out.close();
		f.close();
	}

	public static boolean beat(int b, int j) {
		if (j == 0)
			return b == 1;
		if (j == 1)
			return b == 2;
		return b == 0;
	}
}

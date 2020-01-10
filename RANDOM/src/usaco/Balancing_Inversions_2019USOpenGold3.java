
// package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;
import java.util.Arrays;

public class Balancing_Inversions_2019USOpenGold3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("balance.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balance.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int N = Integer.parseInt(st.nextToken());
		boolean[] array = new boolean[2 * N + 1];
		st = new StringTokenizer(f.readLine());

		for (int i = 1; i <= 2 * N; i++) {
			array[i] = Integer.parseInt(st.nextToken()) == 1;
		}

		long difference = 0;
		int count1 = 0;
		int count2 = 0;

		// rightmost 1, leftmost 0
		int rightmost = 0;
		int leftmost = 0;
		for (int i = 1; i <= N; i++) {
			if (array[i]) {
				count1++;
				rightmost = i;
			}
			else {
				difference += count1;
			}
			if (array[i + N]) {
				count2++;
			}
			else {
				difference -= count2;
				if (leftmost == 0) {
					leftmost = i + N;
				}
			}
		}
		long min = Math.abs(difference);
		int cswap = 0;
		// 1,0 -> 0,1
		for (int i = 1; i <= N; i++) {
			cswap += N - rightmost + leftmost - (N + 1) + 1;
			difference -= N - rightmost;
			difference += leftmost - (N + 1);
			difference += count1 + count2 - N;
			while (rightmost > 0) {
				rightmost--;
				if (array[rightmost]) {
					break;
				}
			}
			while (leftmost < 2 * N) {
				leftmost++;
				if (!array[leftmost]) {
					break;
				}
			}
			min = Math.min(min, cswap + Math.abs(difference));
			if (rightmost == 0 || leftmost == 2 * N + 1) {
				break;
			}
		}

		difference = 0;
		count1 = 0;
		count2 = 0;

		// rightmost 0, leftmost 1
		rightmost = 0;
		leftmost = 0;
		for (int i = 1; i <= N; i++) {
			if (array[i]) {
				count1++;
			}
			else {
				difference += count1;
				rightmost = i;
			}
			if (array[i + N]) {
				count2++;
				if (leftmost == 0) {
					leftmost = i + N;
				}
			}
			else {
				difference -= count2;
			}
		}
		cswap = 0;
		// 0,1 -> 1,0
		for (int i = 1; i <= N; i++) {
			cswap += N - rightmost + leftmost - (N + 1) + 1;
			difference += N - rightmost;
			difference -= leftmost - (N + 1);
			difference -= count1 + count2 - N;
			while (rightmost > 0) {
				rightmost--;
				if (!array[rightmost]) {
					break;
				}
			}
			while (leftmost < 2 * N) {
				leftmost++;
				if (array[leftmost]) {
					break;
				}
			}
			min = Math.min(min, cswap + Math.abs(difference));
			if (rightmost == 0 || leftmost == 2 * N + 1) {
				break;
			}
		}

		out.println(min);
		out.close();
		f.close();
	}
}


// package usacoFinished;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import java.io.IOException;

public class Secret_Cow_Code_2017JanSilver3 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowcode.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		String code = st.nextToken();
		long n = Long.parseLong(st.nextToken());
		out.println(solve(code, n - 1));
		out.close();
		f.close();
	}

	public static String solve(String code, long index) {
		if (index < code.length())
			return code.substring((int) index, (int) index + 1);
		int times = (int) Math.floor(Math.log10(index * 1.0 / code.length()) / Math.log10(2));
		if (code.length() * Math.pow(2, times) == index)
			return solve(code, index - 1);
		else
			return solve(code, index - (long) (code.length() * Math.pow(2, times)) - 1);
	}
}

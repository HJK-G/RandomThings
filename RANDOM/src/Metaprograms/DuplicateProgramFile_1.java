package Metaprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DuplicateProgramFile_1
{
	public static void main(String[] args) throws IOException
	{
		@SuppressWarnings("unused")
		int count = 1;

		BufferedReader f = new BufferedReader(
				new FileReader("src/MATHISNOTMETH/DuplicateProgramFile_" + count + ".java"));
		ArrayList<String> file = new ArrayList<String>();
		while (f.ready())
			file.add(f.readLine());
		f.close();
		count += 1;
		PrintWriter out = new PrintWriter(
				new BufferedWriter(new FileWriter("src/MATHISNOTMETH/DuplicateProgramFile_" + count + ".java")));

		for (String a : file)
		{
			if (a.length() > 14 && a.substring(0, 14).equals("		int count = "))
				out.println(a.substring(0, 14) + (Integer.parseInt(a.substring(14, a.length() - 1)) + 1) + ";");
			else if (a.equals("public class DuplicateProgramFile_" + (count - 1)))
				out.println("public class DuplicateProgramFile_" + count);
			else
				out.println(a);

		}
		out.close();
	}
}

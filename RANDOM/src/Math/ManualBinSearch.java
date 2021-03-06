package Math;

import java.util.Scanner;

public class ManualBinSearch
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int min = 0;
		int max = 100000;
		while (min < max)
		{
			int mid = (int) Math.round((min + max) / 2.0);
			System.out.println(mid);
			int in = scan.nextInt();
			if (in == 3)
				break;
			if (in == 1) // less higher
				min = mid;
			else if (in == 2) // more lower
				max = mid;
		}

		scan.close();
	}
}

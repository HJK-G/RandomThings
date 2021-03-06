package Cryptography;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("This is a complex password generator.");
		System.out.print("Do you want to (1) make an entirely new password, or (2) change your current one: ");
		String pass = "";
		if (!repeatUntilGood(scan.next(), scan))
		{
			scan.nextLine();
			System.out.println("To start, put your current or a random password and then press enter.");
			pass = scan.nextLine();
			if (checkGood(pass))
			{
				System.out.print("Your password is good. Do you want a different one (Y/N): ");
				if (scan.next().equals("N"))
				{
					System.out.println("OK");
					scan.close();
					return;
				}
			}
		}
		pass = editPassword(pass);
		if (!checkGood(pass))
			pass += "_Gr3@+!";

		System.out.println("Here is your new password!");
		System.out.println(pass);
		scan.close();
	}

	public static boolean repeatUntilGood(String input, Scanner scan)
	{
		while (true)
		{
			if (input.equals("1"))
				break;
			if (input.equals("2"))
				break;
			System.out.print("You need to input 1 or 2: ");
			input = scan.next();
		}
		return input.equals("1");
	}

	public static String editPassword(String password)
	{
		while (password.length() < 8)
			if (password.equals(""))
				password = randomWord();
			else
				password += " " + randomWord();

		password = password.substring(0, 1).toUpperCase() + password.substring(1);
		for (int i = 0; i < password.length(); i++)
		{
			int ascii = password.charAt(i);
			if (ascii == 97)
				password = password.substring(0, i) + "@" + password.substring(i + 1);
			else if (ascii == 101 || ascii == 69)
				password = password.substring(0, i) + "3" + password.substring(i + 1);
			else if (ascii == 116)
				password = password.substring(0, i) + "+" + password.substring(i + 1);
			else if (ascii == 105 || ascii == 73)
				password = password.substring(0, i) + "1" + password.substring(i + 1);
			else if (ascii == 115 || ascii == 83)
				password = password.substring(0, i) + "5" + password.substring(i + 1);
			else if (ascii == 111 || ascii == 79)
				password = password.substring(0, i) + "0" + password.substring(i + 1);
			else if (ascii == 32 && i < password.length() - 1)
				password = password.substring(0, i) + "_" + password.substring(i + 1, i + 2).toUpperCase()
						+ password.substring(i + 2);
			else if (ascii == 32)
				password = password.substring(0, i) + "_";
		}
		return password;
	}

	public static String randomWord()
	{
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("commonwords.txt"));

			Random rand = new Random();
			int find = rand.nextInt(9897);
			for (int i = 0; i < find; i++)
				f.readLine();

			String word = f.readLine();
			f.close();
			return word.substring(0, 1).toUpperCase() + word.substring(1);
		}
		catch (IOException e)
		{
		}
		return "Amazing";
	}

	public static boolean checkGood(String password)
	{
		if (password.length() < 8)
			return false;
		boolean[] checks = new boolean[4];
		for (int i = 0; i < password.length(); i++)
		{
			int ascii = password.charAt(i);
			if (ascii >= 65 && ascii <= 90)
				checks[0] = true;
			else if (ascii >= 97 && ascii <= 122)
				checks[1] = true;
			else if (ascii >= 48 && ascii <= 57)
				checks[2] = true;
			else
				checks[3] = true;
		}

		for (int i = 0; i < 4; i++)
			if (!checks[i])
				return false;
		return true;
	}
}

package johnkomm;

import java.util.Scanner;

public class Test236
{
	public static void main(String[] args)
	{
		//Take a sentence
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a sentence");
		String x=sc.nextLine();
		//count vowels
		int vc=0;
		int remaining=0;
		for(int i=0;i<x.length();i++)
		{
			char y=x.charAt(i);
			switch(y)
			{
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
					vc++;
					break;
				default:
					remaining++;	
			}
		}
		System.out.println("Vowels count is "+vc);
		System.out.println("Remaining chars count is "+remaining);
	}
}

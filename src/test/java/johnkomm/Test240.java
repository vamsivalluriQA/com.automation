package johnkomm;

import java.util.Scanner;

public class Test240
{
	public static void main(String[] args)
	{
		//Take a sentence
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a sentence");
		String x=sc.nextLine();
		//Take a char
		System.out.println("Enter a character");
		char y=sc.nextLine().charAt(0);
		//count of occurrences
		int count=0;
		for(int i=0;i<x.length();i++)
		{
			if(y==x.charAt(i))
			{
				count++;
			}
		}
		System.out.println(y+" occured "+count+" times");
	}
}







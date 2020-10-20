package johnkomm;

import java.util.Scanner;

public class Test237
{
	public static void main(String[] args)
	{
		//Take a sentence
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a sentence");
		String x=sc.nextLine();
		//count variables
		int clc=0;
		int cuc=0;
		int cd=0;
		int csc=0;
		for(int i=0;i<x.length();i++)
		{
			char y=x.charAt(i);
			if(y>=97 && y<=122)
			{
				clc++;
			}
			else if(y>=65 && y<=90)
			{
				cuc++;
			}
			else if(y>=48 && y<=57)
			{
				cd++;
			}
			else
			{
				csc++;
			}
		}
		System.out.println("lower case alphabet count is "+clc);
		System.out.println("upper case alphabet count is "+cuc);
		System.out.println("digits count is "+cd);
		System.out.println("Remaining chars count is "+csc);
	}
}









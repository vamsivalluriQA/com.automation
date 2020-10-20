package johnkomm;

import java.util.Scanner;

public class Test235
{
	public static void main(String[] args)
	{
		//Take a sentence
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a sentence");
		String x=sc.nextLine();
		//logic-2
		int nos=0;
		int now;
		if(x.charAt(0)==' ')
		{
			now=0;
		}
		else
		{
			now=1; //by default one sentence is one word
		}
		for(int i=0;i<x.length();i++)
		{
			char y=x.charAt(i);
			//for blank space
			if(y==' ')
			{
				nos++;
			}
			//for word
			try
			{
				if(y==' ' && x.charAt(i+1)!=' ')
				{
					now++;
				}
			}
			catch(Exception ex)
			{
			}
		}
		System.out.println("No: of spaces is "+nos);
		System.out.println("No: of words is "+now);
	}
}









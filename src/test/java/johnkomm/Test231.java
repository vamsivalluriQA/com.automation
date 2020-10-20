package johnkomm;

import java.util.Scanner;

public class Test231
{
	public static void main(String[] args)
	{
		//Take a number
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		//Multiplication table for given number
		for(int i=1;i<=10;i++)
		{
			System.out.println(x+"X"+i+"="+(x*i));
		}
	}
}







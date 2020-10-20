package johnkomm;

import java.util.Scanner;

public class Test233
{
	public static void main(String[] args)
	{
		//Take a number
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		//check for prime
		int flag=0;
		for(int i=2;i<x;i++)
		{
			if(x%i==0)
			{
				flag=1;
				break; //terminate from current loop
			}
		} //loop completion
		if(flag==0)
		{
			System.out.println(x+" is prime number");
		}
		else
		{
			System.out.println(x+" is not prime number");
		}
	}
}

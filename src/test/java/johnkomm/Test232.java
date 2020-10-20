package johnkomm;

import java.util.Scanner;

public class Test232
{
	public static void main(String[] args)
	{
		//Take a number
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		//Hormonic series
		double sum=1.0; //sum initial value 1 as double in java
		for(int i=2;i<=x;i++)
		{
			sum=sum+(double)1/i; //type casting for numerator 1 in java
		}
		System.out.println("Hormonic series total is "+sum);
	}
}



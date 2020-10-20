package johnkomm;

import java.util.Scanner;

public class Test261
{
	public static void main(String[] args)
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=sc.nextInt();
		int x[]=new int[n]; //declare static array
		System.out.println("Enter "+n+" values");
		for(int i=0;i<n;i++)
		{
			x[i]=sc.nextInt();
		}
		//find 2nd largest
		int largest=x[0];
		int secondlargest=0;
		//search from 2nd value(index=1)
		for(int i=1;i<n;i++)
		{
			if(largest<x[i])
			{
				secondlargest=largest;
				largest=x[i];
			}
			else if(largest>=x[i] && secondlargest<x[i])
			{
				secondlargest=x[i];
			}
			else if(secondlargest>largest) //when all values in array are negative
			{
				secondlargest=largest;
			}
		}
		System.out.println("Second Largest value is "+secondlargest);
	}
}







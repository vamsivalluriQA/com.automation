package johnkomm;

import java.util.Scanner;

public class Test262
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
		System.out.println("Before sorting");
		for(int i=0;i<n;i++)
		{
			System.out.print(x[i]+" ");
		}
		System.out.println();
		//bubble sorting
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(x[j]>x[j+1])
				{
					int temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
				}
			}
		}
		System.out.println("After sorting");
		for(int i=0;i<n;i++)
		{
			System.out.print(x[i]+" ");
		}	
	}
}

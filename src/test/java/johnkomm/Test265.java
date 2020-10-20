package johnkomm;

import java.util.ArrayList;
import java.util.Scanner;

public class Test265
{
	public static void main(String[] args)
	{
		//Declare dynamic array
		ArrayList<String> x=new ArrayList<String>(); //String is default generic
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=Integer.parseInt(sc.nextLine());
		System.out.println("Enter "+n+" values");
		for(int i=0;i<n;i++)
		{
			x.add(sc.nextLine());
		}
		System.out.println("Before sorting");
		for(int i=0;i<n;i++)
		{
			System.out.print(x.get(i)+" ");
		}
		System.out.println();
		//bubble sort
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(x.get(j).compareTo(x.get(j+1))>0)
				{
					String temp=x.get(j);
					x.set(j,x.get(j+1));
					x.set(j+1,temp);
				}
			}
		}
		System.out.println("After sorting");
		for(int i=0;i<n;i++)
		{
			System.out.print(x.get(i)+" ");
		}	
	}
}

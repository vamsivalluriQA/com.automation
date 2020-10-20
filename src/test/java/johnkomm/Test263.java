package johnkomm;

import java.util.ArrayList;
import java.util.Scanner;

public class Test263 
{
	public static void main(String[] args)
	{
		//Declare dynamic array
		ArrayList<Integer> x=new ArrayList<Integer>();
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=sc.nextInt();
		System.out.println("Enter "+n+" values");
		for(int i=0;i<n;i++)
		{
			x.add(sc.nextInt());
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
				if(x.get(j)>x.get(j+1))
				{
					int temp=x.get(j);
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
		System.out.println();
		System.out.println("largest is "+x.get(n-1));
		System.out.println("second largest is "+x.get(n-2));
		System.out.println("smallest is "+x.get(0));	
	}
}







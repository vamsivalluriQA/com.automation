package johnkomm;

import java.util.ArrayList;
import java.util.Scanner;

public class Test264
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
		System.out.println("Before delete duplicate values");
		for(int i=0;i<n;i++)
		{
			System.out.print(x.get(i)+" ");
		}
		System.out.println();
		//delete duplicate values
		for(int i=0;i<n;i++)
		{
			//every value compare with next value up to last
			for(int j=i+1;j<n;j++)
			{
				if(x.get(i)==x.get(j))
				{
					x.remove(j);
					n--;
				}
			}
		}
		System.out.println("After deletion");
		for(int i=0;i<n;i++)
		{
			System.out.print(x.get(i)+" ");
		}
	}
}







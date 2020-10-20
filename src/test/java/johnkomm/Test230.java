package johnkomm;

import java.util.Scanner;
public class Test230
{
	public static void main(String[] args)
	{
		//Take two string values
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two string values");
		String x=sc.nextLine();
		String y=sc.nextLine();
		System.out.println("Before Swap:");
		System.out.println(x);
		System.out.println(y);
		//swap
		String temp="";
		temp=x;
		x=y;
		y=temp;
		System.out.println("After Swap:");
		System.out.println(x);
		System.out.println(y);
	}
}

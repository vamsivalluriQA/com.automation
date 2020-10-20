package johnkomm;

import java.util.Scanner;

public class Test212
{
	public static void main(String[] args)
	{
		//Take a number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		sc.close();
		//Check that number
		if(x<0)
		{
			x=x*(-1);
		}
		//Display number
		System.out.println(x);
	}
}









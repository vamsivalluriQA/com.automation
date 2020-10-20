package johnkomm;

import java.util.Scanner;

public class Test213
{
	public static void main(String[] args)
	{
		//Take a number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		sc.close();
		//check for even or odd
		if(x%2==0)
		{
			System.out.println(x+" is even number");
		}
		else
		{
			System.out.println(x+" is odd number");
		}
	}
}





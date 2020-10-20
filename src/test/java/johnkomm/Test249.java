package johnkomm;

import java.util.Scanner;

public class Test249
{
	public static void main(String[] args)
	{
		//Take a number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int n=sc.nextInt();
		int temp=n;
		int r=0;
		while(n!=0)
		{
			int d=n%10;
			r=r*10+d;
			n=n/10;
		}
		if(temp==r)
		{
			System.out.println(temp+" is palindrome");
		}
		else
		{
			System.out.println(temp+" is not palindrome");
		}

	}
}









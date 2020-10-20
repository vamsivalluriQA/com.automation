package johnkomm;

import java.util.Scanner;

public class Test248
{
	public static void main(String[] args)
	{
		//Take a number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int n=sc.nextInt();
		int temp=n;
		while(n>9)
		{
			int sum=0;
			while(n!=0)
			{
			   int d=n%10;
			   sum=sum+d;
			   n=n/10;
		    }
			n=sum;
		}
		System.out.println("sum of digits in "+temp+" upto single digit is "+n);
	}
}





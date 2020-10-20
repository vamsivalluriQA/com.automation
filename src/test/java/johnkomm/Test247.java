package johnkomm;

import java.util.Scanner;

public class Test247
{
	public static void main(String[] args)
	{
		//Take a number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		long n=sc.nextInt();
		long temp=n;
		int nod=0;
		while(n!=0)
		{
			int d=(int) (n%10);
			nod++;
			n=n/10;
		}
		System.out.println("No: of digits in "+temp+" is "+nod);
	}
}









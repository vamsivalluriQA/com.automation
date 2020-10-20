package johnkomm;

import java.util.Scanner;

public class Test253
{
	public static void main(String[] args)
	{
		//Take a number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int n=sc.nextInt();
		int temp=n;
		String binary="";
		while(n!=0)
		{
			int r=n%2;
			binary=r+binary; //add remainder at front of existing binary code
			n=n/2;
		}
		System.out.println(temp+" binary value is "+binary);	
	}
}

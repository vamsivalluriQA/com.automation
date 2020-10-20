package johnkomm;

import java.util.Scanner;

public class Test250 
{
	public static void main(String[] args)
	{
		//Take a number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int n=sc.nextInt();
		int temp=n;
		//Calculate no: of digits in given number
		int nod=0;
		while(n!=0)
		{
			int d=(int) (n%10);
			nod++;
			n=n/10;
		}
		System.out.println("No: of digits in "+temp+" is "+nod);
		//Calculate sum of armstrong equation
		n=temp; //get back original number
		int value=0;
		while(n!=0)
		{
			int d=n%10;
			value=(int) (value+Math.pow(d,nod));
			n=n/10;
		}
		if(value==temp)
		{
			System.out.println(temp+" is Armstrong number");
		}
		else
		{
			System.out.println(temp+" is not Armstrong number");
		}
	}
}

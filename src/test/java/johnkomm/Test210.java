package johnkomm;

import java.util.Scanner;

public class Test210
{
	public static void main(String[] args)
	{
		//Way-1(Swap number type of values)
		//Take 2 values from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		System.out.println("Enter a number");
		int y=sc.nextInt();
		//Display before swap
		System.out.println(x+" "+y);
		sc.close(); //optional
		//swap
		x=x*y;
		y=x/y;
		x=x/y;
		//Display after swap
		System.out.println(x+" "+y);
	}
}






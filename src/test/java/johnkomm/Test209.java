package johnkomm;

import java.util.Scanner;

public class Test209
{
	public static void main(String[] args)
	{
		//Way-2(Swap number type of values only)
		//Take 2 values from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		System.out.println("Enter a number");
		int y=sc.nextInt();
		sc.close(); //optional
		//Display before swap
		System.out.println(x+" "+y);
		//swap
		x=x+y;
		y=x-y;
		x=x-y;
		//Display after swap
		System.out.println(x+" "+y);
	}
}






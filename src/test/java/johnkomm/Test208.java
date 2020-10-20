package johnkomm;

import java.util.Scanner;

public class Test208
{
	public static void main(String[] args)
	{
		//Way-1(Swap any type of values)
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
		int z;
		z=x;
		x=y;
		y=z;
		//Display after swap
		System.out.println(x+" "+y);
	}
}






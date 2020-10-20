package johnkomm;

import java.util.Scanner;

public class Test207
{
	public static void main(String[] args)
	{
		//Take a number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		sc.close(); //optional
		//multiply number with 2 (don't use *)
		int y=x<<1; //bitwise left shift operator
		System.out.println(y);
		//multiply number with 4 (don't use *)
		int z=x<<2; //bitwise left shift operator
		System.out.println(z);
		//multiply number with 8 (don't use *)
		int w=x<<3; //bitwise left shift operator
		System.out.println(w);
	}
}











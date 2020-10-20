package johnkomm;

import java.util.Scanner;

public class Test242
{
	public static void main(String[] args)
	{
		//Take a word
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		//reverse() method
		StringBuffer sb=new StringBuffer(x);
		StringBuffer y=sb.reverse();
		System.out.println(y);
	}
}








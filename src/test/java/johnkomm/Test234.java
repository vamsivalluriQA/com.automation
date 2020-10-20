package johnkomm;

import java.util.Scanner;

public class Test234
{
	public static void main(String[] args)
	{
		//Take a sentence
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a sentence");
		String x=sc.nextLine();
		x=x.trim();
		//logic-1
		String[] words=x.split(" "); //blank space
		System.out.println("No: of words is "+words.length);
		System.out.println("No: of spaces is "+(words.length-1));
	}
}










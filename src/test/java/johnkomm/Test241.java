package johnkomm;

import java.util.Scanner;

public class Test241
{
	public static void main(String[] args)
	{
		//Take a sentence
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a sentence");
		String x=sc.nextLine();
		//Take a char
		System.out.println("Enter a character");
		char y=sc.nextLine().charAt(0);
		//count of occurrences
		String temp1=x; //copy sentence 
		int l1=temp1.length(); //get count of chars in that sentence
		System.out.println(l1);
		String temp2=""; //empty string
		temp1=temp1.replace(temp2.valueOf(y),"");
		int l2=temp1.length(); //get count of chars in that sentence after replace
		System.out.println(l2);
		System.out.println(y+" occured "+(l1-l2)+" times ");
	}
}









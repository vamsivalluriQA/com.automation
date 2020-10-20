package johnkomm;

import java.util.Scanner;

public class Test244 
{
	public static void main(String[] args)
	{
		//Take a sentence
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a sentence");
		String x=sc.nextLine();
		//Split into words
		String y=""; //for output
		String[] words=x.split(" "); //blank space
		//reverse each word
		for(String word:words)
		{
			//reverse that word
			String temp="";
			for(int i=word.length()-1; i>=0; i--)
			{
				temp=temp+word.charAt(i);
			}
			//add reversed word to output
			y=y+temp+" ";
		}
		//Display output
		System.out.println(y.trim());
	}
}





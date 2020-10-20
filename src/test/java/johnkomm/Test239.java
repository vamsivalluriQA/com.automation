package johnkomm;

import java.util.HashMap;
import java.util.Scanner;

public class Test239 
{
	public static void main(String[] args)
	{
		//Take a sentence
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a sentence");
		String x=sc.nextLine();
		//if duplicate chars in different cases, get sentence into same case
		x=x.toLowerCase();
		//split sentence into chars
		char[] chars=x.toCharArray();
		//Create hash map to store chars and occurrences of those chars as pairs
		HashMap<Character, Integer> hm=new HashMap<Character, Integer>();
		for(char c:chars) //for all words in sentence
		{
			if(hm.containsKey(c)) //word already inserted into hash map
			{
				hm.put(c,hm.get(c)+1);
			}
			else
			{
				hm.put(c, 1);
			}
		}
		System.out.println(hm);
		for(char c:hm.keySet()) //for all inserted distinct chars in hash map
		{
			if(hm.get(c)>1)
			{
				System.out.println(c+" occured "+hm.get(c));
			}
		}
	}
}

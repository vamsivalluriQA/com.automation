package johnkomm;

import java.util.HashMap;
import java.util.Scanner;

public class Test238
{
	public static void main(String[] args)
	{
		//Take a sentence
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a sentence");
		String x=sc.nextLine();
		//if duplicate words in different cases, get sentence into same case
		x=x.toLowerCase();
		//split sentence into words
		String[] words=x.split(" "); //blank space is separator
		//Create hash map to store words and occurrences of those words as pairs
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		for(String word:words) //for all words in sentence
		{
			if(hm.containsKey(word)) //word already inserted into hash map
			{
				hm.put(word,hm.get(word)+1);
			}
			else
			{
				hm.put(word, 1);
			}
		}
		System.out.println(hm);
		for(String word:hm.keySet()) //for all inserted distinct words in hash map
		{
			if(hm.get(word)>1)
			{
				System.out.println(word+" occured "+hm.get(word));
			}
		}
	}
}














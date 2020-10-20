package johnkomm;

import java.util.HashMap;
import java.util.Map;

public class Test273
{
	public static void main(String[] args)
	{
		HashMap<Integer,String> hm=new HashMap<Integer,String>(); 
		hm.put(100,"Amit"); 
		hm.put(100,"Sumit"); // hash map allows duplicate key, but overwrite
		hm.put(101,"Vijay"); 
		hm.put(102,"Aijay"); 
		hm.put(null,"Rahul"); 
		System.out.println("-----------Hash map-----------"); 
		for (Map.Entry m:hm.entrySet())
		{ 
			System.out.println(m.getKey()+" "+m.getValue()); 
		}
		//Get value of specific key
		System.out.println(hm.get(102));
		//Change value for specific key
		hm.replace(102,"kalam");
		System.out.println(hm.get(102));
		//Change key for specific key
		hm.put(104,hm.remove(102));  //remove() returns corresponding value in removed pair
		System.out.println(hm.get(104));	
	}
}






package johnkomm;

import java.util.Random;

public class Test271
{
	public static void main(String[] args)
	{
		//generate Random numbers
		Random r=new Random();
		for(int i=0;i<5;i++)
		{
			System.out.println(r.nextInt(10));
		}
	}
}

package johnkomm;
import java.util.Scanner;
public class Test229
{
	public static void main(String[] args)
	{
		//Take a number
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		//check for even or odd
		int r=x%2; //get remainder
		if(r==0)
		{
			System.out.println(x+" is even");
		}
		else
		{
			System.out.println(x+" is odd");
		}
	}
}

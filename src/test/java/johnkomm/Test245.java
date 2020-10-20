package johnkomm;
import java.util.Scanner;

public class Test245
{
	public static void main(String[] args)
	{
		//Take a number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int n=sc.nextInt();
		int temp=n;
		long f=1;
		while(n!=0)
		{
			f=f*n;
			n--;
		}
		System.out.println("Factorial of "+temp+" is "+f);
	}
}









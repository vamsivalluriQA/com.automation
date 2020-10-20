package johnkomm;

import java.util.Scanner;

public class Test252 
{
	public static void main(String[] args)
	{
		//Take a number from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a binary number");
		int n=sc.nextInt();
		int decvalue=0; 
	    //Initializing base value to 1, means Math.pow(2,0) 
	    int base=1; 
	    int temp=n; 
	    while(n!=0) 
	    { 
	        int lastdigit=n%10; 
	        n=n/10;
	        decvalue=decvalue+lastdigit*base; 
	        base=base*2; 
	    } 
	    System.out.println(temp+" decial value is "+decvalue);
	}
}





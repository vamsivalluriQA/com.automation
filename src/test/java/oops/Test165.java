package oops;

public class Test165
{
	public static void main(String[] args)
	{
		System.out.println("I am real main");
		Test165.main("kalam");
		Test165 obj=new Test165();
		obj.main(56);
	}
	public static void main(String args)
	{
		System.out.println("i am static main and my value is "+args);
	}
	public void main(int args)
	{
		System.out.println("i am non static main and my value is "+args);
	}
}

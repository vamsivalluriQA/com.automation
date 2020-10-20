package oops;

public class Test162 
{
	public static void main(String[] args)
	{
		//Lambda expressions
		Sample9 obj1=(int x, int y)->{
			                             System.out.println(x+y);
		                             };
		obj1.arithmetic(10, 20);
		Sample9 obj2=(int x, int y)->{
			                             System.out.println(x-y);
		                             };
		obj2.arithmetic(10, 20);
	    Sample9 obj3=(int x, int y)->{
			                             System.out.println(x*y);
		                             };
		obj3.arithmetic(10, 20);
		Sample9 obj4=(int x, int y)->{
			                             System.out.println(x/y);
		                             };
		obj4.arithmetic(10, 20);
	}
}

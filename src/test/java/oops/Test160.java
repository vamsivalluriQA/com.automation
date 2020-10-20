package oops;

public class Test160
{
	public static void main(String[] args)
	{
		Sample8 obj=Sample8.initate(12,56); //calling static method using class name
		int temp=obj.addition(); //calling non-static method using object
		System.out.println(temp);
	}
}

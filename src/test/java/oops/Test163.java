package oops;

public class Test163
{
	public static void main(String[] args)
	{
		Sample11 obj2=new Sample11();
		System.out.println(obj2.q);  //10-direct access
		System.out.println(obj2.obj1.p); //20-indirect access
	}
}

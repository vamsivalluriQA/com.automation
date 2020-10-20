package oops;

public class Test159 
{
	public static void main(String[] args)
	{
		Myabstract obj1=new Myconcrete(67,89);
		System.out.println(obj1.addition());
		System.out.println(obj1.subtract());
		Myconcrete obj2=new Myconcrete(67,89);
		System.out.println(obj2.addition());
		System.out.println(obj2.subtract());
		System.out.println(obj2.mutiply());
	}
}







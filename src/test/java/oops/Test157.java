package oops;

public class Test157
{
	public static void main(String[] args)
	{
		Sample6.iname="magnitia";
		Sample6 obj1=new Sample6();
		obj1.sname="kalam";
		obj1.age=93;
		Sample6 obj2=new Sample6();
		obj2.sname="steve";
		obj2.age=73;	
		obj1.iname="india";  //magnitia changed to india
		System.out.println(obj2.iname); //output is india
	}
}

package oops;

import oops.Sample12;
import oops.Sample13;

public class Test164 
{
	public static void main(String[] args)
	{
		Sample12 obj1=new Sample12();
		obj1.method1(); //parent method1
		obj1.method2(); //parent method2
		Sample13 obj2=new Sample13();
		obj2.method1(); //child method1
		obj2.method2(); //parent method2
		Sample12 obj3=new Sample13();
		obj3.method1(); //child method1 due to dynamic binding
		obj3.method2(); //parent method2
	}
}








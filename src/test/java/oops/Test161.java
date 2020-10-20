package oops;

public class Test161 
{
	public static void main(String[] args)
	{
		//Anonymous nested class1
		Myinterface obj1=new Myinterface()
				{
					public void display1() 
					{
						System.out.println("Hi");						
					}
					public void display2() 
					{
						System.out.println("kalam sir");						
					}
				};
		obj1.display1();
		obj1.display2();
		//Anonymous nested class2
		Myinterface obj2=new Myinterface()
		{
			public void display1() 
			{
				System.out.println("Bye");						
			}
			public void display2() 
			{
				System.out.println("steve sir");						
			}
		};
        obj2.display1();
        obj2.display2();
	}
}

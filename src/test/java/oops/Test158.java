package oops;

public class Test158
{
	public static void main(String[] args)
	{
		//Create object to interface using concrete class constructor
		Mymath obj1=new Square((float) 34.5);
		System.out.println(obj1.area());
		System.out.println(obj1.perimeter());
		//create object to concrete class directly
		Square obj2=new Square((float) 34.5);
		System.out.println(obj2.area());
		System.out.println(obj2.perimeter());
		//Create object to interface using concrete class constructor
		Mymath obj3=new Rectangle((float) 34.5, (float) 45.8);
		System.out.println(obj3.area());
		System.out.println(obj3.perimeter());
		//create object to concrete class directly
		Rectangle obj4=new Rectangle(34.5f,45.8f);  //alternative to float type casting
		System.out.println(obj4.area());
		System.out.println(obj4.perimeter());	
	}
}






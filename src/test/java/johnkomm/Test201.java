package johnkomm;
import java.util.Scanner;
public class Test201
{
	public void method1()
	{
		//pure variable declared and defined using primitive data type
		int x=10; 
		System.out.println(x);
		
		//pure object declared and defined using user defined data type(class)
		Scanner sc=new Scanner(System.in); 
		sc.nextLine();
		
		
		String y="kalam"; 
		System.out.println(y); //used like variable
		System.out.println(y.length()); //used like an object to call a method
		
		int[] w=new int[10]; 
		System.out.println(w[0]); //used like variable
		System.out.println(w.length); //used like an object to call a property
	}
}







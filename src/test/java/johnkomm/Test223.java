package johnkomm;

public class Test223
{
	public static void main(String[] args)
	{
		String[] x= {"happy","mothers","day"};
		String y=null; //empty string
		y=y.join("*",x);
		System.out.println(y);
	}
}

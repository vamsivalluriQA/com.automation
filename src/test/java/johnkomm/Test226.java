package johnkomm;

public class Test226
{
	public static void main(String[] args)
	{
		//Using "String" class
		String x="a"; //String x=new String("a");
		long sst=System.currentTimeMillis();
		for(int i=1;i<=10000; i++)
		{
			x=x+"a";
		}
		long set=System.currentTimeMillis();
		System.out.println("time for String class is "+(set-sst));
		//Using "StringBuffer" class
		StringBuffer y=new StringBuffer("a");
		long sbst=System.currentTimeMillis();
		for(int i=1;i<=10000; i++)
		{
			y=y.append("a");
		}
		long sbet=System.currentTimeMillis();
		System.out.println("time for StringBuffer class is "+(sbet-sbst));
		//Using StringBuilder class
		StringBuilder z=new StringBuilder("a");
		long sbust=System.currentTimeMillis();
		for(int i=1;i<=10000; i++)
		{
			z=z.append("a");
		}
		long sbuet=System.currentTimeMillis();
		System.out.println("Time for StringBuilder class is "+(sbuet-sbust));
	}
}

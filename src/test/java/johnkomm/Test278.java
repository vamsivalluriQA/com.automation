package johnkomm;

public class Test278
{
   public void finalize()
   {
	   System.out.println("Execution completed");
   }
	public static void main(String[] args)
	{
		Test278 obj=new Test278();
		obj=null;
		System.gc(); //explicit deallocation
	}
}







package johnkomm;

public class Test259 
{
	public static void main(String[] args)
	{
		//part-1(top horizontal line)
		for(int i=1;i<=10;i++)
		{
			System.out.print("-");
		}
		System.out.println();
		//part-2(left vertical and right vertical lines)
		for(int k=1;k<=8;k++)
		{
			for(int j=1;j<=10;j++)
			{
				if(j==1 || j==10)
				{
					System.out.print("|");
				}
				else
				{
				System.out.print(" ");
				}
			}
			System.out.println();
		}
		//part-3(bottom horizontal line)
		for(int i=1;i<=10;i++)
		{
			System.out.print("-");
		}
	}
}

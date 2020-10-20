package johnkomm;

public class Test222
{
	public static void main(String[] args)
	{
		String x="happy mothers day. But no need. Because every day is mothers day.";
		String[] y=x.split("."); //Separator is \\.
		//in java language, \\. means \.
		//in regular expressions, \. means "."
		//split() method argument is regular expression
		//We need to separate paragraph into sentences using "."
		int nos=y.length;
		System.out.println("No: of sentences in given paragraph is "+nos);
	}
}

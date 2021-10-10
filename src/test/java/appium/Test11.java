package tests;

import java.io.File;

import org.zeroturnaround.zip.ZipUtil;

public class Test11
{
	public static void main(String[] args)
	{
		File f=new File("E:\\ardphoneapptestresults.zip");
		File fo=new File("D:\\batch249");
		ZipUtil.unpack(f,fo);
	}
}

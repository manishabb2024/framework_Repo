package Practice1;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;

public class Test1 extends BaseClass 
{
@Test(groups="smoke")
public void ex1()
{
	System.out.println("hello test1");
}
@Test
public void ex2()
{
	System.out.println("hello test2");
}
}

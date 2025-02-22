package Practice1;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;

public class Test2 extends BaseClass {
	@Test(groups="smoke")
	public void ex3()
	{
		System.out.println("hello test3");
	}
	@Test(groups="Regression")
	public void ex4()
	{
		System.out.println("hello test4");
	}
}

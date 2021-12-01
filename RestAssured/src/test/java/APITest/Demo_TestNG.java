package APITest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo_TestNG {
	//before running any class/test if u want to run then we can use beforesuite
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("This is going to execute before any test");
	}

	@BeforeClass
	public void BC()
	{
		System.out.println("This will execute before class");
	}
	
	@BeforeMethod
	public void BM()
	{
		System.out.println("This is execute before every test ");
	}
	
	@BeforeTest
	public void BT()
	{
	System.out.println("This will run after test suite");
	}
	
	@org.testng.annotations.Test
	public void testcase1()
	{
		System.out.println("Test is my first testcase");
	}
	
	@Test
	public void tsetcase2()
	{
		System.out.println("This is my second test case");
		Assert.assertEquals("puja","puja");
	}
	
	@AfterTest
	public void AT()
	{
		System.out.println("This will execute after all the test");
	}
	
	@AfterMethod
	public void AM()
	{
		System.out.println("This will execute after every test");
	}
	@AfterClass
	public void AC()
	{
		System.out.println("This will execute after class");
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("This will execute at the end");
	}
}
	





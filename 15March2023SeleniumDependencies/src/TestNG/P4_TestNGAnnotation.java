package TestNG;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @Author -- Aditya Shinde Java + Selenium 27-Jun-2023 2:57:04 pm
 **/
public class P4_TestNGAnnotation {

	@BeforeSuite
	public void method1() {

		Reporter.log("Before suite method", true);
	}

	@BeforeTest
	public void method2() {

		Reporter.log("Before test method", true);
	}

	@BeforeClass
	public void method3() {

		Reporter.log("Before class method", true);
	}

	@BeforeMethod
	public void method4() {

		Reporter.log("Before-method method", true);
	}
	
	
	
	@AfterMethod
	public void method5() {
		
		Reporter.log("After-method method", true);
	}
	
	
	@AfterClass
	public void method6() {
		
		Reporter.log("After class method" , true);
		
	}
	
	@AfterTest
	public void method7() {
		
		Reporter.log("After test method" , true);
	}
	
	@AfterSuite
	public void method8() {
		
		Reporter.log("After suite method" , true);
	}

	
	@Test
	public void testcase1() {
		
		System.out.println("Test case number 1");
	}
	

	@Test
	public void testcase2() {
		
		System.out.println("Test case number 2");
	}
	

	@Test
	public void testcase3() {
		
		System.out.println("Test case number 3");
	}
	
	
	
	
	
	
}

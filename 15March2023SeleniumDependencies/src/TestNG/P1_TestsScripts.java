package TestNG;

import org.testng.annotations.Test;

/**
 * @Author -- Aditya Shinde Java + Selenium 26-Jun-2023 2:13:22 pm
 **/
public class P1_TestsScripts {

	@Test(priority = 0, enabled = false)
	public void testcase() {

		System.out.println("Test case 1");

	}

	@Test(priority = 1 , invocationCount = 10)
	public void aTestCase() {

		System.out.println("Test case 2");
	}

	@Test(priority = 2)
	public void bTestCase() {

		System.out.println("Test case 3");
	}
}

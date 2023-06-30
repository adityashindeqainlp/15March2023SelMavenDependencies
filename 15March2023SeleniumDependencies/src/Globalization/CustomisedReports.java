package Globalization;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @Author -- Aditya Shinde Java + Selenium 29-Jun-2023 3:08:46 pm
 **/
public class CustomisedReports {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReports.html");
		extentReports.attachReporter(sparkReporter);

		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("DemoTest");
		sparkReporter.config().setTimeStampFormat("dd-mm-yyyy , HH:MM:SS");

		extentReports.setSystemInfo("OS", "Windows");
		extentReports.setSystemInfo("Browser", "Chrome");
		extentReports.setSystemInfo("Org", "LP");

		ExtentTest test1 = extentReports.createTest("Test 1");
		test1.pass("This is pass test case");

		ExtentTest test2 = extentReports.createTest("Test 2");
		test2.log(Status.FAIL, "This is failed test case");

		extentReports.createTest("Test 3").skip("this is a skip test case");

		extentReports.flush();
		Desktop.getDesktop().browse(new File("extentReports.html").toURI());

	}

}

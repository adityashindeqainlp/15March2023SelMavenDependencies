package Log4j;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * @Author -- Aditya Shinde Java + Selenium 29-Jun-2023 1:33:53 pm
 **/
public class CustomisedReports {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports.html");
		extentReports.attachReporter(sparkReporter);

		ExtentTest test1 = extentReports.createTest("Test 1");
		test1.pass("This is pass test case");

		ExtentTest test2 = extentReports.createTest("Test 2");
		test2.log(Status.FAIL, "This is failed test case");

		ExtentTest test3 = extentReports.createTest("Test 3");
		test3.log(Status.SKIP, "This is skip test case");

		extentReports.flush();
		Desktop.getDesktop().browse(new File("reports.html").toURI());

	}

}

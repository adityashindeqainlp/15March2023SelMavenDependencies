package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 26-Jun-2023 2:36:00 pm
 **/

public class p2_TestScript2 {

	public static WebDriver driver;
	public static SoftAssert sa = new SoftAssert();

	public void browserLaunch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	public void urlValidation() {

		String url = driver.getCurrentUrl();
		AssertJUnit.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login123",
				"Validate URL of Login Page");
		Reporter.log("Url get matched and Test Case is Pass", true);
		sa.assertAll();
	}

	public void titleValidation() {

		String title = driver.getTitle();
		AssertJUnit.assertEquals(title, "OrangeHRM1", "Validate the title of page");
		Reporter.log("Title get matched & Test case is pass", true);
		sa.assertAll();
	}

	public void loginValidation() {

		driver.findElement(By.xpath("//*[@name='username']")).clear();
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).clear();
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		WebElement button = driver.findElement(By.xpath("//*[@type='submit']"));
		boolean check1 = button.isDisplayed();
		Reporter.log("Button is display on webpage", true);
		button.click();

	}


	@AfterMethod
	public void tearDown() throws InterruptedException {

		Thread.sleep(5000);
		driver.quit();
	}

}

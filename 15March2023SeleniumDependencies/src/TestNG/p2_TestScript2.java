package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 26-Jun-2023 2:36:00 pm
 **/
public class p2_TestScript2 {

	public static WebDriver driver;
	public static SoftAssert sa = new SoftAssert();

	@Test(priority = 0)
	public void browserLaunch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test(priority = 1)
	public void urlValidation() {

		String url = driver.getCurrentUrl();
		sa.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login123",
				"Validate URL of Login Page");
		Reporter.log("Url get matched and Test Case is Pass", true);
		sa.assertAll();
	}

	@Test(priority = 2)
	public void titleValidation() {

		String title = driver.getTitle();
		sa.assertEquals(title, "OrangeHRM1", "Validate the title of page");
		Reporter.log("Title get matched & Test case is pass", true);
		sa.assertAll();
	}

	@Test(priority = 3 , dependsOnMethods = {"urlValidation", "titleValidation"} ,alwaysRun = true)
	public void loginValidation() {

		driver.findElement(By.xpath("//*[@name='username']")).clear();
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).clear();
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		WebElement button = driver.findElement(By.xpath("//*[@type='submit']"));
		boolean check1 = button.isDisplayed();
		sa.assertTrue(check1, "Button validation");
		Reporter.log("Button is display on webpage", true);
		button.click();

	}

	@Test(priority = 4)
	public void tearDown() throws InterruptedException {

		Thread.sleep(5000);
		driver.quit();
	}

}

package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 27-Jun-2023 10:35:32 am
 **/
public class P2_1_HardAssertReporterLog {

	public static WebDriver driver;

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
		Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
				"Validate URL of Login Page");
		Reporter.log("Url get matched and Test Case is Pass", true);

	}

	@Test(priority = 2)
	public void titleValidation() {

		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM", "Validate the title of page");
		Reporter.log("Title get matched & Test case is pass", true);

	}

	@Test(priority = 3)
	public void loginValidation() {

		driver.findElement(By.xpath("//*[@name='username']")).clear();
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).clear();
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		WebElement button = driver.findElement(By.xpath("//*[@type='submit']"));
		boolean check1 = button.isDisplayed();
		Assert.assertTrue(check1, "Button validation");
		Reporter.log("Button is display on webpage", true);
		button.click();

	}

	@Test(priority = 4)
	public void tearDown() throws InterruptedException {

		Thread.sleep(5000);
		driver.quit();
	}

}

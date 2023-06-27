package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 27-Jun-2023 2:14:57 pm
 **/

@Listeners(TestNG.P6_TestNGListeners.class)

public class P3_GroupsAttributeWithIncludeAndExclude {

	public static WebDriver driver;
	public static SoftAssert sa = new SoftAssert();

	@Test(priority = 0, groups = { "smoke", "regression" })
	@Parameters("url")
	public void browserLaunch(String url) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(url);

	}

	@Test(priority = 1, groups = { "smoke" })
	public void urlValidation() {

		String url = driver.getCurrentUrl();
		sa.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
				"Validate URL of Login Page");
		Reporter.log("Url get matched and Test Case is Pass", true);

	}

	@Test(priority = 2, groups = { "smoke", "regression" })
	public void titleValidation() {

		String title = driver.getTitle();
		sa.assertEquals(title, "OrangeHRM", "Validate the title of page");
		Reporter.log("Title get matched & Test case is pass", true);

	}

	@Test(priority = 3, groups = "regression")
	@Parameters({ "username", "password" })
	public void loginValidation(String username, String password) {

		driver.findElement(By.xpath("//*[@name='username']")).clear();
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name='password']")).clear();
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
		WebElement button = driver.findElement(By.xpath("//*[@type='submit']"));
		boolean check1 = button.isDisplayed();
		sa.assertTrue(check1, "Button validation");
		Reporter.log("Button is display on webpage", true);
		button.click();

	}

	@Test(priority = 4, groups = { "smoke", "regression" })
	public void tearDown() throws InterruptedException {

		Thread.sleep(5000);
		driver.quit();
	}

}

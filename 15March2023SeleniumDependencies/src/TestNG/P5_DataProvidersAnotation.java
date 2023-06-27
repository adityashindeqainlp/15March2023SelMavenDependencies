package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 27-Jun-2023 3:37:22 pm
 **/
public class P5_DataProvidersAnotation {

	public static WebDriver driver;
	public static SoftAssert sa = new SoftAssert();

	@BeforeMethod
	public void browserLaunch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test(priority = 3, dataProvider = ("getData"))
	public void loginValidation(String username, String password) {

		driver.findElement(By.xpath("//*[@name='username']")).clear();
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name='password']")).clear();
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
		WebElement button = driver.findElement(By.xpath("//*[@type='submit']"));
		boolean check1 = button.isDisplayed();
		sa.assertTrue(check1, "Button validation");
		button.click();
		String url = driver.getCurrentUrl();
		sa.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		Reporter.log("Login functionality validation", true);
		sa.assertAll();

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {

		Thread.sleep(5000);
		driver.quit();
	}

	@DataProvider(name = "getData")
	public Object[][] getData() {

		Object[][] data = new Object[4][2];

		data[0][0] = "Admin";
		data[0][1] = "admin123";

		data[1][0] = "Addmin";
		data[1][1] = "admin123";

		data[2][0] = "Admin";
		data[2][1] = "admin123456";

		data[3][0] = "Admin123";
		data[3][1] = "adimin12345";

		return data;
		
		
		
		
		
		
		
	}
}

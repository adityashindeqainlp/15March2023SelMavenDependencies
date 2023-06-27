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
 * @Author -- Aditya Shinde Java + Selenium 27-Jun-2023 1:34:34 pm
 **/
public class DataProviderAttribute {

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

	@Test(priority = 3, groups = { "regrssion" },dataProvider=("getData"))
	public void loginValidation(String username , String password ) {

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
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

	@DataProvider(name="getData")
	public Object[][] getData() {
         Object [][] data = new Object [4][2];
         
         data[0][0] = "Admin";
         data[0][1] = "admin123";
         
         data[1][0]= "Admini";
         data[1][1]= "admin123";
	
         data[2][0]= "Admin";
         data[2][1]= "admin1234";
         
         data[3][0]="admeen";
         data[3][1]="admin12345";
         
         return data;
	}
}

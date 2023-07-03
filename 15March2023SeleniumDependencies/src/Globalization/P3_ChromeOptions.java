package Globalization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 30-Jun-2023 2:28:07 pm
 **/
public class P3_ChromeOptions {

	public static ChromeOptions option;
	public static WebDriver driver;
	public static SoftAssert sa = new SoftAssert();

	@BeforeMethod
	public static void browserLaunch() {

		WebDriverManager.chromedriver().setup();

		option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		option.addArguments("--headless");
		option.addArguments("--disable-extensions");
		option.addArguments("--disable-popup-blocking");

		driver = new ChromeDriver(option);
       
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
	}

	@Test(priority = 0)
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
	public void tearDown() {

		driver.quit();
	}

}

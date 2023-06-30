package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 28-Jun-2023 2:36:41 pm
 **/
public class P1_LoginPageTest {

	public static WebDriver driver;
	SoftAssert sa = new SoftAssert();
	

	@Test
	public void launch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test
	public void loginValidation() {

		//Traditional page object model 
		/*P2_TraditionalPageObjectModel login = new P2_TraditionalPageObjectModel(driver);
		login.fillUsername("Admin");
		login.fillPassword("admin123");
		login.cilckOnButton();*/
		
		
		
		//new Page object model
		P3_NewPageObjectModel login1 = new P3_NewPageObjectModel(driver);
		login1.fillUsername("Admin");
		login1.fillPassword("admin123");
		login1.clickOnButton();
		String actualUrl = driver.getCurrentUrl();
		sa.assertEquals(actualUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        sa.assertAll();
       
	}

	@Test
	public void tearDown() throws InterruptedException {

		Thread.sleep(5000);
		driver.quit();
	}

}

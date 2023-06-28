package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 28-Jun-2023 10:36:26 am
 **/
public class LoginPageTestCase {

	public static WebDriver driver;

	@Test
	public void launch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	public void login() {

		NewPageObjectModel login = new NewPageObjectModel(driver);

		login.setUsername("Admin");
		login.setPassword("admin123");
		login.clickOnButton();
	}

	@Test
	public void tearDown() throws InterruptedException {

		Thread.sleep(4000);
		driver.quit();
	}

}

package NewCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 31-Aug-2023 5:08:14 pm
 **/
public class P13_CheckBoxOrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();

		driver.findElement(By.xpath("(//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")).click();

//		List<WebElement> checkBoxes = driver.findElements(
//				By.cssSelector("[class='orangehrm-container'] [class='oxd-icon bi-check oxd-checkbox-input-icon']"));

		List<WebElement> checkBoxes = driver.findElements(
				By.xpath("//div[@class='orangehrm-container']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']"));

		for (int i = 1; i < checkBoxes.size(); i++) {

			checkBoxes.get(i).click();

		}

//		for (int i = 1; i < checkBoxes.size(); i++) {
//
//			if (i % 2 == 0) {
//				checkBoxes.get(i).click();
//			}
//  
//	}

		Thread.sleep(5000);

		driver.quit();

	}

}

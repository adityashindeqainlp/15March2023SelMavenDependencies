package AutoIT;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 22-Jun-2023 4:16:06 pm
 **/
public class Program1 {

	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");

		driver.findElement(By.xpath("//*[@value='File Upload']")).click();

		Thread.sleep(2500);
		Runtime.getRuntime().exec("D:\\Aditya_In_lp\\Selenium\\AutoItScript\\File2.exe");
		Thread.sleep(3000);

		driver.quit();

	}

}

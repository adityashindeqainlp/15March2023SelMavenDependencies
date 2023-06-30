package Globalization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 29-Jun-2023 2:45:06 pm
 **/
public class Configuration {

	public static WebDriver driver;

	public static void browserLaunch(String n, String url) {

		String name = n;

		if (name.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (name.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (name.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		File path = new File(".\\config.properties");

		FileInputStream fis = new FileInputStream(path);

		Properties prop = new Properties();

		prop.load(fis);

		browserLaunch(prop.getProperty("broswer"), prop.getProperty("url"));

		Thread.sleep(5000);
		
		driver.quit();

	}

}

package PageObjectModel;

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
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 29-Jun-2023 9:13:27 am
 **/
public class SampleBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String name;

	@BeforeSuite
	public static void configuration() throws IOException {

		File path = new File(".\\config.properties");
		FileInputStream fis = new FileInputStream(path);
		prop = new Properties();
		prop.load(fis);
	}
	

	public static WebDriver getDriver() {
		
		return driver;
	}


	public static void browserLaunch() {

		name = prop.getProperty("browser");

		if (name.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (name.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		else if (name.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		getDriver().manage().window().maximize();
		
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		getDriver().manage().deleteAllCookies();
		
		getDriver().get(prop.getProperty("url"));
		
	}

	
	
	
}

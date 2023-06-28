package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @Author -- Aditya Shinde Java + Selenium 28-Jun-2023 3:04:38 pm
 **/
public class P2_TraditionalPageObjectModel {

	//Initialize WebDriver at Global level
	public static WebDriver driver;

	//Create Constructor with Argument to initalize global driver with local driver using this keyword
	public P2_TraditionalPageObjectModel(WebDriver driver) {

		this.driver = driver;
	}
	
	//Locate elements 
	By usernameField =  By.xpath("//*[@name='username']");
	By passwordField = By.xpath("//*[@name='password']");
	By button = By.xpath("//*[@type='submit']");
	
	//Method for Operation 

	public void fillUsername(String username) {
		
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void fillPassword(String password) {
		
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void cilckOnButton() {
		
		driver.findElement(button).click();
	}
	
}

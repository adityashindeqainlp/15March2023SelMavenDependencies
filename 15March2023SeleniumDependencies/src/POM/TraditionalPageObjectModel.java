package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @Author -- Aditya Shinde Java + Selenium 28-Jun-2023 10:18:34 am
 **/
public class TraditionalPageObjectModel {

	public static WebDriver driver;
	
	//Initialize the driver
	public TraditionalPageObjectModel(WebDriver driver) {
		
		this.driver=driver;
	}
	
	//Locating The Element 
  By usrname =  By.xpath("//*[@name='username']");
  By password = By.xpath("//*[@name='password']");
  By button = By.xpath("//button[@type='submit']");
	
	
	//Methods to perform Task 
  
  public void setUsername(String user) {
	  
	  driver.findElement(usrname).sendKeys(user);
  }
	
  public void setPassword(String pwd) {
	  
	  driver.findElement(password).sendKeys(pwd);
  }
	
	
  public void clickOnButton() {
	  
	  driver.findElement(button).click();
  }
	
	
}

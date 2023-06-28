package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author -- Aditya Shinde Java + Selenium 28-Jun-2023 3:55:16 pm
 **/
public class P3_NewPageObjectModel {

	
	//Initialize the driver at global level 
	public static WebDriver driver;
	
	
	//Define Constructor with argument , then use PageFactory.initElements method to initialize driver  
	public P3_NewPageObjectModel(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locate the webElement by using @FindBy Annotation
	@FindBy(xpath= "//*[@name='username']")
	WebElement usernameField;
	
	@FindBy(xpath = "//*[@name='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement button;
	
	
	
	//Methods
	public void fillUsername(String username) {
		
		usernameField.sendKeys(username);
	}
	
	
	public void fillPassword(String password) {
		
		passwordField.sendKeys(password);
	}
	
	public void clickOnButton() {
		
		button.click();
	}
	
	
	
}

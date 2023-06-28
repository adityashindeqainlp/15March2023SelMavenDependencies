package POM;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author -- Aditya Shinde Java + Selenium 28-Jun-2023 10:53:46 am
 **/
public class NewPageObjectModel {

	public static WebDriver driver;

	// Initialize the driver using Page factory initElements Method
	public NewPageObjectModel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locate the element
	@FindBy(xpath = "//*[@name='username']")
	WebElement username;

	@FindBy(xpath = "//*[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement button;

	// Methods

	public void setUsername(String user) {

		username.sendKeys(user);
	}

	public void setPassword(String pwd) {

		password.sendKeys(pwd);
	}

	public void clickOnButton() {

		button.click();
	}

}

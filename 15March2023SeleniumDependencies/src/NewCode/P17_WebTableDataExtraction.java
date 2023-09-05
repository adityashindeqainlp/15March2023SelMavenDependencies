package NewCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Author -- Aditya Shinde Java + Selenium 01-Sep-2023 5:34:08 pm
 **/
public class P17_WebTableDataExtraction {

	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Step 1 Invoke Browser and Hit Url
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Step 2 Locate the table and then locate the cell which holds the data
		// Step 3 Once data located then store it in List with Generic <WebElement>
		List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody//tr//td[4]"));

		// Step 4 Define two variables For further application
		int number = 0;
		int valueFromMsg = 0;

		// Step 5 Use for each loop to extract an element from List
		for (WebElement value : values) {

			// Step 6 Using reference variable invoke getText method to extract Text from //
			// HTML DOM then print text in console
			String s = value.getText();
			System.out.println(s);

			// Step 7 Convert String to Number for perform arithmetic operations by using
			// local variable
			number = number + Integer.parseInt(s);

		}
        // Step 8 Print the sum of all amount data in console 
		System.out.println("Sum of all amount : " + number);

		
		// Step 9 Locate the comment on the webPage store it in variable 
		WebElement commentFromBuild = driver.findElement(By.xpath("//div[@class='totalAmount']"));

		// Step 10 Using reference variable invoke getText method to capture text from HTML DOM
		String msg = commentFromBuild.getText();

		// Step 11 Using reference variable  of string invoke split function to make an array of String
		String[] words = msg.split("\\s");

		// Step 12 Use For loop to extract single strings from string array
		for (String word : words) {

		// Step 13 Provide a conditional statement to convert String to integer	
			if (word.equals("296")) {

				valueFromMsg = Integer.parseInt(word);
			}
		}
		System.out.println("Value from comment of build : " + valueFromMsg);

		
	   // Step 14 Compare sum of all data from table and Value mention in comment 	
		if (number == valueFromMsg) {

			System.out.println("Total Amount and the total calaculation of data is mataching ");

		} else {

			System.out.println("Total Amount and the total calaculation of data is not mataching ");
		}

		driver.quit();

	}

}

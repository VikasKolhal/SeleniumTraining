package examples_through_utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SeleniumUtility;

public class OpenGoogle {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
       WebDriver driver= s1.setUp("chrome", "https://www.google.com");
       WebElement searchInputField=driver.findElement(By.name("q"));
       s1.typeInput(searchInputField, "java");
	}

}

package examples_through_utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumUtility;

public class Login_ActiTime {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
		WebDriver driver=s1.setUp("chrome", "https://demo.actitime.com");
		s1.typeInput(driver.findElement(By.id("username")), "admin");
		s1.typeInput(driver.findElement(By.name("pwd")), "manager");
		s1.performClick(driver.findElement(By.id("loginButton")));
	}

}

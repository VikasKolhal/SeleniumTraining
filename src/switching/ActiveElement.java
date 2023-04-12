package switching;

import java.sql.Driver;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SeleniumUtility;

public class ActiveElement {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
      WebDriver driver=  s1.setUp("chrome", "https://demo.actitime.com/login.do");
      WebElement element=  driver.switchTo().activeElement();
      String exp=element.getAttribute("placeholder");
      if(exp.equals("Username")) {
    	  System.out.println("Mouse pointer is in username field");
      }
      element.sendKeys("admin",Keys.TAB);
      WebElement element1=driver.switchTo().activeElement();
      String exp1=element1.getAttribute("placeholder");
      if(exp1.equals("Password")) {
    	  System.out.println("Mouse pointer is in password field");
      }
      element1.sendKeys("manager",Keys.ENTER);
	}

}

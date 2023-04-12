package js_examples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumUtility;

public class Example3 extends SeleniumUtility {

	public static void main(String[] args) {
		Example3 e3=new Example3();
         e3.testcase1();
	}
	public void testcase1() {
		WebDriver driver=setUp("chrome","https://www.flipkart.com");
		//driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2500)");
		//js.executeScript("window.scrollBy(0,-2500)");
		js.executeScript("window.scrollBy(500,0)");
	}

} 

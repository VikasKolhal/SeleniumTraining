package js_examples;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumUtility;

public class Example2 extends SeleniumUtility{

	public static void main(String[] args) {
		Example2 e2=new Example2();
		e2.testCase1();

	}
	public void testCase1() {
		WebDriver driver=setUp("chrome","https://demo.actitime.com/login.do");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('username').value='admin'");
		js.executeScript("document.getElementsByName('pwd')[0].value='manager'");
		js.executeScript("document.getElementById('loginButton').click();");
	}

}

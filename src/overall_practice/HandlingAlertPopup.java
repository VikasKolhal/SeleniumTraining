package overall_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumUtility;

public class HandlingAlertPopup {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
		WebDriver driver=s1.setUp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		driver.switchTo().frame("iframeResult");
	//	driver.findElement(By.xpath("//button[text()='Try it']")).click();
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		System.out.println("Alert text msg is: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}

}

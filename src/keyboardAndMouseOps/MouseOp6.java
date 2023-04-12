package keyboardAndMouseOps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.SeleniumUtility;

public class MouseOp6 {

	public static void main(String[] args) throws InterruptedException {
		SeleniumUtility s1=new SeleniumUtility();
		WebDriver driver=s1.setUp("chrome", "https://www.flipkart.com");
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		List<WebElement> menu=driver.findElements(By.xpath("//div[@class='_331-kn _2tvxW']/div/div/div"));
		Actions act=new Actions(driver);
		//act.moveToElement(menu.get(5)).perform();
		for(int i=0;i<menu.size();i++) {
			act.moveToElement(menu.get(i)).perform();
		 Thread.sleep(2000);
		}
		
		
	}

}

package switching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.SeleniumUtility;

public class HandlingFrames_2 {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
      WebDriver driver = s1.setUp("chrome", "https://jqueryui.com");
      driver.findElement(By.xpath("//a[text()='Droppable']")).click();
      WebElement element=driver.findElement(By.cssSelector(".demo-frame"));
      driver.switchTo().frame(element);
      WebElement src=driver.findElement(By.cssSelector(".ui-widget-content"));
      WebElement target= driver.findElement(By.cssSelector(".ui-widget-header"));
      Actions act=new Actions(driver);
      act.dragAndDrop(src, target).perform();
      driver.switchTo().defaultContent();
      driver.findElement(By.cssSelector(".logo")).click();
      
	}

}

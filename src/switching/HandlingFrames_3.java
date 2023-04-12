package switching;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.SeleniumUtility;

public class HandlingFrames_3 {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
	    WebDriver driver = s1.setUp("chrome", "https://jqueryui.com");
	    driver.findElement(By.xpath("//a[text()='Sortable']")).click(); 
	    driver.switchTo().frame(0);
	    
	    List<WebElement> sourceList=driver.findElements(By.cssSelector(".ui-sortable>li"));
	   
	   // WebElement target=driver.findElement(By.cssSelector(".ui-sortable>li:nth-of-type(1)"));
	    for(int i=0;i<sourceList.size()-1;i++) {
	    	 s1.wait.until(ExpectedConditions.visibilityOfAllElements(sourceList));
	    s1.performDranAndDrop(sourceList.get(sourceList.size()-1), sourceList.get(i));
	    sourceList=driver.findElements(By.cssSelector(".ui-sortable>li"));
	    }
	    
	}

}

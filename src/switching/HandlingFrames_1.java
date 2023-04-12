package switching;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.SeleniumUtility;

public class HandlingFrames_1 {

	public static void main(String[] args) throws InterruptedException {
		SeleniumUtility s1=new SeleniumUtility();
    WebDriver driver=s1.setUp("chrome", "https://www.globalsqa.com/demo-site/draganddrop/");
    WebElement element=driver.findElement(By.cssSelector(".demo-frame.lazyloaded"));
    driver.switchTo().frame(element);
    List<WebElement> photoSource=driver.findElements(By.cssSelector(".ui-widget.ui-helper-clearfix>ul>li"));
    WebElement phototarget=driver.findElement(By.cssSelector(".ui-widget-content.ui-state-default.ui-droppable"));
   // Actions act=new Actions(driver);
  //  act.dragAndDrop(photoSource.get(0), phototarget).perform();
  //  act.dragAndDrop(photoSource.get(2), phototarget).perform();
    for(int i=0;i<photoSource.size();i++) {
    	//act.dragAndDrop(photoSource.get(i), phototarget).perform();
    	//performDranAndDrop(act,photoSource.get(i),phototarget);
    	s1.wait.until(ExpectedConditions.visibilityOfAllElements(photoSource));
    	s1.performDranAndDrop(photoSource.get(i), phototarget);
    }
    
   // static void performDranAndDrop(Actions action,WebElement e1, WebElement e2) {
    //	action.dragAndDrop(e1, e2).perform();
	//}
	}
}

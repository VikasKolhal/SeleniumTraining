package keyboardAndMouseOps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.SeleniumUtility;

public class MouseOp7 {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
       WebDriver driver= s1.setUp("Chrome", "https://www.flipkart.com");
       driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		List<WebElement> menu=driver.findElements(By.xpath("//div[@class='_331-kn _2tvxW']/div/div/div"));
		Actions act=new Actions(driver);
		mouseHover(act,menu);
		mouseHoverIntheElement(act,menu.get(3));
		act.moveToElement(menu.get(1)).contextClick().sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
	}
	static void mouseHover(Actions action,List<WebElement> element) {
		for(int i=0;i<element.size();i++) {
			action.moveToElement(element.get(i)).perform();
		}
	}
	static void mouseHoverIntheElement(Actions action,WebElement element) {
		action.moveToElement(element).perform();
	}
}

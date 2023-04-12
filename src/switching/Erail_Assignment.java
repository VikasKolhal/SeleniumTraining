package switching;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.SeleniumUtility;

public class Erail_Assignment {

	public static void main(String[] args) {
		SeleniumUtility s1= new SeleniumUtility();
        WebDriver driver=s1.setUp("chrome", "https://erail.in");
        driver.findElement(By.cssSelector("#divMainWrapper>div>div:nth-of-type(3)>a:nth-of-type(4)")).click();
       String homePageWinID= driver.getWindowHandle();
       Set<String> allWinIds=driver.getWindowHandles();
       allWinIds.remove(homePageWinID);
       Iterator<String> itr=allWinIds.iterator();
       String nextWindow=itr.next();
       driver.switchTo().window(nextWindow);
       
       WebElement searchOption=driver.findElement(By.cssSelector(".text-lg.shadow-6dp"));
       searchOption.click();
       searchOption.sendKeys("12627");
       driver.findElement(By.cssSelector(".body-3.h-10.w-full.px-4.text-left.leading-relaxed.text-gray-60 ")).click();
       
      WebElement calender= driver.findElement(By.xpath("//input[@type='date']"));
      calender.click();
      calender.sendKeys(Keys.DOWN);
      calender.sendKeys(Keys.DOWN);
      calender.sendKeys(Keys.DOWN);
      calender.sendKeys(Keys.DOWN);
      calender.sendKeys(Keys.DOWN);
      calender.sendKeys(Keys.DOWN);
      
      WebElement dropDown=driver.findElement(By.xpath("//select[@placeholder='Boarding Station']"));
       
      Select selectDropDown=new Select(dropDown);
      selectDropDown.selectByVisibleText("ET");
      driver.findElement(By.cssSelector(".btn-primary.w-full")).click();
     WebElement text= driver.findElement(By.cssSelector(".text-gray-60.text-base.tracking-wide"));
     System.out.println("after find caterimg:"+text.getText());

	}

}

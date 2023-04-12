package keyboardAndMouseOps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyboardOps4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
      WebElement element=  driver.findElement(By.xpath("//body"));
      element.sendKeys(Keys.ESCAPE);
      
      Thread.sleep(1500);
      element.sendKeys(Keys.END);
      
      Thread.sleep(1500);
      element.sendKeys(Keys.HOME);	
      
      Thread.sleep(1500);
      element.sendKeys(Keys.END);
      
      Thread.sleep(1500);
      
      
      for(int i=0;i<10;i++) {
    	  element.sendKeys(Keys.PAGE_UP);
      }
      
	}

}

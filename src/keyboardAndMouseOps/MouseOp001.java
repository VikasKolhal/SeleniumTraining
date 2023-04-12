package keyboardAndMouseOps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOp001 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");

		Actions act=new Actions(driver);
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("admin");
     act.doubleClick(firstName).perform();
     firstName.sendKeys(Keys.chord(Keys.CONTROL,"c"));
		//act.moveToElement(firstName).doubleClick().build().perform();
     
     WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
     act.moveToElement(lastName).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
  

	}

}

//mix operations

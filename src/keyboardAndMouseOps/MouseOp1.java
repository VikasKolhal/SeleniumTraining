package keyboardAndMouseOps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOp1 {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://demo.automationtesting.in/Register.html");
    WebElement userName=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
    userName.sendKeys("admin");
    Actions act=new Actions(driver);
   act.moveToElement(userName).doubleClick().keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
   
    WebElement lastName= driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
  act.moveToElement(lastName).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
   
    
}
}

//all with mouse operations
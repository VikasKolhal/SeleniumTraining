package keyboardAndMouseOps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyboardOps5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		
	//	driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.F5);
		
		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.F5);
	}

}

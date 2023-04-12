package keyboardAndMouseOps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyboardOps2 {

	public static void main(String[] args) {
		String chromeExePath=System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin",Keys.TAB);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("manager",Keys.ENTER);
		

	}

}

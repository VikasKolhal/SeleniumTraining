package overall_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class saucedemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        
      String[] usernames=  driver.findElement(By.id("login_credentials")).getText().split("\n");
      String[] password=driver.findElement(By.cssSelector(".login_password")).getText().split("\n");
      
      driver.findElement(By.id("user-name"));
      driver.findElement(By.id("password"));
      driver.findElement(By.id("login-button"));
	}

}

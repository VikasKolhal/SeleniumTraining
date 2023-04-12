package keyboardAndMouseOps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyboardOps3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		
		WebElement firstname=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstname.sendKeys("admin",Keys.chord(Keys.CONTROL,"a"));
		firstname.sendKeys(Keys.chord(Keys.CONTROL,"c"));
		
		
		
		WebElement lastName=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lastName.sendKeys(Keys.chord(Keys.CONTROL,"v"));
		
	}

}

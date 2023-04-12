package keyboardAndMouseOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOp2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/");
		List<WebElement> mainMenu=driver.findElements(By.xpath("//div[@id='menu']/ul/li"));
		System.out.println("Main Menu option count: " + mainMenu.size());
		Actions act = new Actions(driver);
		//act.moveToElement(mainMenu.get(1)).perform();
		for(int i=0;i<mainMenu.size();i++) {
			WebElement option=mainMenu.get(i);
			act.moveToElement(option).perform();
		}
	}
	
	
	

}

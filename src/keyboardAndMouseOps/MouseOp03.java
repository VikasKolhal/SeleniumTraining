package keyboardAndMouseOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOp03 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/");
		List<WebElement> mainMenu=driver.findElements(By.xpath("//div[@id='menu']/ul/li"));
		List<WebElement> firstStep=driver.findElements(By.xpath("//div[@class='row price_table_holder col_4']/div[1]/ul/li"));
         Actions act=new Actions(driver);
        // mouseHover(act,mainMenu);
        // mouseHover(act,firstStep);
         //mouseHoverOnTheElement(act,mainMenu.get(2));
         rightClick(act,mainMenu.get(2));
	}
	
	static void mouseHover(Actions A,List<WebElement> menu) throws InterruptedException {
		for(int i=1;i<menu.size();i++) {
			WebElement options=menu.get(i);
			A.moveToElement(options).perform();
			Thread.sleep(2000);			
			System.out.println(options.getText());
			
		}
		System.out.println(menu.size());
	}
	
	static void mouseHoverOnTheElement(Actions A,WebElement Element) {
		A.moveToElement(Element).perform();
	}
   static void rightClick(Actions a,WebElement Element) {
	   System.out.println("Option name is : " + Element.getText());
	   a.moveToElement(Element).contextClick().build().perform();
	   a.moveToElement(Element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	   // a.contextClick(Element).build().perform();
   }
}

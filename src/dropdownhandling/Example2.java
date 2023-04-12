package dropdownhandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://thompsonsj.com/bootstrap-select-dropdown");
        driver.findElement(By.id("bsd1-button")).click();	
        List<WebElement>element =driver.findElements(By.cssSelector(".dropdown-menu.dropdown-menu-right.show>div>a"));
        System.out.println("count:"+element.size());
        
        for(int i=0;i<element.size();i++) {
        	if(element.get(i).getText().equals("Vanuatu")){
        		element.get(i).click();
        		break;
        	}
        	
        	
        }
        
        //element.get(2).click();
	}

}

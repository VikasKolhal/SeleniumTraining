package overall_practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumUtility;

public class HandlingWindow {

	public static void main(String[] args) {
		SeleniumUtility s1= new SeleniumUtility();
        WebDriver driver=s1.setUp("chrome", "https://etrain.info/in");
       String homePageWindId =driver.getWindowHandle();
       System.out.println("Home page window ID:"+homePageWindId);
       driver.findElement(By.cssSelector(".icon-linkedin")).click();
     Set<String> allWinds=driver.getWindowHandles();
       System.out.println("All  windows:"+allWinds);
       allWinds.remove(homePageWindId);
       System.out.println("after removing homeWidow:"+allWinds);
       Iterator<String> itr = allWinds.iterator();
     String childWindID=  itr.next();
     driver.switchTo().window(childWindID);
     System.out.println("Linkedin page title: " + driver.getTitle());
		System.out.println("Linkedin page ulr: " + driver.getCurrentUrl());
		driver.switchTo().window(homePageWindId);
		 System.out.println("Linkedin page title: " + driver.getTitle());
			System.out.println("Linkedin page ulr: " + driver.getCurrentUrl());
			driver.close();
		
       
	}

}

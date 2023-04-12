package com.redbusassignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example1 {

	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in");
        driver.findElement(By.cssSelector("#src")).click();
        driver.findElement(By.cssSelector("#src")).sendKeys("pune");
        driver.findElement(By.cssSelector(".autoFill.homeSearch>li:nth-of-type(2)>i")).click();
        driver.findElement(By.cssSelector("#dest")).sendKeys("goa");
        driver.findElement(By.cssSelector(".autoFill.homeSearch>li:nth-of-type(2)>i")).click();
        driver.findElement(By.cssSelector(".db.text-trans-uc")).click();
        driver.findElement(By.cssSelector(".next>button")).click();
        driver.findElement(By.cssSelector("tbody>tr:nth-of-type(4)>td:nth-of-type(2)")).click();
        driver.findElement(By.cssSelector("#search_btn")).click();
        
        
        driver.findElement(By.cssSelector(".dept-time.dt-time-filter>li:nth-of-type(1)>label:nth-of-type(1)")).click();
        List<WebElement> listOfBuses=driver.findElements(By.cssSelector(".row-sec.clearfix"));
        System.out.println("bus count:"+listOfBuses.size());
        for(int i=0;i<listOfBuses.size();i++) {
        	System.out.println(listOfBuses.get(i).getText());
        }
	}

}

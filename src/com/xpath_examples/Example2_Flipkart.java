package com.xpath_examples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2_Flipkart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
        try {
        	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        }
        catch(Exception e){
        	System.out.println(e);
        }
        driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
        driver.findElement(By.xpath("//div[text()='SAMSUNG']")).click();
        List<WebElement> list=driver.findElements(By.xpath("//div[div[div[text()='SAMSUNG Galaxy F14 5G (B.A.E. Purple, 128 GB)']]]/div[2]/div/div[1]/div"));
        
       String str= list.get(0).getText();
       System.out.println("price of samsung 6 gb:"+str);
        
	}

}

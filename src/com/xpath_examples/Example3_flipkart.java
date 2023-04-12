package com.xpath_examples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example3_flipkart {

	public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.flipkart.com");
    try {
    	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
    }
    catch(Exception e) {
    	System.out.println(e);
    }
    
    driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
    driver.findElement(By.xpath("//img[@alt='GOOGLE']")).click();
    
    WebElement element=driver.findElement(By.xpath("//div[div[div[text()='Google Pixel 6a (Charcoal, 128 GB)']]]/div[2]/div[1]/div[1]/div"));
    String price=element.getText();
    System.out.println("price of Google Pixel 6a (Charcoal, 128 GB):"+price);
     
    List<WebElement> list=driver.findElements(By.xpath("//div[@class='_1YokD2 _3Mn1Gg']/div"));
    for(int i=0;i<list.size();i++) {
    	System.out.println(list.get(i).getText());
    }
	}

}

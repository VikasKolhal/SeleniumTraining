package com.xpath_examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1_demoblaze {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com");
        WebElement element=driver.findElement(By.xpath("//div[h4[a[text()='Samsung galaxy s6']]]//h5"));
       String name= element.getText();
       System.out.println(name);
	}

}

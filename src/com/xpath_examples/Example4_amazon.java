package com.xpath_examples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example4_amazon {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	List<WebElement> list=	driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
		for(int i=0;i<list.size();i++) {
			String s=list.get(i).getText();
			if(s.equals("Gift Cards")) {
				list.get(i).click();
			}
			else {
				System.out.println("**");
			}
		}
		

	}

}
//doubts in this problem
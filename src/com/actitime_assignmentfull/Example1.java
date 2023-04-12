package com.actitime_assignmentfull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get("https://demo.actitime.com/login.do");
       driver.findElement(By.id("username")).sendKeys("admin");
       driver.findElement(By.name("pwd")).sendKeys("manager");
       driver.findElement(By.id("loginButton")).click();
       
       //click on task
       
       driver.findElement(By.cssSelector(".content.tasks")).click();
	}

}

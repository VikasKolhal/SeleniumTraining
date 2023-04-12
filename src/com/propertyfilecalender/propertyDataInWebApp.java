package com.propertyfilecalender;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class propertyDataInWebApp {

	public static void main(String[] args) throws IOException {
		//load required property file
		FileInputStream fis=new FileInputStream(".\\testdata\\AppData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String appUrl= prop.getProperty("url");
	    String userName=prop.getProperty("username");
		String password =prop.getProperty("password");
		String expTitle=prop.getProperty("expectedHomepageTitle");
		
		System.out.println("App URL:"+appUrl);
		System.out.println("Username:"+userName);
		System.out.println("Password:"+password);
		System.out.println("expTitle:"+expTitle);

		
		
		
		
		
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appUrl);
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.name("pwd")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.titleIs(expTitle));
        
       // String expectedTitle="actiTIME - Enter Time-Track";
        String actualTitle=driver.getTitle();
        if(actualTitle.equals(expTitle)) {
        	System.out.println("Login successful");
        }
        else {
        	System.out.println("Either login got failed or page title got changed");
        }
	}

}

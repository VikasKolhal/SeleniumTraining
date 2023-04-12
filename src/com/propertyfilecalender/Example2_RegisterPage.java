
package com.propertyfilecalender;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Example2_RegisterPage {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\testdata\\RegisterPage.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys(prop.getProperty("address"));
		driver.findElement(By.cssSelector("input[ng-model='EmailAdress']")).sendKeys(prop.getProperty("emailAddress"));
		driver.findElement(By.cssSelector("input[ng-model='Phone']")).sendKeys(prop.getProperty("phone"));
		driver.findElement(By.cssSelector("div[id='msdd']")).click();
		
		if(prop.getProperty("gender").equals("male")) {
			driver.findElement(By.cssSelector("input[value='Male']")).click();
		}
		else {
			driver.findElement(By.cssSelector("input[value='FeMale']")).click();
		}
		
		
		if(prop.getProperty("hobbies").equals("cricket")) {
			driver.findElement(By.cssSelector("#checkbox1")).click();
		}
		else if(prop.getProperty("hobbies").equals("Movies")) {
			driver.findElement(By.cssSelector("#checkbox2")).click();
		}
		else {
			driver.findElement(By.cssSelector("#checkbox3")).click();
		}
		
		//driver.findElement(By.cssSelector("#msdd")).click();
		//driver.findElement(By.id("msdd")).click();
		
		
		WebElement dropdown=driver.findElement(By.id("Skills"));
		Select selectSkillDropDown=new Select(dropdown);
		
		List<WebElement> dropdownList=selectSkillDropDown.getOptions();
		for(int i=0;i<dropdownList.size();i++) {
			String str=dropdownList.get(i).getText();
			if(str.equals(prop.getProperty("Selectskills"))) {
				dropdownList.get(i).click();
				break;
			}
		}
		driver.findElement(By.cssSelector(".select2-selection")).click();
		List<WebElement> countryList=driver.findElements(By.cssSelector("span>ul>li"));
		for(int i=0;i<countryList.size();i++) {
			String country=countryList.get(i).getText();
			if(country.equals(prop.getProperty("country"))) {
				
				countryList.get(i).click();
				break;
			}
		}
		/*Select countryDropDown=new Select(driver.findElement(By.cssSelector("select#country")));
		List<WebElement> countryOptions=countryDropDown.getOptions();
		for(int i=0;i<countryOptions.size();i++) {
			String country=countryOptions.get(i).getText();
			if(country.equals(prop.getProperty("country")));{
				countryOptions.get(i).click();*/
			}
		
		
		}
		
	//List<WebElement> options=	driver.findElements(By.cssSelector("multi-select>div:nth-of-type(2)>ul>li"));
	//options.get(8).click();
	



package tushar_file_propertyfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Example1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("\\testdata\\RegisterPage.properties");
		Properties prop=new Properties();
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.cssSelector("#basicBootstrapForm>div>div>input")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.cssSelector("#basicBootstrapForm>div>div:nth-of-type(2)>input")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.cssSelector("#basicBootstrapForm>div:nth-of-type(2)>div>textarea")).sendKeys(prop.getProperty("address"));
		driver.findElement(By.cssSelector("#basicBootstrapForm>div:nth-of-type(3)>div>input")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.cssSelector("#basicBootstrapForm>div:nth-of-type(4)>div>input")).sendKeys(prop.getProperty("phoneNo"));
		
		if(prop.getProperty("gender").equals("Male")) {
			driver.findElement(By.cssSelector("#basicBootstrapForm>div:nth-of-type(5)>div label>input")).click();
		}
		else if(prop.getProperty("gender").equals("Female")){
			driver.findElement(By.cssSelector("#basicBootstrapForm>div:nth-of-type(5)>div>label:nth-of-type(2)>input")).click();
		}
		if(prop.getProperty("hobbies").equals("Cricket")) {
			driver.findElement(By.cssSelector("#basicBootstrapForm>div:nth-of-type(6)>div>div>input")).click();
		}
		else if(prop.getProperty("hobbies").equals("Movies")){
			driver.findElement(By.cssSelector("#basicBootstrapForm>div:nth-of-type(6)>div>div:nth-of-type(2)>input")).click();
		}
		else {
			driver.findElement(By.cssSelector("#basicBootstrapForm>div:nth-of-type(6)>div>div:nth-of-type(3)>input")).click();
		}
		
		driver.findElement(By.id("msdd")).click();
		List<WebElement> lang=driver.findElements(By.cssSelector("ul.ui-autocomplete>li"));
//		System.out.println("Language count: "+lang.size());
//		for(int i=0; i<lang.size();i++) {
//			System.out.println("Language name is: "+lang.get(i).getText());
//			
//		}
		for(int i=0; i<lang.size();i++) {
			String language=lang.get(i).getText();
			if (language.equals(prop.getProperty("lang"))) {
				lang.get(i).click();
				break;
			}}
		driver.findElement(By.cssSelector("#basicBootstrapForm>div:nth-of-type(7)>label")).click();
		driver.findElement(By.id("Skills")).click();
		List<WebElement> skills=driver.findElements(By.cssSelector("#Skills>option"));
		System.out.println("Skill count: "+skills.size());
//		for(int i=0; i<skills.size();i++) {
//			System.out.println("Skill name is: "+skills.get(i).getText());
//			
//			}
		for(int i=0; i<skills.size();i++) {
			String skill=skills.get(i).getText();
			if (skill.equals(prop.getProperty("skll"))) {
				skills.get(i).click();
				break;
			}}
		driver.findElement(By.cssSelector(".select2-selection")).click();
		List<WebElement> countryName=driver.findElements(By.cssSelector("#select2-country-results>li"));
		System.out.println("Country count: "+countryName.size());
		for(int i=1; i<countryName.size();i++) {
			String cntry=countryName.get(i).getText();
			if (cntry.equals(prop.getProperty("selectCountry"))) {
				countryName.get(i).click();
				break;
			}}
		WebElement yrarDrop=driver.findElement(By.cssSelector("#yearbox"));
		Select selectYearDrop = new Select(yrarDrop);
		List<WebElement> options = selectYearDrop.getOptions();
		System.out.println("Year's count: "+options.size());
		for(int i=1; i<options.size()-1;i++) {
			if (options.get(i).getText().equals(prop.getProperty("year"))) {
				options.get(i).click();
				break;
			}}
		List<WebElement> monthDrop=driver.findElements(By.cssSelector("#basicBootstrapForm>div:nth-of-type(11)>div:nth-of-type(2)>select>option"));
		System.out.println("Month's count: "+monthDrop.size());
		for(int i=0; i<monthDrop.size();i++) {
			if (monthDrop.get(i).getText().equals(prop.getProperty("month"))) {
				monthDrop.get(i).click();
				break;
			}}
		WebElement dayDrop=driver.findElement(By.cssSelector("#daybox"));
		Select days = new Select(dayDrop);
		List<WebElement> options1 = days.getOptions();
	
		System.out.println("Day's count: "+options.size());
		for(int i=1; i<options1.size()-1;i++) {
			if (options1.get(i).getText().equals(prop.getProperty("day"))) {
				options1.get(i).click();
				break;
			}}
		driver.findElement(By.cssSelector("#firstpassword")).sendKeys(prop.getProperty("psd"));
		driver.findElement(By.cssSelector("#secondpassword")).sendKeys(prop.getProperty("psd"));
	
	}}
		

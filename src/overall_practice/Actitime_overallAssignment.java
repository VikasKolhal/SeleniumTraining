package overall_practice;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtility;

public class Actitime_overallAssignment {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
		WebDriver driver=s1.setUp("chrome", "https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).sendKeys(Keys.ENTER);
		//click on tasks
		driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
		
		//click on add new
		driver.findElement(By.xpath("//div[@class='title ellipsis']")).click();
		
		//click on new task
		driver.findElement(By.xpath("//div[@class='item createNewTasks']")).click();
		
		//click on company
		/*
		FluentWait wait=new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);*/
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".customerSelector>div>div:nth-of-type(1)>div:nth-of-type(1)")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".customerSelector>div>div:nth-of-type(1)>div:nth-of-type(1)")));
		driver.findElement(By.cssSelector(".customerSelector>div>div:nth-of-type(1)>div:nth-of-type(1)")).click();
		
		
		
		//select company
		
		List<WebElement> companyList=driver.findElements(By.xpath("//div[@style='display: block; top: 30px; left: 0px;']/div/div[1]/div/div"));
		System.out.println(companyList.size());
		companyList.get(2).click();
		
		//click on project
		driver.findElement(By.cssSelector(".projectSelector >div>div:nth-of-type(1)>div:nth-of-type(1)>div")).click();
		
		List<WebElement> projectList=driver.findElements(By.cssSelector("div[class='projectSelector customerOrProjectSelector selectorWithPlaceholderContainer']>div>div:nth-of-type(2)>div>div:nth-of-type(1)>div>div"));
		
		projectList.get(3).click();
	}

}

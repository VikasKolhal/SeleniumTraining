package overall_practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtility;

public class Actitime_overallAssignment2_final {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
		WebDriver driver=s1.setUp("chrome", "https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).sendKeys(Keys.ENTER);
		//click on tasks
		driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
		
		//click on add new
		s1.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='title ellipsis']")));
		driver.findElement(By.xpath("//div[@class='title ellipsis']")).click();
		
		//click on new task
		driver.findElement(By.xpath("//div[@class='item createNewTasks']")).click();
		
		//List of company and projects
		List<WebElement>dropDowns=driver.findElements(By.cssSelector(".customerOrProjectSelector .selectedItem	"));
		dropDowns.get(0).click();
		
		List<WebElement> companyNames=driver.findElements(By.cssSelector("div[class='scrollableDropdownView'][style*='display'] div[class='searchItemList']>div"));
		System.out.println(companyNames.size());
		companyNames.get(2).click();
		//to avoid stalelement exception,below line
		dropDowns=driver.findElements(By.cssSelector(".customerOrProjectSelector .selectedItem	"));
		dropDowns.get(1).click();
		List<WebElement> projectList=driver.findElements(By.cssSelector("div[class='scrollableDropdownView'][style*='display'] div[class='searchItemList']>div"));
		System.out.println(projectList.size());
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='scrollableDropdownView'][style*='display'] div[class='searchItemList']>div")));
	//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='scrollableDropdownView'][style*='display'] div[class='searchItemList']>div")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='scrollableDropdownView'][style*='display'] div[class='searchItemList']>div"))))
		projectList.get(19).click();
		
		//enter task name
		driver.findElement(By.cssSelector(".createTasksTable>tbody>*:first-child>*:first-child>input")).sendKeys("QA-Testing-Task20");
		
		//creat test
		driver.findElement(By.xpath("//div[text()='Create Tasks']")).click();
		
		//get all task name
		List<WebElement> taskList=driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer tr>td:nth-of-type(2)"));
		
		//to store all taskname creat new aarraylit
		List<String> actualTaskName=new ArrayList<String>();
		for(int i=0;i<taskList.size();i++) {
			 taskList=driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer tr>td:nth-of-type(2)"));
			actualTaskName.add(taskList.get(i).getText());
		}
		System.out.println("actual task list:"+actualTaskName);
		System.out.println(actualTaskName.contains("QA-Testing-Task20"));
	}

}

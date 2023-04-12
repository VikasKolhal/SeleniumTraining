package tushar_file_propertyfile;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActiTimeTaskValidationAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.cssSelector(".pwdfield")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		String expectedTitle="actiTIME - Enter Time-Track";
		System.out.println("Home page validation: "+expectedTitle.equals(driver.getTitle()));
		
		driver.findElement(By.id("container_tasks")).click();
		String taskTitle="actiTIME - Task List";
		wait.until(ExpectedConditions.titleIs("actiTIME - Task List"));
		System.out.println("Task page validation: "+taskTitle.equals("actiTIME - Task List"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".addNewButton>div:nth-of-type(2)")));
		driver.findElement(By.cssSelector(".addNewButton>div:nth-of-type(2)")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".createNewTasks")));
		driver.findElement(By.cssSelector(".createNewTasks")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#createTasksPopup_content .selectCustomerRow .dropdownButton")));
		driver.findElement(By.cssSelector("#createTasksPopup_content .selectCustomerRow .dropdownButton")).click();//click on btn to see option in company dropdown
		List<WebElement> company=driver.findElements(By.cssSelector("#createTasksPopup_content .selectCustomerRow .scrollableDropdownView .searchItemList>div"));
		for(int i=0;i<company.size();i++) {
			if(company.get(i).getText().equals("Galaxy Corporation")) {
				company.get(i).click();
			}}
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".projectSelectorRow .dropdownButton")));
		driver.findElement(By.cssSelector(".projectSelectorRow .dropdownButton")).click();
		List<WebElement> project=driver.findElements(By.cssSelector(".projectSelectorRow .scrollableContainer .searchItemList>div"));
		for(int i=0;i<project.size();i++) {
			if(project.get(i).getText().equals("Android testing")) {
				project.get(i).click();
			}}
		//calender handling
		driver.findElement(By.cssSelector("#ext-gen45")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".x-date-right")));
		driver.findElement(By.cssSelector(".x-date-right")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".x-date-inner tbody>tr:nth-of-type(2)>td:nth-of-type(3) span")));
		driver.findElement(By.cssSelector(".x-date-inner tbody>tr:nth-of-type(2)>td:nth-of-type(3) span")).click();
		//to enter task name  
		driver.findElement(By.cssSelector(".nameCell>input")).click();
		driver.findElement(By.cssSelector(".nameCell>input")).sendKeys("Task_1_ActiTime");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Create Tasks']")));
		driver.findElement(By.xpath("//div[text()='Create Tasks']")).click();
	    //click on create task btn
		Thread.sleep(3000);
		List<WebElement> taskIsPresent=driver.findElements(By.cssSelector(".taskRow .names .title"));
		for(int i=0;i<taskIsPresent.size();i++) { 
			if(taskIsPresent.get(i).getText().equals("Task_1_ActiTime")) {
				driver.findElement(By.cssSelector(".taskRow .names .title"));
				System.out.println("Task_1_ActiTime is created");
				break;
			}
				else {
					System.out.println("Task_1_ActiTime is not created");
			}}
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".createdTasksTableContainer .img")));
		driver.findElement(By.cssSelector(".createdTasksTableContainer .img")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".delete")));
		driver.findElement(By.cssSelector(".delete")).click();
		driver.findElement(By.cssSelector(".deleteDialog .submitTitle")).click();		
		List<WebElement> taskIsPresentNow=driver.findElements(By.cssSelector(".taskRow .names"));
		for(int i=0;i<project.size();i++) { 
			if(taskIsPresentNow.get(i).getText().equals("Task_1_ActiTime")) {
				driver.findElement(By.cssSelector(".taskRow .names"));
				System.out.println("Task_1_ActiTime is deleted");
				break;
			}
				else {
					System.out.println("Task_1_ActiTime is not created");
			}}
		
	}
			
			
		
	
	



	}



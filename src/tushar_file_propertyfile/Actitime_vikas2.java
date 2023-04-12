package tushar_file_propertyfile;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actitime_vikas2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		//click on tasks
		driver.findElement(By.id("container_tasks")).click();
		//click on add new
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='title ellipsis']")));
		driver.findElement(By.cssSelector("div[class='title ellipsis']")).click();
		//clivk on new task
		driver.findElement(By.cssSelector("div[class='item createNewTasks']")).click();
		
		//click on company
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#createTasksPopup_content tbody>.selectCustomerRow:nth-of-type(1) .dropdownButton")));
		driver.findElement(By.cssSelector("#createTasksPopup_content tbody>.selectCustomerRow:nth-of-type(1) .dropdownButton")).click();
		
		//click on company
		List<WebElement> companyList=driver.findElements(By.cssSelector(" .customerSelector>.components_combobox.cpCombobox>.scrollableDropdownView .searchItemList>div"));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(companyList));
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".customerSelector>.components_combobox.cpCombobox>.scrollableDropdownView .searchItemList>div")));
		companyList.get(3).click();
		
		//click on project
		driver.findElement(By.cssSelector(".projectSelector .dropdownButton")).click();
		
		//project list
		List<WebElement> projectList=driver.findElements(By.cssSelector(".projectSelector>div> .scrollableDropdownView .searchItemList>div"));
		projectList.get(3).click();
		
		//calender handlaing
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//table[@class='x-btn-wrap x-btn at-dropdown-list-btn dateButton descendantEventsEmitter ancestorEventsListener  x-btn-over ']//em/button")));
	//	driver.findElement(By.cssSelector("//table[@class='x-btn-wrap x-btn at-dropdown-list-btn dateButton descendantEventsEmitter ancestorEventsListener  x-btn-over ']//em/button")).click();
		List<WebElement> setDeadLine=driver.findElements(By.cssSelector("button[id*='ext-gen']"));
		setDeadLine.get(0).click();
		List<WebElement> nextMonth=driver.findElements(By.cssSelector("a[id*='ext-gen']"));
		nextMonth.get(2).click();
		//driver.findElement(By.cssSelector("#ext-gen242")).click();
		driver.findElement(By.cssSelector(".x-date-inner tr:nth-of-type(4)>td:nth-of-type(3)>a span")).click();
		
		//enter task name
		driver.findElement(By.cssSelector(".tablePlaceholder>div>.taskTableContainer>table> tbody>tr:nth-of-type(1)>.nameCell.first>input")).sendKeys("QA-Testing-500");
		driver.findElement(By.xpath("//div[text()='Create Tasks']")).click();
		List<WebElement> taskList = driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		//taskList = driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		 //taskList = driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".tasksTableVerticalScrollContainer .title")));
	
		/*
		 * for(WebElement e:taskList) { taskList = driver.findElements(By.
		 * cssSelector(".tasksTableVerticalScrollContainer .title"));
		 * if(e.getText().equalsIgnoreCase("QA-Testing-JOB")) {
		 * 
		 * System.out.println("task is created"); } else {
		 * System.out.println("Task is not created"); } }
		 */
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.visibilityOfAllElements(taskList));
		  for(int i=0;i<taskList.size();i++) { 
			  
			  //driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		  //driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title")); 
			 // taskList =driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		 // wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".tasksTableVerticalScrollContainer .title")));
		//  taskList = driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		  if(taskList.get(i).getText().equals("QA-Testing-500")) {
		       driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		       wait.until(ExpectedConditions.textToBePresentInElement(taskList.get(i), "QA-Testing-500"));
		        System.out.println("task is created");
		       break;
		  }
		  
		  
		  }
		 
		driver.findElement(By.cssSelector(".createdTasksRowsTable .img")).click();
		driver.findElement(By.cssSelector(".delete.button")).click();
		driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();
		List<WebElement> taskList2=driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		taskList2=driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".tasksTableVerticalScrollContainer .title")));
		
		/*
		 * for(WebElement f:taskList2) {
		 * if(f.getText().equalsIgnoreCase("QA-Testing-JOB")) {
		 * System.out.println("task is not deleted"); } else {
		 * System.out.println("task is deleted"); } }
		 */
		
		
		  for(int i=0;i<taskList2.size();i++) { 
			  taskList2=driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".tasksTableVerticalScrollContainer .title")));
		  if(taskList2.get(i).getText().equals("QA-Testing-500")) {
		    taskList2=driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		        System.out.println("task is  not deleted");
		  
		  } 
		  else {
			  System.out.println("task is  deleted"); 
			  break;
			  } 
		  }
		 
	}




	}

//imp also

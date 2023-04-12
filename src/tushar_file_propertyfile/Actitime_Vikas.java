package tushar_file_propertyfile;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actitime_Vikas {

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
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='title ellipsis']")));
		driver.findElement(By.cssSelector("div[class='title ellipsis']")).click();
		//clivk on new task
		driver.findElement(By.cssSelector("div[class='item createNewTasks']")).click();
		
		//click on company
		driver.findElement(By.cssSelector("#createTasksPopup_content tbody>.selectCustomerRow:nth-of-type(1) .dropdownButton")).click();
		
		//click on company
		List<WebElement> companyList=driver.findElements(By.cssSelector(".customerSelector>.components_combobox.cpCombobox>.scrollableDropdownView .searchItemList>div"));
		
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".customerSelector>.components_combobox.cpCombobox>.scrollableDropdownView .searchItemList>div")));
		companyList.get(3).click();
		
		//click on project
		driver.findElement(By.cssSelector(".projectSelector .dropdownButton")).click();
		
		//project list
		List<WebElement> projectList=driver.findElements(By.cssSelector(".projectSelector>div> .scrollableDropdownView .searchItemList>div"));
		projectList.get(3).click();
		
		//calender handlaing
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='x-btn-wrap x-btn at-dropdown-list-btn dateButton descendantEventsEmitter ancestorEventsListener  x-btn-over ']//em/button")));
		//driver.findElement(By.xpath("//table[@class='x-btn-wrap x-btn at-dropdown-list-btn dateButton descendantEventsEmitter ancestorEventsListener  x-btn-over ']//em/button")).click();
		driver.findElement(By.xpath("//table[@id='ext-comp-1061']//em/button")).click();
		driver.findElement(By.xpath("//a[@title='Next Month (Control+Right)']")).click();
		driver.findElement(By.cssSelector(".x-date-inner tr:nth-of-type(4)>td:nth-of-type(3)>a span")).click();
		
		//enter task name
		driver.findElement(By.cssSelector(".tablePlaceholder>div>.taskTableContainer>table> tbody>tr:nth-of-type(1)>.nameCell.first>input")).sendKeys("softwere Engg8");
		driver.findElement(By.xpath("//div[text()='Create Tasks']")).click();
		List<WebElement> taskList = driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".tasksTableVerticalScrollContainer .title")));
		for(int i=0;i<taskList.size();i++) {
			taskList = driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
			if(taskList.get(i).getText().equals("softwere Engg8")) {
				System.out.println("task is created");
				break;
			}
			else {
				System.out.println("task is not created");
			}
		}
		driver.findElement(By.cssSelector(".createdTasksRowsTable .img")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".delete.button")));
		driver.findElement(By.cssSelector(".delete.button")).click();
		driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();
		List<WebElement> taskList2=driver.findElements(By.cssSelector(".tasksTableVerticalScrollContainer .title"));
		for(int i=0;i<taskList2.size();i++) {
			if(taskList2.get(i).getText().equals("softwere Engg8")) {
				System.out.println("task is not deleted");
				
			}
			else {
				System.out.println("task is deleted");
			    break;
			}
		}
	}

}

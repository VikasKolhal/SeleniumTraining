package overall_practice;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import utilities.SeleniumUtility;

public class OH1 {

	public static void main(String[] args) throws InterruptedException {
		SeleniumUtility s1 = new SeleniumUtility();
		WebDriver driver = s1.setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("********login code***********");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector(".oxd-button")).click();
		System.out.println("**click on PIM");
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]")).click();
		System.out.println("***click on add*****");
		s1.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")));
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		System.out.println("***first name and last name****");
		s1.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='firstName']")));
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Shubham");
		s1.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='lastName']")));
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Patil");
		System.out.println("emp ID details");
		s1.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-grid-2.orangehrm-full-width-grid input")));
		//WebElement employeeID = driver.findElement(By.cssSelector(".oxd-grid-2.orangehrm-full-width-grid input"));
		//Thread.sleep(5000);
		//employeeID.clear();
		//Thread.sleep(5000);
		//employeeID.sendKeys("20040");
		driver.findElement(By.cssSelector(".oxd-grid-2 input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE);
		driver.findElement(By.cssSelector(".oxd-grid-2 input")).sendKeys("2333");
		System.out.println("***save details****");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
		
		  System.out.println("******click on PIM again******");
		  driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]")).click();
		  System.out.println("****type emp id***"); 
		  driver.findElement(By.cssSelector(".oxd-form-row>div>div:nth-of-type(2)>div>div:nth-of-type(2)>input")).sendKeys("2333"); 
		  System.out.println("***click on search***");
		  s1.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
		  driver.findElement(By.cssSelector("button[type='submit']")).click();
		  System.out.println("******records found*****");
		  //
		  s1.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-table-row.oxd-table-row--with-border.oxd-table-row--clickable>div:nth-of-type(2)>div")));
		  s1.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".oxd-table-row.oxd-table-row--with-border.oxd-table-row--clickable>div:nth-of-type(2)>div"))); 
		  // s1.wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector".oxd-table-card>div>div:nth-of-type(2)>div")));
		  //s1.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector( ".oxd-table-card>div>div:nth-of-type(2)>div")));
		  // s1.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(  ".oxd-table-card>div>div:nth-of-type(2)>div")));
		  //FluentWait wait= newFluentWait(driver) //.withTimeout(Duration.ofSeconds(30))
		  //.pollingEvery(Duration.ofSeconds(5))
		  // .ignoring(Exception.class);wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-table-card>div>div:nth-of-type(2)>div")));
		  WebElement element =driver.findElement(By.cssSelector(".oxd-table-card>div>div:nth-of-type(2)>div"));
		  // WebElement element=driver.findElement(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[2]"));
		  String element_1=element.getText(); 
		  System.out.println(element_1);
		 
		  if(element_1.equals("2333")){
			  System.out.println("validation successful");
		  } 
		  else {
			  System.out.println("validation not successful"); }
		  
		  System.out.println("****click on check box****");
		  driver.findElement(By.cssSelector(".oxd-table-card>div>div:nth-of-type(1) i")).click();
		  
		  System.out.println("***click on edit****");
		  s1.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-table-cell-actions>button:nth-of-type(2)>i")));
		  driver.findElement(By.cssSelector(".oxd-table-cell-actions>button:nth-of-type(2)>i")).click();
		  
		  System.out.println("**click on job**");
		  s1.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".orangehrm-edit-employee-navigation>div:nth-of-type(2)>div:nth-of-type(6)>a"))); 
		  driver.findElement(By.cssSelector(".orangehrm-edit-employee-navigation>div:nth-of-type(2)>div:nth-of-type(6)>a" )).click();
		  
		  System.out.println("****click on select****");
		 // s1.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".orangehrm-edit-employee>div:nth-of-type(2)>div>form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2) i")));
		 //s1.wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector(".orangehrm-edit-employee>div:nth-of-type(2)>div>form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2) i")));
		  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  WebElement select= driver.findElement(By.cssSelector(".orangehrm-edit-employee>div:nth-of-type(2)>div>form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2) i")); 
		  select.click(); //System.out.println(select.getText());
		  
		  //s1.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".orangehrm-edit-employee>div:nth-of-type(2) form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div .oxd-select-dropdown>div")));
		// Thread.sleep(10000);
		  System.out.println("list of job");
		  List<WebElement>jobList=driver.findElements(By.cssSelector(".orangehrm-edit-employee>div:nth-of-type(2) form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div .oxd-select-dropdown>div")); 
		  
		  for(int i=0;i<jobList.size();i++) {
			  jobList=driver.findElements(By.cssSelector(".orangehrm-edit-employee>div:nth-of-type(2) form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div .oxd-select-dropdown>div"));
		  if(jobList.get(i).getText().equals("QA Lead")) {
			  s1.wait.until(ExpectedConditions.textToBePresentInElement(jobList.get(i), "QA Lead"));
			  jobList.get(i).click();
			  System.out.println("QA Lead is present");
		       break;
		  }
		 
		  }
		  System.out.println("***click on save****");
		  System.out.println("****click on save***");
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  System.out.println("******click on PIM again******");
		  driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]")).click();
		  
		  //System.out.println("***enter emp id******");
		  //driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]")).click();
		  
		  driver.findElement(By.cssSelector(".oxd-form-row>div>div:nth-of-type(2)>div>div:nth-of-type(2)>input")).sendKeys("2333");
		  
		  System.out.println("***click on search***");
		  driver.findElement(By.cssSelector("button[type='submit']")).click();
		  
		  System.out.println("**updated record found**"); 
		  WebElement unit=driver.findElement(By.cssSelector(".orangehrm-container>div>div:nth-of-type(2)>div>div>div:nth-of-type(5)")); 
		  System.out.println("****validation of updated record***");
		  //unit=driver.findElement(By.cssSelector(".orangehrm-container>div>div:nth-of-type(2)>div>div>div:nth-of-type(5)>div")); 
		  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// s1.wait.until(ExpectedConditions.textToBePresentInElement(unit, "QA Lead"));
		  unit=driver.findElement(By.cssSelector(".orangehrm-container>div>div:nth-of-type(2)>div>div>div:nth-of-type(5)>div"));
		  s1.wait.until(ExpectedConditions.visibilityOf(unit));
		  String str=unit.getText(); 
		  if(str.equals("QA Lead")) {
		  System.out.println("validation successful"); 
		  } 
		  else {
		  System.out.println("validation not successful"); 
		  }
		  
			/*
			 * System.out.println("**click on check box****");
			 * 
			 * //s1.wait.until(ExpectedConditions.elementToBeClickable(By.
			 * cssSelector(".oxd-table-card>div>div:nth-of-type(1) i")));
			 * //s1.wait.until(ExpectedConditions.elementToBeSelected(By.
			 * cssSelector(".oxd-table-card>div>div:nth-of-type(1) i")));
			 * //s1.wait.until(ExpectedConditions.visibilityOfElementLocated(By.
			 * cssSelector(".oxd-table-card>div>div:nth-of-type(1) i"))); WebElement
			 * checkbox=
			 * driver.findElement(By.cssSelector(".oxd-table-card>div>div:nth-of-type(1) i")
			 * ); if(checkbox.isSelected()) {
			 * s1.wait.until(ExpectedConditions.elementToBeClickable(By.
			 * cssSelector(".oxd-table-card>div>div:nth-of-type(1) i")));
			 * System.out.println("checkbox is enabled"); checkbox.click(); } else {
			 * System.out.println("checkbox is not selected"); }
			 */
		  System.out.println("**click on delete box****");
		  driver.findElement(By.cssSelector(".oxd-table-cell-actions>button:nth-of-type(1)>i")).click();
		  
		  System.out.println("***click on yes,delete**");
		  driver.findElement(By.cssSelector(".orangehrm-modal-footer>button:nth-of-type(2)")).click();
		  
		  System.out.println("delet validation");
		 // s1.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".orangehrm-horizontal-padding>span")));
		 ///s1.wait.until(ExpectedConditions.textToBe(By.cssSelector(".orangehrm-horizontal-padding>span"), "No Records Found"));
		//Thread.sleep(10000);
		  WebElement str1=driver.findElement(By.cssSelector(".orangehrm-horizontal-padding>span"));
		  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  //Thread.sleep(10000);
		  String str2=str1.getText(); 
		  
		  if(str2.equals("No Records Found")) {
		  System.out.println("delated successfully");
		  
		  }
		  else {
		  System.out.println("not delated successfully"); 
		  }
		 
	}

}
//VIMP

package overall_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtility;

public class OHrm {

	public static void main(String[] args)  {
		SeleniumUtility s1 = new SeleniumUtility();
		WebDriver driver = s1.setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		// driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium
		// oxd-button--main orangehrm-login-button']")).click();
		driver.findElement(By.cssSelector(".oxd-button")).click();

		// click on PIM
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]")).click();
		// click on add
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		// enter first name
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Bhushan");
		// enter last name
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Patil");
		
		s1.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-grid-2.orangehrm-full-width-grid input")));
		WebElement employeeID = driver.findElement(By.cssSelector(".oxd-grid-2.orangehrm-full-width-grid input"));
		//Thread.sleep(5000);
		
		employeeID.clear();
		//employeeID.clear();
		employeeID.sendKeys("2025");
		
		driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();

		
		//pim
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]")).click();
        
		//emp id
		driver.findElement(By.cssSelector(".oxd-form-row>div>div:nth-of-type(2)>div>div:nth-of-type(2)>input")).sendKeys("2025");
		
		//search
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		        s1.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-table-card>div>div:nth-of-type(2)>div")));
		WebElement element =driver.findElement(By.cssSelector(".oxd-table-card>div>div:nth-of-type(2)>div"));
		
		
		
		String element_1=element.getText();
		System.out.println(element_1);
		if(element_1.equals("2025")) {
			System.out.println("validation successful");
		}
		else {
			System.out.println("validation not successful");
		}
		
		//click on ceck box
		driver.findElement(By.cssSelector(".oxd-table-card>div>div:nth-of-type(1) i")).click();
		
		//click on edit
		driver.findElement(By.cssSelector(".oxd-table-cell-actions>button:nth-of-type(2)>i")).click();
		
		
		s1.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".orangehrm-edit-employee-navigation>div:nth-of-type(2)>div:nth-of-type(5)>a"))); 
		
		//click on job
		driver.findElement(By.cssSelector(".orangehrm-edit-employee-navigation>div:nth-of-type(2)>div:nth-of-type(6)>a")).click();
		
		s1.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".orangehrm-edit-employee>div:nth-of-type(2)>div>form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2) i")));
		//click on select
	WebElement select=	driver.findElement(By.cssSelector(".orangehrm-edit-employee>div:nth-of-type(2)>div>form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2) i"));
	select.click();
	System.out.println(select.getText());
		List<WebElement> jobList=driver.findElements(By.cssSelector(".orangehrm-edit-employee>div:nth-of-type(2) form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div .oxd-select-dropdown>div"));
		for(int i=0;i<jobList.size();i++) {
			if(jobList.get(i).getText().equals("QA Lead")) {
				jobList.get(i).click();
				break;
			}
			else {
				System.out.println("QA lead is not present");
			}
		}
		//click on save
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// click on PIM
				driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]")).click();
				
				driver.findElement(By.cssSelector(".oxd-form-row>div>div:nth-of-type(2)>div>div:nth-of-type(2)>input")).sendKeys("0123");
				
				System.out.println("***click on search***");
				driver.findElement(By.cssSelector("button[type='submit']")).click();
				
				WebElement unit=driver.findElement(By.cssSelector(".orangehrm-container>div>div:nth-of-type(2)>div>div>div:nth-of-type(5)"));
				String str=unit.getText();
				if(str.equals("QA Lead")) {
					System.out.println("validation successful");
				}
				else {
					System.out.println("validation not successful");
				}
				
				
				driver.findElement(By.cssSelector(".oxd-table-card>div>div:nth-of-type(1) i")).click();
				
				driver.findElement(By.cssSelector(".oxd-table-cell-actions>button:nth-of-type(1)>i")).click();
				
				driver.findElement(By.cssSelector(".orangehrm-modal-footer>button:nth-of-type(2)")).click();
				
				WebElement str1=driver.findElement(By.cssSelector(".orangehrm-horizontal-padding>span"));
				String str2=str1.getText();
				if(str2.equals("No Records Foun")) {
					System.out.println("delated successfully");
				}
				else {
					System.out.println("not delated successfully");
				}
	}

}

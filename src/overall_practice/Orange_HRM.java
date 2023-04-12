package overall_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.SeleniumUtility;

public class Orange_HRM {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
		WebDriver driver=s1.setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("Admin",Keys.TAB);
        driver.findElement(By.name("password")).sendKeys("admin123",Keys.ENTER);//login done
        driver.findElement(By.cssSelector(".oxd-navbar-nav ul>li:nth-of-type(2)>a")).click();//click on PIM
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();//click on add
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Nilesh");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Deokar");
        
        WebElement empId=driver.findElement(By.cssSelector(".oxd-form .oxd-grid-2 input"));
        s1.wait.until(ExpectedConditions.visibilityOf(empId));
        empId.clear();
        empId.sendKeys("9520");
        driver.findElement(By.xpath("//button[@type='submit']")).click();//save details
        driver.findElement(By.cssSelector(".oxd-navbar-nav ul>li:nth-of-type(2)>a")).click();//click on PIM again
        driver.findElement(By.cssSelector(".oxd-form-row>.oxd-grid-4>div:nth-of-type(2) input")).sendKeys("9520");//entring empid
        s1.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")));
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();//click on search
        
      s1.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".oxd-table-body>div>div>div:nth-of-type(2)>div")));
      
        WebElement element=driver.findElement(By.cssSelector(".oxd-table-body>div>div>div:nth-of-type(2)>div"));
        String element_1=element.getText();
        if(element_1.equals("9520")) {
        	System.out.println("validation successfull");
        }
        else {
        	System.out.println("validation not successfull");
        }
        
        WebElement checkBox=driver.findElement(By.cssSelector(".oxd-table-card span>i"));
        if(checkBox.isSelected()) {
        	checkBox.click();
        }
        else {
        	System.out.println("check box is not selected");
        }
        
        driver.findElement(By.cssSelector(".oxd-table-cell-actions>button:nth-of-type(2)>i")).click();//click on edit
        driver.findElement(By.cssSelector(".oxd-layout-context>div .orangehrm-tabs>div:nth-of-type(6)")).click();//click on job
        driver.findElement(By.cssSelector(".oxd-form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2) i")).click();//click on select
        
        List<WebElement> jobList=driver.findElements(By.cssSelector(".oxd-form>div:nth-of-type(1)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div"));
        for(int i=0;i<jobList.size();i++) {
        	if(jobList.get(i).getText().equals("QA Lead")) {
        		jobList.get(i).click();
        		break;
        	}
        	else {
        		System.out.println("QA lead is not present");
        	}
        }
        
        driver.findElement(By.xpath("//button[@type='submit']")).click();//click on save
        driver.findElement(By.cssSelector(".oxd-navbar-nav ul>li:nth-of-type(2)>a")).click();//click on pim again
        driver.findElement(By.cssSelector(".oxd-form-row>.oxd-grid-4>div:nth-of-type(2) input")).sendKeys("9520");//enter empid
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
        
        WebElement unit=driver.findElement(By.cssSelector(".oxd-table>div:nth-of-type(2)>div>div>div:nth-of-type(5)>div"));
        String str=unit.getText();
        if(str.equals("QA Lead")) {
        	System.out.println("updated successfully");
        }
        else {
        	System.out.println("not updated");
        }
        
        
        WebElement checkBox2=driver.findElement(By.cssSelector(".oxd-table-card span>i"));
        if(checkBox2.isSelected()) {
        	checkBox2.click();
        }
        else {
        	System.out.println("check box is not selected");
        }
        
        driver.findElement(By.cssSelector(".oxd-table-cell-actions>button:nth-of-type(1)>i")).click();
        
        driver.findElement(By.cssSelector(".orangehrm-modal-footer>button:nth-of-type(2)>i")).click();
        
        WebElement status=driver.findElement(By.cssSelector(".orangehrm-horizontal-padding.orangehrm-vertical-padding"));
        String sts=status.getText();
        if(sts.equals("No Records Found")) {
        	System.out.println("deleted succefully");
        }
        else {
        	System.out.println("not deleted succefully");
        }
	}

}

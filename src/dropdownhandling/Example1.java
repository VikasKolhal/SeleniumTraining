package dropdownhandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Example1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com");
        Select multiSelectDropDown=new Select(driver.findElement(By.id("multiselect1")));
        
        System.out.println("is dropdown allowing multiple selection:"+multiSelectDropDown.isMultiple());
        
        List<WebElement> carList=multiSelectDropDown.getOptions();
        System.out.println("dropdown count:"+carList.size());
        String s= carList.get(2).getText();
        System.out.println("name at index 2:"+s);
        for(int i=0;i<carList.size();i++) {
        	System.out.println(i+":"+carList.get(i).getText());
        	}
        
        multiSelectDropDown.selectByIndex(1);
        multiSelectDropDown.selectByVisibleText("Audi");
        List<WebElement> selectCars=multiSelectDropDown.getAllSelectedOptions();
        System.out.println("Selected car count:"+selectCars.size());
        for(int i=0;i<selectCars.size();i++) {
        	System.out.println(selectCars.get(i).getText());
        }
        multiSelectDropDown.deselectByIndex(1);
        multiSelectDropDown.deselectByVisibleText("Audi");
        
        
        
	}

}

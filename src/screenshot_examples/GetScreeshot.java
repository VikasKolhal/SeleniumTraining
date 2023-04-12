package screenshot_examples;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumUtility;

public class GetScreeshot {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
		WebDriver driver =s1.setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
		TakesScreenshot ts=(TakesScreenshot)driver;
     File file= ts.getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(file,new File("\\ScreenShot_Folder\\vtiger1.jpg"));
	}

}

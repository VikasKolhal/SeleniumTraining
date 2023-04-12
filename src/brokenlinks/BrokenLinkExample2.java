package brokenlinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.SeleniumUtility;

public class BrokenLinkExample2  {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
		WebDriver driver=s1.setUp("chrome", "https://demoqa.com/broken");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No of links are "+ links.size()); 
		
		for(int i=0;i<links.size();i++) {
			WebElement E1=links.get(i);
			String url=E1.getAttribute("href");
            System.out.println("URL is"+url);			
			verifyLinks(url);
		}
	}


       public static void verifyLinks(String linkUrl) {
	   try {
		   System.out.println("Test");
		   URL url=new URL(linkUrl);
		 //Now we will be creating url connection and getting the response code
		HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
		httpURLConnect.setConnectTimeout(5000);
		httpURLConnect.connect();
		if(httpURLConnect.getResponseCode()>=400) {
			System.out.println(linkUrl+"-----responce code is---->"+httpURLConnect.getResponseMessage()+"---- is a invalid/broken link");
		}
		//Fetching and Printing the response code obtained
		else {
			System.out.println(linkUrl+"----response code is---->"+httpURLConnect.getResponseMessage()+ "---- Valid link");
		}
	}
	   catch (Exception e) {
		   
	   }
}
}
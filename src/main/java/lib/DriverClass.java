package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod; 

public class DriverClass {
	ConfigReader config;
	
	public  WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() throws Exception {
		
		config = new ConfigReader();
		
		String BrowserName = config.GetbrowserName();
		System.setProperty("WebDriver.gecko.driver", config.GetChromeDriver());
		 
		 if(BrowserName == "FireFox" || BrowserName == "FF") {
			 driver =new FirefoxDriver();
		 }else if (BrowserName.equalsIgnoreCase("Chrome")){
			 driver =new ChromeDriver();
		 }else if (BrowserName.equalsIgnoreCase("IE")){
			 driver =new InternetExplorerDriver(); 
		 }else if(BrowserName.equalsIgnoreCase("HTML")){
			 driver =new HtmlUnitDriver(); 
		 }else{
			 driver =new FirefoxDriver();
		 }	 
	 
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(config.GetAppURL());
	
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}

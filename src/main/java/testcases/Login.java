package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import lib.DriverClass;

public class Login  extends DriverClass   {
	
	private static final int Priority = 0;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public Login() {
		
	}
	
	By txt_insti    = By.id("institution");
	By btn_submit   = By.id("submitBtn");
	By user_name    = By.id("username");
	By pwd          = By.id("password");
	By btn_login    = By.name("submit");
	By txt_alertmsg = By.xpath("div.alert.alert-danger");
	
	@Test(priority=2)
	public void loginwithvalidCredenials() throws InterruptedException {
		  loginHomePage();
		  driver.findElement(user_name).sendKeys("prem");
		  driver.findElement(pwd).sendKeys("testprem");
		  driver.findElement(btn_login).click();
		  Thread.sleep(10000);
		
	}
	
	@Test(priority=1)
	public void loginwithinvalidCredentials() throws InterruptedException {
		  loginHomePage();
		  driver.findElement(user_name).sendKeys("prem");
		  driver.findElement(pwd).sendKeys("122234432");
		  driver.findElement(btn_login).click();
		  Thread.sleep(10000);	
		 String test = driver.findElement(txt_alertmsg).getText();
		 System.out.println(test+"------------->");
		 Assert.assertEquals(test,"Invalid credentials.");
		 
		 
	}
	
	public void loginHomePage() throws InterruptedException {
		  driver.findElement(txt_insti).sendKeys("HTC");
		  driver.findElement(btn_submit).click();
		  Thread.sleep(10000);
	}
	
}

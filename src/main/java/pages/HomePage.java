package pages;

import org.openqa.selenium.By;

import lib.DriverClass;

public class HomePage extends DriverClass {
	
	By txt_insti = By.id("institution");
	By btn_submit= By.id("submitBtn");
	By user_name = By.id("username");
	By pwd       = By.id("password");
	By btn_login = By.name("submit");
	
	public void Login(String txt_ins, String txt_uname, String txt_pwd) throws InterruptedException {
		driver.findElement(txt_insti).sendKeys(txt_ins);
		driver.findElement(btn_submit).click();
		  Thread.sleep(10000);
		  driver.findElement(user_name).sendKeys(txt_uname);
		  driver.findElement(pwd).sendKeys(txt_pwd);
		  driver.findElement(btn_login).click();
		  Thread.sleep(10000);
		  
		}

}

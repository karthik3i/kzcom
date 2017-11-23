package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import lib.DriverClass;

public class BlankSearch extends DriverClass {
	
	By txt_search_box    = By.id("fieldValue");
	By btn_search        = By.id("search");
	By txt_search_result = By.id("searchResultsDiv");
	
	@Test
	public void searchBlank() throws InterruptedException {	
		Login login = new Login(driver);
		login.loginwithvalidCredenials();
		driver.findElement(txt_search_box).sendKeys("raman");
		driver.findElement(btn_search).click();
		Thread.sleep(5000);
		driver.findElement(txt_search_result).isEnabled();
		
	}

}

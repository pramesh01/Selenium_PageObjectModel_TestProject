package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage {
	public WebDriver driver;
	
	public BasePage() {
		System.out.println("********************base page constructor *****************");
	}
	
	public BasePage(WebDriver driver) {
		System.out.println("base page overridden constructor.");
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void validateTitle(String expectedResult) {
		Assert.assertEquals(driver.getTitle(),expectedResult );
	}
}

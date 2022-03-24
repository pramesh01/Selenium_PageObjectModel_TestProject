package ApplicationPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testbase.BasePage;

public class LaunchBrowser extends BasePage{
	
	public LaunchBrowser(WebDriver driver) {
		
		super(driver);
		System.out.println("Launch page constructor.");
	}

	public HomePage navigateToHomePage() {
		
		driver.get("https://www.zoho.com/index1.html");
		
		return new HomePage(driver);
		//return PageFactory.initElements(driver,HomePage.class);
	}
}

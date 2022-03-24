package ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import testbase.BasePage;

public class HomePage extends BasePage{
   @FindBy(xpath=Constants.signInButton_xpath)
   WebElement signInButton;
	
	public HomePage(WebDriver driver) {
		super(driver);
		System.out.println("home page constructor.");
	
	}

	public UserNamePage navigateToUserenterpage() {
		
	//driver.findElement(By.xpath("//*[@id='block-system-main']/div/div[1]/div/div/div[3]/div/div[4]/div/a[1]")).click();
		signInButton.click();
		return new UserNamePage(driver);
	//return PageFactory.initElements(driver, UserNamePage.class);
		
	}
}

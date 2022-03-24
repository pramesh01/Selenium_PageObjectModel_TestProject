package ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import testbase.BasePage;

public class UserNamePage extends BasePage {
	@FindBy(xpath=Constants.usernameText_xpath)
	WebElement usernameText;
	
	@FindBy(xpath=Constants.nextButton_xpath)
      WebElement nextButton;
	
	public UserNamePage(WebDriver driver) {
		super(driver);
		System.out.println("user name page constructor");
	
	}

	public PasswordPage navigateToPasswordEnterPage() throws InterruptedException {
		
		//driver.findElement(By.xpath("//*[@id='login_id']")).sendKeys("bloggerdelhi123@gmail.com");
		usernameText.sendKeys("bloggerdelhi123@gmail.com");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='nextbtn']/span")).click();
		nextButton.click();
		Thread.sleep(3000);
		return new PasswordPage(driver);
		//return PageFactory.initElements(driver, PasswordPage.class);
		
	}
}

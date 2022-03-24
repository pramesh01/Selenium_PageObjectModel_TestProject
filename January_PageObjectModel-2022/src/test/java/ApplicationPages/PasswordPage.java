package ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BasePage;

public class PasswordPage extends BasePage{
	//WebDriver driver;
	@FindBy(xpath="//*[@id='password']")
	WebElement passwordText;
	
	@FindBy(xpath="//*[@id='nextbtn']/span")
	WebElement submitButton;
	
	public PasswordPage(WebDriver driver) {
		super(driver);
		System.out.println("Password page constructor.");

		
	}
	
public void finalLoginSubmit() {
		//driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Ishu@284128");
		//driver.findElement(By.xpath("//*[@id='nextbtn']/span")).click();	
	   passwordText.sendKeys("Ishu@284128");	
	   submitButton.click();
	
}
}

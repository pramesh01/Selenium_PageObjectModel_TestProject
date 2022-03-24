package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.session.CreatingLeadspage;

public class EnterPasswordPage extends ZohoBasePage {

	@FindBy(xpath="//*[@id='password']")
	WebElement passwordText;
	
	@FindBy(xpath="//*[@id='nextbtn']/span")
	WebElement submitButton;
	
	public ZohoPage submitPassword(String passwordID) {
		   log("entering th password "+passwordID);
		passwordText.sendKeys("Ishu@284128");	
		log("final submiting for the Zoho Website.");
		submitButton.click();
		
		return new CreatingLeadspage();		
	}
}

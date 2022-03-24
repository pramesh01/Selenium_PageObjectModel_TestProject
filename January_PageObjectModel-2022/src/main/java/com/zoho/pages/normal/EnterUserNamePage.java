package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;

import constants.Constants;



public class EnterUserNamePage extends ZohoBasePage{
	
	@FindBy(xpath=Constants.usernameText_xpath)
	WebElement usernameText;
	
	@FindBy(xpath=Constants.nextButton_xpath)
      WebElement nextButton;
	
public ZohoPage submitUserName(String userID) {
		
	log("Entering the username i.e "+userID);
		usernameText.sendKeys(userID);
		log("clicking on next button to proceed for password page");
		nextButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new EnterPasswordPage();
			
}
}

package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;



public class HomePage extends ZohoBasePage {
	
	  @FindBy(xpath=Constants.signInButton_xpath)
	   WebElement signInButton;
	  
	  public ZohoPage gotoEnterUsernamePage() {
		  log("going to the enterusername page");
		  signInButton.click();
		  return new EnterUserNamePage();
		  //gotoEnterUsernamePage();
		  
	  }

	

}

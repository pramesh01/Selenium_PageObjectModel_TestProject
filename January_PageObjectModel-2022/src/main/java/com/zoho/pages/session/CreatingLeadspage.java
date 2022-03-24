package com.zoho.pages.session;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.normal.LaunchPage;

public class CreatingLeadspage extends ZohoBasePage{
	
	@FindBy(xpath=Constants.CRM_Link)
	   WebElement crmLink;
	
	@FindBy(xpath=Constants.Leads_Tab)
	   WebElement leadsTab;
	
	@FindBy(xpath=Constants.Access_ZohoCRM)
	   WebElement accessZohoCrm;
	
	public ZohoPage creatingZohoLead() {
		log("Creating the Zoho Lead for Testing Automation purpose");
		  crmLink.click();
		  accessZohoCrm.click();
		  leadsTab.click();
		  return new LaunchPage();
	  }

}

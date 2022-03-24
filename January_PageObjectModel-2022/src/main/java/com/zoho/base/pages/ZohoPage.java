package com.zoho.base.pages;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;
import com.zoho.web.ZohoValidationDriver;

public interface ZohoPage extends ZohoNormal,ZohoSession {
	
	//zohoNormal
	ZohoPage openBrowser(String browser);
	ZohoPage gotoHomePage();
	
	//zohopage related.
	void gotoRegisterPage();
	ZohoPage submitUserName(String userID);
	ZohoPage submitPassword(String passwordID);
	WebConnector validator();
	void quit();
	void getTotalWindows();
    ZohoTestSession getSession();
	ZohoPage gotoEnterUsernamePage();
	
	//session
	void createDeal();
	ZohoPage creatingZohoLead();
	void logOut();
	WebConnector validator(boolean b);
	ZohoPage validateTitle(String homePageTitle);
	ZohoPage validateText(String locator, String text);
	public void log(String message) ;
	
	
	

}

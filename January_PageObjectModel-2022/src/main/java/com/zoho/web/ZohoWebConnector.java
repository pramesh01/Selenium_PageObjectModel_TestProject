package com.zoho.web;

import org.openqa.selenium.By;

import com.zoho.base.pages.ZohoPage;

public interface ZohoWebConnector  {

	void logOut();
	ZohoPage validateTitle(String expectedTitle);
	ZohoPage validateText(By locator,String expectedText);
	ZohoPage validateElementPresent(By locator);
	void validateLogin();
	
	void openBrowser(String browser);
	void navigate(String url);
	void quit();
	void log(String messages);
	boolean isElementPresent(By locator);
	

}

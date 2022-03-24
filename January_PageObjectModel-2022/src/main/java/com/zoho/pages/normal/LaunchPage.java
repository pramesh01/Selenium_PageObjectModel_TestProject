package com.zoho.pages.normal;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

public class LaunchPage extends ZohoBasePage{
	
	public ZohoPage openBrowser(String browserName) {
		System.out.println("Launch page -Opening the browser.."+browserName);
		//ZohoTestSession session=getSession();
		//session.getcon().openBrowser("browserName");
		getDriver().openBrowser("browserName");
		return this;
	}
       
	public ZohoPage gotoHomePage() {
		log("navigating to the website https://Zoho.com");
	       System.out.println("launch page called - gotoHomePage function ");
	       getDriver().navigate("https://www.zoho.com/index1.html");
	           return new HomePage();
		       
	            }
             }

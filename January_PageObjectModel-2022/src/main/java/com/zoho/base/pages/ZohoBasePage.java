package com.zoho.base.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public class ZohoBasePage implements ZohoPage{
	
	public ZohoBasePage() {
		//System.out.println("creating the default constructor of ZohoBasePage class");
	    PageFactory.initElements( getCurrentDriver(), this);
	    getSession().setCurrentPage(this);
	}

	public ZohoPage openBrowser(String browser) {
		return null;
		
	}

	public ZohoPage gotoHomePage() {
		System.out.println("zoho base page called.-gotoHomePage Function");
		return null;
		
	}
	
	public ZohoPage gotoEnterUsernamePage() {
		return null;
	}

	public void gotoRegisterPage() {
		// TODO Auto-generated method stub
		
	}

	public ZohoPage submitUserName(String userID) {
		return null;
		
	}

	public WebConnector validator(boolean stopExecution) {
		getSession().getcon().setStopExecution(stopExecution);
		return getSession().getcon();
		
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public void getTotalWindows() {
		// TODO Auto-generated method stub
		
	}

	public void createDeal() {
		// TODO Auto-generated method stub
		
	}

	public void logOut() {
		// TODO Auto-generated method stub
		
	}
	
	public ZohoTestSession getSession() {
		return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}
	
	public WebConnector getDriver() {
		return getSession().getcon();
		
	}
	public EventFiringWebDriver getCurrentDriver() {
		return getSession().getcon().getCurrentDriver();
	}

	
	public ZohoPage submitPassword(String passwordID) {
		return null;
	      
	}

	public WebConnector validator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ZohoPage validateTitle(String homePageTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	public ZohoPage validateText(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void log(String message) {
		getSession().log(message);
	}

	public ZohoPage creatingZohoLead() {
		return null;
		
	}
    }

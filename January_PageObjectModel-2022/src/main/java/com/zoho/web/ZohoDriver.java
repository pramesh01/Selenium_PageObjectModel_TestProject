package com.zoho.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.zoho.base.pages.ZohoPage;
import com.zoho.listener.ZohoeventListener;
import com.zoho.session.ZohoTestSession;

public class ZohoDriver extends ZohoValidationDriver {
	
	//EventFiringWebDriver driver;

	public void logOut() {
		
	      }

	public void openBrowser(String browser) {
		log("opening the browser "+browser);
		System.out.println(" inside Zoho driver -opening the browser "+browser);
		driver=new EventFiringWebDriver(new ChromeDriver());
		driver.register(new ZohoeventListener());
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
	}
	public void navigate(String url) {
		log("navigating to the website "+url);
		System.out.println("inside zoho driver navigating to the official website - "+url);
		driver.get(url);
		
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public EventFiringWebDriver getCurrentDriver() {
		return driver;
		
	}
	public ZohoTestSession getSession() {
		return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}


}

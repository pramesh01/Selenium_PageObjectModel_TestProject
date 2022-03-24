package com.zoho.listener;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

import io.netty.handler.timeout.TimeoutException;

public class ZohoeventListener extends AbstractWebDriverEventListener  {
	
	public void beforeFindBy(By locator,WebElement element,WebDriver driver) {
		
		//System.out.println("before finding locator "+by);
		//System.out.println("before finding element "+element);
		//System.out.println("before finding Driver "+driver);
		
		if(getSession().isExecuteListener()) {
		      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		    try  {
		    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		       }
		    catch(TimeoutException e) {
			    getDriver().fail("element is not found "+locator);
			    getDriver().assertAll(); // end of the Test flow here at this point.
		 }	
		}
	   }
	
	
	public WebConnector getDriver() {
		return getSession().getcon();
	    }
	
	  public ZohoTestSession getSession() {
		return (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	   }
	  
	  public void log(String message) {
			getSession().log(message);
		}
}

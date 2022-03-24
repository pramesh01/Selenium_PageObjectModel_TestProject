package com.zoho.web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

import io.netty.handler.timeout.TimeoutException;

public abstract class ZohoValidationDriver implements WebConnector {
	EventFiringWebDriver driver;
	SoftAssert softAssert=new SoftAssert();
	boolean stopExecution;
	
	public ZohoPage validateTitle(String expectedTitle) {
		log("expected title is "+expectedTitle);
		log("actual title is "+driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), expectedTitle);
		System.out.println("Status of title inside validator is "+isStopExecution());
		if(!expectedTitle.equals(driver.getTitle())) {
			fail("execution is failed.title do not matched "+driver.getTitle());
			//softAssert.fail("Execution has been failed since title do not matched");
			     // if(isStopExecution())
				  //   assertAll();	
		      }
		return getSession().getCurrentPage();
		
	}
	
 public ZohoPage validateText(By locator, String expectedText) {
	 log("expected Text is "+expectedText);
		//log("actualtext is  "+driver.findElement(locator).getText());
	//System.out.println("Status of Text inside validator is "+isStopExecution());
	String actualText=driver.findElement(locator).getText();
	log("actualtext is  "+actualText);
	if(!expectedText.equals(actualText)) {
		fail("execution is failed.Text do not matched "+actualText);
	//softAssert.fail("Execution has been failed since Text do not matched "+actualText);
		 //if(isStopExecution())
		// assertAll();	
		      }
	
		return getSession().getCurrentPage();
	}
 
 public ZohoPage validateElementPresent(By locator) {
	 
	 if(!isElementPresent(locator)) {
      log("element is not available in page."+locator);
		 fail("Element is not present thats why failing this test case "+locator);
	 }
	 
	 log("WebElement is present and available.."+locator);
	 return getSession().getCurrentPage();
 }
 
 public boolean isElementPresent(By locator) {
	 getSession().setExecuteListener(false);
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	 try {
	 wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	 }
	 catch(TimeoutException e) {
		 getSession().setExecuteListener(true);
		 return false;
	 }
	 getSession().setExecuteListener(true);
	 return true;
 }
	
	public void validateLogin() {
		
		
	}
	
	public ZohoTestSession getSession() {
		return null;
	}
	
	public boolean isStopExecution() {
		return stopExecution;
	}


	public void setStopExecution(boolean stopExecution) {
		this.stopExecution = stopExecution;
	}
	
	public SoftAssert getSoftAssert() {
		return softAssert;
	}

	public void setSoftAssert(SoftAssert softAssert) {
		this.softAssert = softAssert;
	}

	
	public void assertAll() {
		softAssert.assertAll();
	}
	
	public void log(String message) {
		getSession().log(message);
	}
	
	
	public void fail(String message) {
		//fail in Extent Reports.
		getSession().failTest(message);
		//fail in test NG
	  softAssert.fail(message);
	  if(isStopExecution())
		  assertAll();
	      }
           }
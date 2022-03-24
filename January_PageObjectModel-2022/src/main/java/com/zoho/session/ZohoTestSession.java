package com.zoho.session;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.normal.LaunchPage;
import com.zoho.web.WebConnector;
import com.zoho.web.ZohoDriver;
import com.zoho.reports.ExtentManager;

public class ZohoTestSession {
	WebConnector con;
	ZohoPage currentPage;
	ExtentTest test;
	ExtentReports reports;
	boolean executeListener;
	
	public ZohoTestSession()  {
		con=new ZohoDriver();
	  }

	public void init(String testName) {
		
		setExecuteListener(true);
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session")==null)
		Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);
		
		reports=ExtentManager.getReports(Constants.Reports_Path);
		test=reports.createTest(testName);
		
		//ZohoPage page=new LaunchPage();
		//return page;
	}
	    //making a new Function..
	public WebConnector getcon() {
		return con;
		
	}
	public ZohoPage getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(ZohoPage currentPage) {
		this.currentPage = currentPage;
	}
	
	   public void end() {
		  getcon().assertAll();
		
	}
	   public void skipTest(String message) {
		   test.log(Status.SKIP,message);
		   
	   }
	   
	   public void log(String message) {
		  test.log(Status.INFO, message);
	}
	
	   public void generateReports() {
		   if(reports != null)
		     reports.flush();
	}

	public void failTest(String failureMessage) {
	//fail in extentReports
		test.log(Status.FAIL,failureMessage);
		//add the screenshot of the failure..	
		takesScreenShot();
		test.log(Status.FAIL, failureMessage);
	}
	
	 public void takesScreenShot() {
		    //choosing the name of the screenshot file.
		    Date d=new Date();
		    String screenshotFile=d.toString().replace(":","_").replace(" ","_")+".png";
		    //take the screenshot.
		    File srcFile=((TakesScreenshot) getcon().getCurrentDriver()).getScreenshotAs(OutputType.FILE);
		    try {
		    	FileUtils.copyFile(srcFile,new File(ExtentManager.ScreenshotFolderPath+"//"+screenshotFile));
		    //putting screenshot into Reports.
		    	test.log(Status.INFO, "screenshot->"+test.addScreenCaptureFromPath(ExtentManager.ScreenshotFolderPath+"//"+screenshotFile));
		    }
		    catch(IOException e) {
		    	e.printStackTrace();
		    }
		    	
		    }
	 
	 public boolean isExecuteListener() {
			return executeListener;
		}

		public void setExecuteListener(boolean executeListener) {
			this.executeListener = executeListener;
		}
}

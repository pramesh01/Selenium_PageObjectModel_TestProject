package testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.normal.EnterPasswordPage;
import com.zoho.pages.normal.EnterUserNamePage;
import com.zoho.pages.normal.LaunchPage;
import com.zoho.session.ZohoTestSession;
import com.zoho.util.DataUtil;
//import constants.Constants;
import com.zoho.util.Xls_Reader;

public class LogIN {
	//ExtentReports reports;
	//ExtentTest test;
	ZohoTestSession session;
	//ZohoPage zohoLaunchPage;
	String testCaseName="LoginTest";
	Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	
	@BeforeMethod
	
	   public void init() {
		//reports=ExtentManager.getReports(Constants.Reports_Path);
		//test=reports.createTest("Login Test");
	   // test.log(Status.INFO, "creating the test case session");
	    session=new ZohoTestSession();//webconnector initialized.
	   // zohoLaunchPage=session.init("Login Test");
	    session.init(testCaseName);
	}
	
	@AfterMethod
	     public void quit()  {
		        
		       session.generateReports();
	      }
	
	@Test(dataProvider="getData")
	public void loginTest(Hashtable<String,String> data) throws InterruptedException {
		
		//String username="bloggerdelhi123@gmail.com";
		//String password="Ishu@284128";
		//String userNameValid="Y";
		session.log(data.toString());
		if(!DataUtil.isRunnable(testCaseName, xls) || data.get("Runmode").equals("N")) {
			//skip in Extent Reports
			session.skipTest("skipping the test as Runmode is set as No.");
			//Skip in testNG
			throw new SkipException("Skipping the test as Runmode is set as NO");
			
		}
		String username=data.get("UserName");
		String password=data.get("Password");
		String userNameValid=data.get("UsernameValid");
		
	//ExtentReports reports=ExtentManager.getReports(Constants.Reports_Path);
	//ExtentTest test=reports.createTest("Login Test");
	//test.log(Status.INFO, "creating the test case session");
		//ZohoTestSession session=new ZohoTestSession();//webconnector initialized.
		//test.log(Status.INFO, "session has been created for the login Test");
		//init()->store session in testcontext, object of launch page..
		//ZohoPage page=session.init().openBrowser("chrome");
		//page.gotoHomePage();
		String expectedText="GET STARTED FOR FREE";
		
		ZohoPage page=//session.init("LogIn Test")
				//zohoLaunchPage
				 new LaunchPage()
				.openBrowser("chrome").gotoHomePage()
		.validator(false).validateTitle(Constants.Home_Page_Title)
		.validator(false).validateText(Constants.Home_Page_Text_Locator,expectedText)
		.validator(true).validateElementPresent(Constants.signInButtonLocator_xpath)
		//.validator(true).validateTitle("Zoho | Cloud Software Suite for Businesses")
		.gotoEnterUsernamePage()
		.submitUserName(username);
		//.submitPassword(password);
	   
		if(page instanceof EnterUserNamePage & userNameValid.equals("Y") ) {
			//report failure.
			page.validator(true).fail("could enter valid UserName "+userNameValid);
		}
		else if(page instanceof EnterPasswordPage ) {
			if(userNameValid.equals("N")) {
			page.validator(true).fail("able to Enter and submit valid username "+userNameValid);
		}
			else {
			//go ahead with password and login.
				page.submitPassword(password);
		}
		}
		
		    session.end();
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return DataUtil.getData(testCaseName, xls);
		
		/*  String sheetName="TestCases";
		  String testcaseName="LoginTest";
	Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	
	int testStartRowNumber=1;
	 while(! xls.getCellData(sheetName, 0 , testStartRowNumber).equals(testcaseName) ){
		 testStartRowNumber++;
	}
	System.out.println("Row number in which Testcase name exists is "+testStartRowNumber);
	int columnRowNumber=testStartRowNumber+1;
	
	int totalColumns=0;
	while(! xls.getCellData(sheetName, totalColumns, columnRowNumber).equals("")) {
		totalColumns++;
	}
	System.out.println("Total columns in the Testcase is "+totalColumns);
	int dataStartRowNumber=columnRowNumber+1;
	int totalRows=0;
	
	while(! xls.getCellData(sheetName, 0 , dataStartRowNumber+totalRows).equals("")) {
		totalRows++;
	  }
	System.out.println("total data rows in testcase are "+totalRows);
	
	Object testData[][]=new Object [totalRows][1];
	
	  //extracting the data of the xls sheet
	Hashtable<String,String> table=null;
	int i=0;
	
	for(int rNum=dataStartRowNumber;rNum<dataStartRowNumber+totalRows;rNum++) {
		table=new Hashtable<String,String>();
		
		for(int cNum=0;cNum<totalColumns;cNum++) {
			String data=xls.getCellData(sheetName, cNum, rNum);
			String key=xls.getCellData(sheetName, cNum, columnRowNumber);
			System.out.print(key+" "+data+" - ");
			table.put(key,data);
	           	}
		
	     testData[i][0]=table;
	     i++;
		 System.out.println( );
	      }
	return testData;   */
	}
}

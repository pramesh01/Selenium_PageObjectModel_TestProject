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
import com.zoho.util.Xls_Reader;

public class CreateLead {
	ZohoTestSession session;
	String testCaseName="CreateLeadTest";
	Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	
	@BeforeMethod
	
	   public void init() {
	      session=new ZohoTestSession();
	      session.init(testCaseName);
	}
	@AfterMethod
	       public void quit()  {
		   session.generateReports();
	      }
	
	@Test(dataProvider="getData")
	public void loginTest(Hashtable<String,String> data) throws InterruptedException {
		
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
		
	
		String expectedText="GET STARTED FOR FREE";
		
		ZohoPage page=//session.init("LogIn Test")
				//zohoLaunchPage
				 new LaunchPage()
				.openBrowser("chrome").gotoHomePage()
		.validator(false).validateTitle(Constants.Home_Page_Title)
		.validator(false).validateText(Constants.Home_Page_Text_Locator,expectedText)
		.validator(true).validateElementPresent(Constants.signInButtonLocator_xpath)
		.gotoEnterUsernamePage()
		.submitUserName(username);
		//.submitPassword(password)
		//.creatingZohoLead();
	   
	/*	if(page instanceof EnterUserNamePage & userNameValid.equals("Y") ) {
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
		    }*/
		     session.end();
	  }
	
	@DataProvider
	      public Object[][] getData(){
		  return DataUtil.getData(testCaseName, xls);	
	  }
    }

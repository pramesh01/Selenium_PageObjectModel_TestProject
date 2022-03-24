package com.zoho.base.pages;

import org.openqa.selenium.By;

public class Constants {

	public static final String signInButton_xpath="//*[@id='block-system-main']/div/div[1]/div/div/div[3]/div/div[4]/div/a[1]";
	public static final By signInButtonLocator_xpath=By.xpath(signInButton_xpath);
	
	
    public static final String usernameText_xpath="//*[@id='login_id']";
    public static final String nextButton_xpath="//*[@id='nextbtn']/span";
    public static final String Home_Page_Title="Zoho | Cloud Software Suite for Businesses";
    public static final String Reports_Path=System.getProperty("user.dir")+"//Reports//";
	
    public static final String Home_Page_Text="//div[@class='zh-home-btn']/a";
    public static final By Home_Page_Text_Locator=By.xpath(Home_Page_Text);
    
    public static final String CRM_Link="//*[@id='block-system-main']/div/div[3]/section[2]/div/div/ul/li[1]/a/span[2]/label";
    public static final By Zoho_CRM_Link_Locator=By.xpath(CRM_Link);
    
    public static final String Access_ZohoCRM="//*[@id='block-system-main']/div/div[1]/div/div[1]/div/div[1]/a";
    
    public static final String Leads_Tab="//*[@id='mainMenuTabDiv']/crm-menu/div[1]/crm-tab/div[2]/div[2]/a";
    public static final By  Leads_Tab_Locator=By.xpath(Leads_Tab);

    public static final String CreateLead_Button="//*[@id='table_row_1']/lyte-td[3]/span[1]/link-to/button";
    public static final By  CreateLead_Button_Locator=By.xpath(CreateLead_Button);
    
    public static final String CompanyName_TextBox="//*[@class='lyteInputBox vertical']";
    public static final By  CompanyName_TextBox_Locator=By.xpath(CompanyName_TextBox);
    
    public static final String LastName_TextBox="//*[@id='Crm_Leads_LASTNAME_LInput']";
    public static final By  LastName_TextBox_Locator=By.xpath(LastName_TextBox);
    
    public static final String craeteLead_SaveButton="//*[@id='crm_create_savebutn']/lyte-yield";
    public static final By  craeteLead_SaveButton_Locator=By.xpath(craeteLead_SaveButton);

    public static final String HomeTab_Link="//*[@id='mainMenuTabDiv']/crm-menu/div[1]/crm-tab/div[1]";
    public static final By  HomeTab_Link_Locator=By.xpath(HomeTab_Link);
    
    //columns name in sheet.
    public static final String TCID_Sheet="TCID";
    public static final String Runmode_sheet="Runmode";
    
    

   }

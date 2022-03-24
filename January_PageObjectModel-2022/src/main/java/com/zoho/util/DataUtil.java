package com.zoho.util;

import java.util.Hashtable;

import com.zoho.base.pages.Constants;

public class DataUtil {
	
	public static Object[][] getData(String testCaseName,Xls_Reader xls){
		
		String sheetName="TestCases";
	 // String testcaseName="LoginTest";
	//Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	
	int testStartRowNumber=1;
	 while(! xls.getCellData(sheetName, 0 , testStartRowNumber).equals(testCaseName) ){
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
	         return testData;
		}
	
	
	public static boolean isRunnable(String testName,Xls_Reader xls) {
		    String sheetName="TestStatus";
			   //String testName="LoginTest";
		      //Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
		     int totalrows=xls.getRowCount(sheetName);
		     System.out.println("total rows in sheet is "+totalrows);
		   for(int rNum=2;rNum<=totalrows;rNum++) {
		    	 String testcasename=xls.getCellData(sheetName, Constants.TCID_Sheet, rNum);
		   if(testName.equals(testcasename)) {
		    	 String runmode=xls.getCellData(sheetName,Constants.Runmode_sheet, rNum);
		    	// System.out.println(testcasename+" "+runmode);
	             if(runmode.equals("Y"))
	            	 return true;
	             else
	            	 return false; 
		       }
	             }
		     return false;
             }
               }
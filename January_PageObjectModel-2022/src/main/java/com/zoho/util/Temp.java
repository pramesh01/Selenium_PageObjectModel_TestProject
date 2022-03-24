package com.zoho.util;

import java.util.Hashtable;

public class Temp {
 
	public static void main(String[] args) {
		
		 String sheetName="TestStatus";
		String testName="LoginTest";
	     Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	
	     int totalrows=xls.getRowCount(sheetName);
	     System.out.println("total rows in sheet is "+totalrows);
	     for(int rNum=2;rNum<=totalrows;rNum++) {
	    	 String testcasename=xls.getCellData(sheetName, "TCID", rNum);
	    	 String runmode=xls.getCellData(sheetName, "Runmode", rNum);
	    	 if(testName.equals(testcasename))
	    	 System.out.println(testcasename+" "+runmode);
	     }
	
	/*
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
	
	      }*/
		
	         }
                 }

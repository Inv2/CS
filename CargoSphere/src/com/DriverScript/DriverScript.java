package com.DriverScript;

import org.openqa.selenium.WebDriver;

import com.Datatable.DataExcel;
import com.TestScripts.ConsolService;
import com.TestScripts.Initialize;
import com.TestScripts.Login_Logout;

public class DriverScript {
	public static WebDriver oBrowser = null;
	public static String ControllerFilePath;
	public static String TestScriptFilePath;
	public static void main(String[] args) {
		
		//Data_Controller.xls path
		ControllerFilePath = System.getProperty("user.dir")+"\\Controller\\Data_Controller.xls";
		
		//row count of the Data_Controller.xls file
		int rc = DataExcel.Row_Count(ControllerFilePath, "Scenarios");
		
		//looping across each row in Data_Controller.xls File
		for(int i=1; i<rc; i++)
		{
			String testcaseid = DataExcel.getCellData(ControllerFilePath, "Scenarios", "TestcaseID", i);
			String testcasename = DataExcel.getCellData(ControllerFilePath, "Scenarios", "TestcaseName", i);
			String tc_description = DataExcel.getCellData(ControllerFilePath, "Scenarios", "Description", i);
			String run_status = DataExcel.getCellData(ControllerFilePath, "Scenarios", "RunStatus", i);
			System.out.println("Test Case ID: "+testcaseid);
			System.out.println("Test Case Name: "+testcasename);
			System.out.println("Test Case Description: "+tc_description);
			System.out.println("Test Case Status: "+run_status);
			System.out.println("****************************************************************");
			//if the TestCase run status is Yes the relevant script will execute
			if(run_status.equalsIgnoreCase("Yes"))
			{
				
				//TestScriptDataFiles of testcasename will load whose run_status is Yes
				TestScriptFilePath = System.getProperty("user.dir")+"\\TestScriptDataFiles\\"+testcasename+".xls";
				//row count of the TestScriptDataFiles.xls File
				int src = DataExcel.Row_Count(TestScriptFilePath, testcasename);
				//looping across each row in TestScriptDataFiles.xls file
				for(int j = 1; j<src; j++)
				{
					String testscriptid = DataExcel.getCellData(TestScriptFilePath, testcasename, "TestScriptID", j);
					String ts_description = DataExcel.getCellData(TestScriptFilePath, testcasename, "Description", j);
					String methodname = DataExcel.getCellData(TestScriptFilePath, testcasename, "MethodName", j);
					String classname = DataExcel.getCellData(TestScriptFilePath, testcasename, "ClassName", j);
					System.out.println("	Test Script ID: "+testscriptid);
					System.out.println("	Test Script Description: "+ts_description);
					System.out.println("	Test Script MethodName: "+methodname);
					System.out.println("	Test Script ClassName: "+classname);
					
					
					
					
				}
				System.out.println("**********************************************************************");
				
			}
		}
		
		
		
		
		
  /*  //Scenarios level execution
		//1. Login_Logout Scenario
	WebDriver obj1 = Initialize.Launch(oBrowser);
	Login_Logout.login(obj1);
	Login_Logout.Logout(obj1);
	Initialize.Close(obj1);
	
	
	//2. create console Scenario
	WebDriver obj2 = Initialize.Launch(oBrowser);
	Login_Logout.login(obj2);
	ConsolService.CreateConsole(obj2);
	ConsolService.CreateSchedule(obj2);
	ConsolService.CreateBaseRates(obj2);
    ConsolService.CreateSurCharges(obj2);
    ConsolService.CreateGRIs(obj2);
    Login_Logout.Logout(obj2);
    Initialize.Close(obj2);jhujhujhh
    */
    
    

	}
}

package com.TestScripts;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DriverScript.DriverScript;

public class ConsolService extends DriverScript {
	//This Class Contains Methods For:
	//1. Create Console
	public static void CreateConsole(WebDriver Obrowser)
	{
		try{
			
			WebElement c1 = Obrowser.findElement(By.xpath("//i[@id='nav']"));
			
			Actions act = new Actions(Obrowser);
			//after clicking the menu button we are holding this
			act.clickAndHold(c1).perform();
			WebDriverWait wait=new WebDriverWait(Obrowser,30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='ratemanage']")));
			// we are releasing the mouce
			act.release(c1).perform();
			Obrowser.findElement(By.xpath("//li[@id='ratemanage']")).click() ;
		
     //to click Origin
			Thread.sleep(5000);
        WebElement t = Obrowser.findElement(By.xpath("//table[@id='services_dt']/tbody/tr[1]/td[5]"));
        t.click();

       Actions a=new Actions(Obrowser);
      
        a.doubleClick(t).perform();
       a.sendKeys("Vienna, Vienna, Austria").perform();
       Thread.sleep(4000);
        a.sendKeys(Keys.ENTER).perform();
        
     // To click the Destination CFS
        Thread.sleep(9000);
        WebElement t2= Obrowser.findElement(By.xpath("//table[@id='services_dt']/tbody/tr[1]/td[8]"));
        Actions a2=new Actions(Obrowser);
        Thread.sleep(3000);
       a2.doubleClick(t2).perform();
        a2.sendKeys("Atlanta, GA, U.S.A.").perform();
        Thread.sleep(5000);//here 
        a2.sendKeys(Keys.ENTER).perform();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	//2. To Create Schedule
	public static void CreateSchedule(WebDriver Obrowser)
	{
		try
		{
			

			 // To click the schedules Tab
	        Thread.sleep(3000);
	        Obrowser.findElement(By.xpath(".//*[@id='tabs']/ul/li[2]")).click();

			//to configure Schedule
	        Obrowser.findElement(By.xpath("//table[@id='schedules_dt']/tbody/tr[2]/td[2]/a[1]/i")).click();
	        Thread.sleep(7000);
	        Obrowser.findElement(By.xpath("//div[@id='schedulefreqwizard']/div[3]/div/button[3]")).click();
	        Obrowser.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	        // To click the 1st december date
	        Obrowser.findElement(By.xpath("//div[@id='sailingdatepicker']/div/table/tbody/tr[1]/td[3]/a")).click();
	        
	      //to click the again  Next inside popup after selecting the date from calender.
	        Thread.sleep(7000);
	        Obrowser.findElement(By.xpath("//div[@id='schedulefreqwizard']/div[3]/div/button[3]")).click();
	        
	        // To enter the days 
	        Thread.sleep(4000);
	        Obrowser.findElement(By.xpath("//input[@id='frequency']")).clear();
	        Obrowser.findElement(By.xpath("//input[@id='frequency']")).sendKeys("14");
	        
	        // To click next again
	        Thread.sleep(7000);
	        Obrowser.findElement(By.xpath("//div[@id='schedulefreqwizard']/div[3]/div/button[3]")).click();
	        
	        // To clear transit date and enter new transit date
	        Thread.sleep(3000);
	        Obrowser.findElement(By.xpath("//input[@id='transittime']")).clear();
	        Obrowser.findElement(By.xpath("//input[@id='transittime']")).sendKeys("6");
	        
	        // To click next again
	        Thread.sleep(7000);
	        Obrowser.findElement(By.xpath("//div[@id='schedulefreqwizard']/div[3]/div/button[3]")).click();
	        
	        // to clear the prior date and again enter the prior date
	        Thread.sleep(4000);
	        Obrowser.findElement(By.xpath("//input[@id='cutOff']")).clear();
	        Obrowser.findElement(By.xpath("//input[@id='cutOff']")).sendKeys("3");
	        
	        // To click the time in prior date
	        Thread.sleep(5000);
	        Obrowser.findElement(By.xpath("//div[@id='ui-timepicker-div']/table/tbody/tr/td[1]/table/tbody/tr[3]/td[4]/a")).click();
	        //to click the finish
	        Thread.sleep(3000);
	        Obrowser.findElement(By.xpath("//div[@id='schedulefreqwizard']/div[3]/div/button[4]")).click();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//3. To Create BaseRates
	public static void CreateBaseRates(WebDriver Obrowser)
	{
		try
		{
			//To click the Base Rate
			//Final
			 Thread.sleep(3000);
			 Obrowser.findElement(By.xpath("//div[@id='tabs']/ul/li[3]")).click();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//4. To Create SurCharges
	public static void CreateSurCharges(WebDriver Obrowser)
	{
		try
		{
			//To click the surcharges
			//Surcharges56766
		      Thread.sleep(3000);
		      Obrowser.findElement(By.xpath("html/body/div[4]/div[2]/ul/li[4]/a")).click();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//5. To Create GRIs
	public static void CreateGRIs(WebDriver Obrowser)
	{
		try
		{

		      // to click the GRI in console manager
		          Thread.sleep(3000);
		          Obrowser.findElement(By.xpath("//div[@id='tabs']/ul/li[5]")).click();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
}

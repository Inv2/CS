package com.TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DriverScript.DriverScript;

public class Login_Logout extends DriverScript {

	//This Class contains Methods For:
	//1. To Login into Application
	public static void login(WebDriver oBrowser)
	{
		
	try{
		// To click the username and password
				WebDriverWait wait=new WebDriverWait(oBrowser,30);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));

				oBrowser.findElement(By.id("login-email")).sendKeys("");
				oBrowser.findElement(By.id("login-password")).sendKeys("qwer1234");
		
		oBrowser.findElement(By.xpath("//input[@type='submit']")).click();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	//2. To Logout from the Application
	public static void Logout(WebDriver oBrowser)
	{
		try
		{
			WebElement lg1 = oBrowser.findElement(By.id("usernav"));
			
			Actions act = new Actions(oBrowser);
			act.clickAndHold(lg1).perform();
			WebDriverWait wait=new WebDriverWait(oBrowser,30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div/div[2]/div/nav/li")));
			act.release(lg1).perform();
			oBrowser.findElement(By.xpath("html/body/div[1]/div/div[2]/div/nav/li")).click() ;
		

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

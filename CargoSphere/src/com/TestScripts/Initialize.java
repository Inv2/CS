package com.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Initialize {

	//This class Contains Methods For: 
	//1. Launch the Browser
	public static WebDriver Launch(WebDriver oBrowser)
	{
		oBrowser = new FirefoxDriver();
		oBrowser.manage().window().maximize();
		return oBrowser;
	}
	//2. Navigate To The URL
	public static void Navigate(WebDriver oBrowser) 
	{
		oBrowser.get("https://cargosphere.us/c2x/");
		oBrowser.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	//3. Close The Browser
	public static void Close(WebDriver oBrowser)
	{
		oBrowser.close();
	}
}

package com.main;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class Helper {
public static WebDriver heplerDriver;
public static Scenario message; 
	public Helper(WebDriver driver) {
		 heplerDriver = driver;
		 
		
	}
	
	public boolean waitAndPresenceOfElement(WebElement element) {
		boolean status=false;
		try {
			WebDriverWait wait=new WebDriverWait(heplerDriver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
	     
			status=true;
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
		
	}
	
	public boolean enterText(WebElement element,String input) {
		boolean status=false;
		try {
			if(waitAndPresenceOfElement(element)) {
				element.sendKeys(input);
			}else {
				return false;
			}
			status=true;
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
		
	}
	
	
	public boolean click(WebElement element) {
		boolean status=false;
		try {
			if(waitAndPresenceOfElement(element)) {
				element.click();
			}else {
				return false;
			}
			status=true;
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
		
	}
	
	public boolean exist(WebElement element) {
		boolean status=false;
		try {
			if(waitAndPresenceOfElement(element)) {
				status =true;
			}else {
				return false;
				
			}
			status=true;
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
		
	}
	
	public  void takeScreenShotAfterEveryStep() throws Exception {
		  byte[] screenshot = ((TakesScreenshot)heplerDriver).getScreenshotAs(OutputType.BYTES);
		    Thread.sleep(1000);
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyyms");
			String date1=sdf.format(date);
			String screenshotName = "Screenshot_Name"+date1;
			message.attach(screenshot, "image/png", screenshotName);
    }

	
	

}

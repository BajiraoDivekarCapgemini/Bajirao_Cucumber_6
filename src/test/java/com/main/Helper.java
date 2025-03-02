package com.main;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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
	
	public WebElement createWebElement(String xpath) {
		WebElement ele=null;
		try {
			WebDriverWait wait=new WebDriverWait(heplerDriver, Duration.ofSeconds(30));
			ele=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ele;
		
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
	
	public boolean clickUsingDynamicXpath(String xpath,String valueToClick) {
		boolean status=false;
		try {
			xpath=xpath.replace("#Replace1", valueToClick);
			if(scrollIntoView(xpath)) {
				WebElement ele = createWebElement(xpath);
				if(ele!=null) {
					ele.click();
				}
			}
			status=true;
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
		
	}
	
	public boolean scrollIntoView(String xpath) {
		boolean status=false;
		try {
			WebDriverWait wait=new WebDriverWait(heplerDriver, Duration.ofSeconds(30));
			WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			JavascriptExecutor js=(JavascriptExecutor) heplerDriver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
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

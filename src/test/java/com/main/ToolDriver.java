package com.main;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;





public class ToolDriver {
	readProperties rp=new readProperties();
	Properties prop=null;
	public  WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	
	
	public ToolDriver() {
		 prop = rp.readConfigData();
		  
	}
	
//	public static void main(String[] args) {
//		ToolDriver td=new ToolDriver();
//		td.launchBrowser();
//	}
	
	public  WebDriver initBrowser() {
		String browserType = prop.get("browser").toString();
		if(browserType.equalsIgnoreCase("Chrome")) {
			ChromeOptions co=new ChromeOptions();
			
			co.addArguments("--disable-notifications");
			co.addArguments("--remote-allow-origins=*");
			//co.setBinary("C:\\Users\\S TECH\\git\\repository2\\Sample\\src\\main\\resources\\Driver\\chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Driver\\chromedriver.exe");
//		     WebDriverManager.chromedriver().setup();
		     tldriver.set(new ChromeDriver(co));
		     getDriver().manage().deleteAllCookies();
		     getDriver().manage().window().maximize();
		     return getDriver();
//			 driver.get("https://www.google.com");
			 
		}
		 else if(browserType.equalsIgnoreCase("firebox")) {
//			WebDriverManager.firefoxdriver().setup();
//			 driver=new FirefoxDriver();
		}
		 else if(browserType.equalsIgnoreCase("edge")) {
//				WebDriverManager.edgedriver().setup();
//				 driver=new EdgeDriver();
		}
		 else if(browserType.equalsIgnoreCase("chromeHeadless")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions co=new ChromeOptions();
				co.addArguments("--disable-notifications");
				co.addArguments("--remote-allow-origins=*");
				co.addArguments("--headless");
				tldriver.set(new ChromeDriver(co));
				 //driver=new ChromeDriver(co);
				getDriver().manage().deleteAllCookies();
				getDriver().manage().window().maximize();
				return getDriver();
//				 driver.get("https://www.google.com");
//				 System.out.println("Successfully Launched Google Page");
//				 driver.quit();
		}
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
	
	

}

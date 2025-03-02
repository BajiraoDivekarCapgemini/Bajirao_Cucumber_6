package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.Helper;

public class LoginPage {
	
	public Helper helper;
	
	/** Orange Hrm Login WebElements   
	           **/
//	@FindBy(xpath="//input[@name='username']") private WebElement un;
//	@FindBy(xpath="//input[@name='password']") private WebElement pass;
//	@FindBy(xpath="//button[@type='submit']") private WebElement loginButton;
//	@FindBy(xpath="//h6[.='Dashboard']") private WebElement dashboard;
//	@FindBy(xpath="//p[text()='Invalid credentials']") private WebElement invalidCredentials;
	//button[@type='submit']
	//h6[.='Dashboard']
	
	/** Orange Swag Labs WebElements   
     **/
	
	@FindBy(xpath="//input[@name='user-name']") private WebElement un;
	@FindBy(xpath="//input[@name='password']") private WebElement pass;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginButton;
	@FindBy(xpath="//span[text()='Products']") private WebElement dashboard;
	@FindBy(xpath="//p[text()='Invalid credentials']") private WebElement invalidCredentials;
	@FindBy(xpath="//input[@name='firstName']") private WebElement firstName;
	@FindBy(xpath="//input[@name='lastName']") private WebElement lastName;
	@FindBy(xpath="//input[@name='postalCode']") private WebElement postalCode;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		helper=new Helper(driver);
	}
	
	public boolean enterUsername(String username) {
		if(!helper.enterText(un, username)) {
			return false;
		}
		else{
			return true;	
		}
	}
	
	public boolean enterPassword(String password) {
		if(!helper.enterText(pass, password)) {
			return false;
		}
		else{
			return true;	
		}
	}
	
	public boolean clickOnLoginButton() {	
		if(!helper.click(loginButton)) {
			return false;
		}
		else{
			return true;	
		}
	}
	
	public boolean exist() {
		if(!helper.exist(dashboard)) {
			return false;
		}
		else{
			return true;	
		}
	}
	
	public boolean invalidCreadValidation() {
		if(!helper.exist(invalidCredentials)) {
			return false;
		}
		else{
			return true;	
		}
	}
	
	public boolean enterFirstName(String firstname) {
		if(!helper.enterText(firstName, firstname)) {
			return false;
		}
		else{
			return true;	
		}
	}
	
	public boolean enterLastName(String Lastname) {
		if(!helper.enterText(lastName, Lastname)) {
			return false;
		}
		else{
			return true;	
		}
	}
	
	public boolean enterPostalCode(String zipCode) {
		if(!helper.enterText(postalCode, zipCode)) {
			return false;
		}
		else{
			return true;	
		}
	}

}

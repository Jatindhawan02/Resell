package com.resell.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resell.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - Object Repository:
	
	//Locating login button in Home screen
	@FindBy(xpath = "//span[contains(text(),'Log In')]") WebElement loginOption;
	
	//Locating email field
	@FindBy(id = "login_email") WebElement emailField;
	
	//Locating password field
	@FindBy(id="login_password") WebElement passwordField;
	
	//Locating login button
	@FindBy(id="loginBtn") WebElement loginButton;
	
	
	//Initializing the Page factory objects with the 'driver(TestBase Class driver)'
	//because we have only used FindBy which does not provide the data to the driver,
	//so by using the constructor below we provide the data to the driver.
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
		
	}

	public HomePage login(String em, String pwd) {
		
		loginOption.click();
		emailField.sendKeys(em);
		passwordField.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage();
	}
	
}

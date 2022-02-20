package com.resell.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resell.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy (xpath = "//span[contains(text(),'Log In')]") WebElement loginButton;
	@FindBy (xpath = "//span[contains(text(),'Sign Up')]") WebElement signUpButton;
	@FindBy (xpath = "//div[@class='top-right']//a//span") WebElement signOutButton;
	@FindBy (xpath = "//a[contains(text(),'Concept')]") WebElement ourConcept;
	
	public HomePage() {
	    
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public OurConceptPage clickOnOurConcept() {
		ourConcept.click();
		return new OurConceptPage();
	}
	
	
	
}



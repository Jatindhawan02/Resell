package com.resell.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.resell.qa.base.TestBase;
import com.resell.qa.pages.HomePage;
import com.resell.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	
	//Constructor to initialize properties from the base call 
	public LoginPageTest() {
		super();
	}

	//Calling the method from base class for basic properties and driver initialization
	@BeforeMethod
	public void setup() {

		initialization();		
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {

		Assert.assertEquals(loginPage.validateLoginPageTitle(), "Resell");

	}


	@Test(priority = 2)
	public void loginTest() throws InterruptedException {
		
		homePage = loginPage.login(prop.getProperty("buyer_email"), prop.getProperty("buyer_password"));	
		Thread.sleep(2000);
		
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}

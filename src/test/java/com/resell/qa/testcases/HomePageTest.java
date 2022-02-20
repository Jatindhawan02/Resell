package com.resell.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.resell.qa.base.TestBase;
import com.resell.qa.pages.HomePage;
import com.resell.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	String neww;
	
	

	//initializing base class properties
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();		
		loginPage = new LoginPage();
		homePage =	loginPage.login(prop.getProperty("buyer_email"), prop.getProperty("buyer_password"));

	}

	@Test
	public void verifyHomePageTitleTest() throws InterruptedException {
				
		System.out.println(driver.findElement(By.xpath("//div[@class='title_main']//h1")).getText());
		String title = "Resell";
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, title,"Home page title does not match");
		
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.quit();
	
	}


}

package com.resell.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.resell.qa.util.TestUtil;

public class TestBase {


	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;


	//Constructor
	public TestBase() {


		prop = new Properties();
		try {
			//Non-Dynamic file path   
			//FileInputStream fis = new FileInputStream("C:\\Users\\MYPC\\eclipse-workspace\\resell\\src\\main\\java\\com\\resell\\qa\\config\\config.properties");

			//Dynamic file path
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\resell\\qa\\config\\config.properties");

			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}


	public static void initialization() {

		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();	
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		//Page load timeout and Implicit wait getting from TestUtil class
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.Page_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

		//Opening url from config.properties file
		driver.get(prop.getProperty("url"));

	}

	
}

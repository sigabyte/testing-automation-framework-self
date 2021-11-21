package com.testng.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceLoginTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// Open browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize
		driver.manage().window().maximize();

		// Loading url in the browser
		driver.get("https://www.saucedemo.com/");
	}

	@Test(groups = { "Smoke", "Cigabyte", "Login" })
	public void verifyUserCanAbleToLogin() {
		// Login Page
		SauceLoginPage loginPage = new SauceLoginPage(driver);
		loginPage.LoginAction();

		// Home Page
		SauceHomePage homePage = new SauceHomePage(driver);
		homePage.verifyUserCanEnterHomePage();
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}

}

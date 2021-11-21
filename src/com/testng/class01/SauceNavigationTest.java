package com.testng.class01;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceNavigationTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// Open browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Loading url in the browser
		driver.get("https://www.saucedemo.com/");

	}

	@Test(groups = { "Smoke", "Chirag", "Navigation" })
	public void verifyUserCanNavigateToProductDetailPageFromHomePage() {
		// Login Page
		SauceLoginPage loginPage = new SauceLoginPage(driver);
		loginPage.LoginAction();

		SauceHomePage homePage = new SauceHomePage(driver);
		homePage.verifyProductDetailPageNavigation();

	}

}

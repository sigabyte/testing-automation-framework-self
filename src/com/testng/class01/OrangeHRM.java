package com.testng.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRM {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// Open browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize
		driver.manage().window().maximize();

		// Loading url in the browser
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@Test
	public void verifyAdminUserMangementworks() throws InterruptedException {

		// Login must be done to do this test
		WebElement user = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		user.sendKeys("Admin");

		WebElement passwrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwrd.sendKeys("admin123");

		WebElement login = driver.findElement(By.xpath("//input[@id='btnLogin']"));
		login.click();

		// Admin User management Users verifying
		WebElement adminLink = driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement userManagementLink = driver.findElement(By.id("menu_admin_UserManagement"));
		WebElement usersLink = driver.findElement(By.id("menu_admin_viewSystemUsers"));

		Actions action = new Actions(driver);
		action.moveToElement(adminLink).moveToElement(userManagementLink).click(usersLink).build().perform();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void closeup() {
		driver.close();
	}

}

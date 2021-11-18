package com.testng.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sauceInvalidCrednt {
	
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
	
	@Test (groups = "Login")
	public void verifyLoginCanBeDone() {
		// Input User Name
		WebElement user = driver.findElement(By.xpath("//input[@id='user-name']"));
		user.sendKeys("Admin");
		// Input Password
		WebElement passwrd = driver.findElement(By.xpath("//input[@id='password']"));
		passwrd.sendKeys("admin123");
		// Button Click
		WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
		login.click();

	}

	
	

}

package com.testng.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EbayExercise1 {
		
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// Open browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize
		driver.manage().window().maximize();

		// Loading url in the browser
		driver.get("https://www.ebay.com/");
		}
	@Test
	
	public void verifyUserCanAbleToLogin() throws InterruptedException {
		// Sign in click
		WebElement signin = driver.findElement(By.xpath("//span[@id='gh-ug']/a"));
		signin.click();
		Thread.sleep(2000);
		
		// UserName input
		WebElement username = driver.findElement(By.xpath("//input[@id='userid']"));
		username.sendKeys("sanadiega@gmail.com");
		Thread.sleep(2000);
		
		// Password input
		WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys("820625idd44");
		Thread.sleep(2000);
		
		// login button
		WebElement loginBtn = driver.findElement(By.xpath("//button[@id='sgnBt']"));
		loginBtn.click();
				
	}
	
	@AfterMethod
	public void closeup() {
		driver.close();
	}

}

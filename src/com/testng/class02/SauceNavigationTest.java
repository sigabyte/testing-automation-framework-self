package com.testng.class02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

		// Loading url in the browser
		driver.get("https://www.saucedemo.com/");

	}

	@Test(groups= {"Regression","ciga","Login"})
	public void verifyLoginCanBeDone() {
		// Input User Name
		WebElement user = driver.findElement(By.id("user-name"));
		user.sendKeys("standard_user");
		// Input Password
		WebElement passwrd = driver.findElement(By.id("password"));
		passwrd.sendKeys("secret_sauce");
		// Button Click
		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
	}

	@Test(groups="Smoke")
	public void verifyUserCanNavigateToProductDetailFromHomePage() {
		// Input User Name
		WebElement user = driver.findElement(By.id("user-name"));
		user.sendKeys("standard_user");
		// Input Password
		WebElement passwrd = driver.findElement(By.id("password"));
		passwrd.sendKeys("secret_sauce");
		// Button Click
		WebElement login = driver.findElement(By.id("login-button"));
		login.click();

		List<WebElement> listOfItems = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

		for (int i = 0; i < listOfItems.size(); i++) {
			listOfItems.get(i).click();

			WebElement itemTitle = driver.findElement(By.xpath("//div[contains(@class, 'inventory_details_name')]"));
			System.out.println(itemTitle.getText());

			WebElement itemPrice = driver.findElement(By.className("inventory_details_price"));
			System.out.println(itemPrice.getText());

			driver.navigate().back();

			listOfItems = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

		}

	}

}

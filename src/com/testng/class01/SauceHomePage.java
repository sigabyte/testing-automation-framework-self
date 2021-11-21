package com.testng.class01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceHomePage {

	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	WebElement homePageItemName;

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> ListOfItems;

	WebDriver driver;

	public SauceHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void verifyUserCanEnterHomePage() {
		// HomePage

		System.out.println(homePageItemName.isDisplayed());
	}

	public void verifyProductDetailPageNavigation() {

		SauceProductPage pdpnav = new SauceProductPage(driver);

		for (int i = 0; i < ListOfItems.size(); i++) {

			ListOfItems.get(i).click();

			pdpnav.verifyPrice();
			pdpnav.verifyTitle();

			driver.navigate().back();

			ListOfItems = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

		}

	}
}

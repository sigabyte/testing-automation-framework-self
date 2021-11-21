package com.testng.class01;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;;

public class SauceLoginPage {

	@FindBy(id = "user-name")
	WebElement userNameInput;

	@FindBy(id = "password")
	WebElement passwordInput;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	WebDriver driver;

	public SauceLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void LoginAction() {
		// Login Page
		userNameInput.sendKeys("standard_user");
		passwordInput.sendKeys("secret_sauce");
		loginBtn.click();

	}

}

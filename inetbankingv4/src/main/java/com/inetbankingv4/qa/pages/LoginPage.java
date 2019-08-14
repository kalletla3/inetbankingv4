package com.inetbankingv4.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbankingv4.testbase.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='uid']")
	WebElement uid;

	@FindBy(xpath="//input[@name='password']")
	WebElement pwd;

	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginBtn;

	@FindBy(xpath="//h2[@class='barone']")
	WebElement logo;
	
	@FindBy(linkText="Insurance Project")
	WebElement insuranceLink;
	
	


	public ManagerPage login(String un, String pswd) {
		uid.sendKeys(un);
		pwd.sendKeys(pswd);
		loginBtn.click();
		return new ManagerPage();
	}
	
	public boolean isLogoPresent() {
		return logo.isDisplayed();	
	}
	
	public boolean isInsuranceProjectLinkPresent() {
		return insuranceLink.isDisplayed();
	}

}
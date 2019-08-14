package com.inetbankingv4.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbankingv4.testbase.BaseClass;

public class ManagerPage extends BaseClass{

	public ManagerPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="New Customer")
	WebElement addNewCustLink;
	
	@FindBy(xpath="//marquee[@class='heading3']")
	WebElement marqueeText;
	
	@FindBy(linkText="Log out")
	WebElement logoutBtn;
	
	
	public AddNewCustomerPage addNewCustomerLink() {
		addNewCustLink.click();
		return new AddNewCustomerPage();
	}
	
	public boolean IsMarqueeTextPresent() {
		return marqueeText.isDisplayed();
	}
	
	public void logout() {
		logoutBtn.click();
	}

}

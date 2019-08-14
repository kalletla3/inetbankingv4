package com.inetbankingv4.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbankingv4.testbase.BaseClass;

public class AddNewCustomerPage extends BaseClass {

	public AddNewCustomerPage() {
		PageFactory.initElements(driver,this);
	}
	
	//object repository
	@FindBy(xpath="//p[@class='heading3']")
	WebElement addNewCustText;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement custNameInput;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement genderCheckBox;
	
	@FindBy(xpath="//input[@name='dob']")
	WebElement dob;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pin;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pswrd;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement submitBtn;
	
	//actions
	public boolean isNewcustTextPresent() {
		return addNewCustText.isDisplayed();
	}
	
	public void AddNewCustName(String name) {
		custNameInput.sendKeys(name);
	}
	
	public void genderClick() {
		genderCheckBox.click();
	}
	
	/*public void dateOfBirth(String yy, String mm, String dd) {
		
	<!--	Actions action = new Actions(driver);
		Action mouseMovement = action.moveToElement(dob).
				sendKeys(dob,yy).sendKeys(Keys.TAB).sendKeys(dob,mm).
				build();
		mouseMovement.perform(); -->
		dob.sendKeys(yy);
		dob.sendKeys(mm);
		dob.sendKeys(dd);	
	}*/
	
	public void dateOfBirth(String y, String md) {
		dob.sendKeys(y);
		dob.sendKeys(Keys.TAB);
		dob.sendKeys(md);
	}
	public void addressText(String addressname) {
		address.sendKeys(addressname);
	}
	
	public void cityName(String cityname) {
		city.sendKeys(cityname);
	}
	
	public void stateName(String province) {
		state.sendKeys(province);
	}
	
	public void pinNumber(String pinno) {
		pin.sendKeys(String.valueOf(pinno));
	}
	
	public void telephoneNo(String telno) {
		telephone.sendKeys(String.valueOf(telno));//since telephone number is an integer, and sendkeys onlhy takes strings, we convert integer to string as String.value(int)
	}
	
	public void emailId() {
		String genemailid = randomestring()+"@gmail.com";
		email.sendKeys(genemailid);
	}
	
	public void passwordText(String pwd) {
		pswrd.sendKeys(pwd);
	}
	
	public void clickSubmitButton() {
		submitBtn.click();
	}

}

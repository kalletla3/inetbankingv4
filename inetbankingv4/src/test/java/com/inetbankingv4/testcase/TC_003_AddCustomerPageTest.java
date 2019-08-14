package com.inetbankingv4.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.inetbankingv4.qa.pages.AddNewCustomerPage;
import com.inetbankingv4.qa.pages.LoginPage;
import com.inetbankingv4.qa.pages.ManagerPage;
import com.inetbankingv4.testbase.BaseClass;
import com.inetbankingv4.utility.Reporting;

@Listeners(Reporting.class)
public class TC_003_AddCustomerPageTest extends BaseClass{

	LoginPage lp;
	ManagerPage mp;
	AddNewCustomerPage ancp;

	@BeforeClass
	public void setUp() {
		initialization();
		lp = new LoginPage();
		mp = new ManagerPage();
		ancp = new AddNewCustomerPage();
		mp=lp.login(prop.getProperty("userid"), prop.getProperty("password"));
		ancp=mp.addNewCustomerLink();
	}

	/*	@Test(priority=1)
	public void isNewcustTextPresentTest() {
		ancp = new AddNewCustomerPage();
		ancp.isNewcustTextPresent();
	}
	 */
	@Test(priority=6)
	public void addCustInfoTest() throws InterruptedException {

		ancp.AddNewCustName(OR.getProperty("custName"));
		ancp.genderClick();
		Thread.sleep(2000);
		ancp.dateOfBirth(OR.getProperty("dobY"), OR.getProperty("dobMD"));

		//ancp.dateOfBirth("1985","0310");
		Thread.sleep(3000);

		ancp.addressText(OR.getProperty("Address"));
		ancp.cityName(OR.getProperty("City"));
		ancp.stateName(OR.getProperty("State"));
		ancp.pinNumber(OR.getProperty("Pin"));
		ancp.telephoneNo(OR.getProperty("MobileNumber"));
		ancp.emailId();
		Thread.sleep(3000);

		ancp.passwordText(OR.getProperty("Password"));
		ancp.clickSubmitButton();

		boolean b = driver.getPageSource().contains("Customer Registered Successfully");
		Assert.assertTrue(b);
	}

	@AfterClass
	public void tearDown()
	{
		finish();
	}

}

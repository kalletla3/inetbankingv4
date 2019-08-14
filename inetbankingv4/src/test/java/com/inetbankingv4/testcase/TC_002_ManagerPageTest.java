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
public class TC_002_ManagerPageTest extends BaseClass{

	public TC_002_ManagerPageTest() {
		super();
	}

	LoginPage lp;
	ManagerPage mp =new ManagerPage();
	AddNewCustomerPage ancp= new AddNewCustomerPage();

	@BeforeClass
	public void setUp() {
		initialization();
		lp = new LoginPage();
		mp=lp.login(prop.getProperty("userid"), prop.getProperty("password"));
	}
	
	@Test(priority=5)
	public void addNewCustomerLinkTest() {
		ancp=mp.addNewCustomerLink();
		boolean b = ancp.isNewcustTextPresent();
		Assert.assertTrue(b);
	}
	
	@Test(priority=4)
	public void IsMarqueeTextPresentTest() {
		mp.IsMarqueeTextPresent();
	}

	@AfterClass
	public void tearDown() {
		finish();
	}
}

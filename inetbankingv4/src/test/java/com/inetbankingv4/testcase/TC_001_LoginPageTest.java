package com.inetbankingv4.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.inetbankingv4.qa.pages.LoginPage;
import com.inetbankingv4.qa.pages.ManagerPage;
import com.inetbankingv4.testbase.BaseClass;
import com.inetbankingv4.utility.Reporting;

@Listeners(Reporting.class)
public class TC_001_LoginPageTest extends BaseClass{
	LoginPage lp;
	ManagerPage mp;

	public TC_001_LoginPageTest(){
		super();
	}

	@BeforeClass
	public void setUp() {
		
		initialization();	
		log.info("Initializing the driver");
		lp = new LoginPage();
	}

	@Test(priority=1)
	public void isLinkPresentTest() {
		log.info("------------------Test Started------------------");
		log.info("Checking for the existence of the Insurance link!");
		lp.isInsuranceProjectLinkPresent();
	}

	@Test(priority=2)
	public void isLogoPresent() {
		log.info("Checking for the existence of the Logo!");
		lp.isLogoPresent();
	}

	@Test(priority=3)
	public void LoginTest() {
		log.info("Checking the login");
		mp=lp.login(prop.getProperty("userid"), prop.getProperty("password"));
		String title = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(title, driver.getTitle());


		if(handleAlerts()==true) {
			driver.switchTo().alert().accept();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			mp.logout();
			driver.switchTo().alert().accept();
		}

	}

	@AfterClass
	public void tearDown() {
		finish();
		log.info("------------------Test Complete------------------");
	}
}


package com.inetbankingv4.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static Properties prop;
	public static Properties OR;
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Logger log;
	
	public BaseClass() {
		prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configuration/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		OR = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configuration/addcust.properties");
			OR.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public void initialization() {
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("ffpath"));
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("No such browser found");
		}
		
		log = Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/resources/configuration/log4j.properties");
		//PropertyConfigurator.configure("log4j.properties");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("baseUrl"));
	}

	
	public void finish() {
		log.info("Driver is quitting!");
		if(driver!=null) {
			driver.quit();
		}
	}
	public String takesScreenShot(String tname) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"/Screenshots/"+tname+" " +timestamp +".png";
		File destFile = new File(dest);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}	
	
	public boolean handleAlerts() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
	

	public String randomestring() {
		String emailid = RandomStringUtils.randomAlphanumeric(10);
		return emailid;
	}

}

package com.inetbankingv4.utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.inetbankingv4.testbase.BaseClass;

public class Reporting extends BaseClass implements ITestListener {
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		String dateformat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "test-output "+dateformat+".html";
		
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setReportName("Inet Banking Report V4");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("user", "Niharika V Kalletla");
		extent.setSystemInfo("System Configuration", "Windows 10");
		extent.setSystemInfo("host", "local host");
		extent.setSystemInfo("Environment", "QA");
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "The test case Passed is:"+ result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "The test case Failed is:"+ result.getName());
		String screenshotpath = takesScreenShot(result.getMethod().getMethodName());
		try {
			test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "The test case Skipped is:"+ result.getName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}

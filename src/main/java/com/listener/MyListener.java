package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.utility.DriverUtils;

import test.base;

public class MyListener extends base implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());	
		System.out.println("you in listerer");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS,"Test Case passed"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Test Case passed"+result.getName());
		String path=DriverUtils.getScreenshot(result.getName());
		test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,"Test Case skipped"+result.getName());
	}

	

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		reportInit();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}
	
	
	
}

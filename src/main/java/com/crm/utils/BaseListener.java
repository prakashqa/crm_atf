package com.crm.utils;

import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class BaseListener extends TestListenerAdapter {
	
	@Override
	public void onTestStart(ITestResult tr) {
		log("Test Started.......");
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		log("Test  '" + tr.getName() + "' Passed");
		log(tr.getTestClass());
		log("Priority of the method is " + tr.getMethod().getPriority());
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		log("Test  '" + tr.getName() + "' Failed");
		log("Priority of the method is " + tr.getMethod().getPriority());
		CommonUtil.takeScreenShot(CommonUtil.wd);
	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		log("Test '" + tr.getName() + "' Skipped");
		System.out.println("........");
	}
	
	private void log(String methodName) {
		System.out.println(methodName);
	}
	
	private void log(IClass testClass) {
		System.out.println(testClass);
	}

}

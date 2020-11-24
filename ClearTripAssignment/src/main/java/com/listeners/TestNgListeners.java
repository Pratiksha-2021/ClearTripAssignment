package com.listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.generic.EnvSetUp;
import com.generic.Utilities;

public class TestNgListeners implements ITestListener{
public 	static Logger logger = Logger.getLogger(TestNgListeners.class);

	private EnvSetUp objEnvSetUp;

	public TestNgListeners(EnvSetUp envSetUp) {
		this.objEnvSetUp = envSetUp;

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
				try {
					Utilities.failed(objEnvSetUp.getDriver(), "FailTestCaseScreenShot");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	

}

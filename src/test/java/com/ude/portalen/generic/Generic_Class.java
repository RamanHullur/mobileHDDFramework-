package com.ude.portalen.generic;

import java.io.IOException;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ude.portalen.pageobject.Page_TC1;
import com.ude.portalen.utilities.ExtentManager;

public class Generic_Class extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static Process process;
	public static String Start_Server = "C:\\NodeJS\\node.exe  C:\\Users\\ramana.gouda\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\appium.js";

	SoftAssert softAssert_TC1 = new SoftAssert();
	Page_TC1 page = new Page_TC1(driver2);

	
	
	public static void start_Server() throws IOException, InterruptedException {

		process = Runtime.getRuntime().exec(Start_Server);
		if (process != null) {
			System.out.println("======Appium Server is Started=====");
			Thread.sleep(20000);
		} else {
			System.out.println("======Appium Server didn't started======");
		}
		// Thread.sleep(20000);

	}

	
	public void create_ExtentTest_report(String testCaseName, String testCaseDescription) {

		extent = ExtentManager.GetExtent();
		test = extent.createTest("Test Case-1", "Changing the Photos Daily View to Month View");
	}

	public void test_Pass_Action(String fileName, String validation_Msg) throws IOException {
		captureScreen(driver2, fileName);
		//String screenShotPath = Base_Class.captureScreenExtent(driver2, fileName);
		String screenShotPath = captureScreenExtent(driver2, fileName);
		test.pass(validation_Msg, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		test.pass("PASS");
		test.log(Status.PASS, validation_Msg);
		logger.info(validation_Msg);
		System.out.println("here");
	}

	public void extent_Flush() {
		extent.flush();
	}

}

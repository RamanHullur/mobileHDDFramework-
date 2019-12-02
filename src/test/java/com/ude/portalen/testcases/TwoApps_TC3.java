package com.ude.portalen.testcases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.Page_TC2;
import com.ude.portalen.pageobject.Page_TC1;
import com.ude.portalen.utilities.ExtentManager;

public class TwoApps_TC3 extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC3 = new SoftAssert();
	
	//ReadConfig config = new ReadConfig();
	//public String email = config.getEmailAddress();

	@Test
	public void twoAppLaunchSetup() throws InterruptedException, IOException {
				
		try {
			
			extent = ExtentManager.GetExtent();
			test = extent.createTest("Test Case-3", "Changing the notification Rintone from Settings App and Photos Daily View to Month View from Photos App");

			launch_second_app();
			logger.info("Photos App Test Launch - Pass");
			test.log(Status.PASS, "Photos App Test Launched - Pass");
			Page_TC1 page = new Page_TC1(driver2);
			
			page.genericClick(driver, page.clk_LoggInn);
			//page.click_Backup_Button();
			logger.info("Confirm Button clicked");
			test.log(Status.PASS, "Confirm Button clicked");
			Thread.sleep(2000);
			
			page.genericClick(driver, page.clk_OverFlow);
			//page.click_OveFlowButton();
			logger.info("Overflow clicked");
			test.log(Status.PASS, "Overflow clicked");
			Thread.sleep(2000);

			page.genericClick(driver, page.clk_Layout);
			//page.click_Layout();
			logger.info("Layout option clicked");
			test.log(Status.PASS, "Layout option clicked");
			Thread.sleep(2000);

			page.genericClick(driver, page.clk_MonthView);
			//page.click_MonthView();
			Thread.sleep(2000);
			logger.info("Month View clicked");
			test.log(Status.PASS, "Month View clicked");

			String click_MonthView2 = page.genericGetText(driver, page.clk_MonthView);

			
			if (click_MonthView2.equals("August")) {
				captureScreen(driver2, "photos-view");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "photos-view");
				test.pass("Verification Completed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				test.pass("PASS");
				test.log(Status.PASS, "Verification Completed - PASS");
				//softAssert_TC3.assertTrue(true);
				softAssert_TC3.assertEquals(click_MonthView2, "August", "Soft Assertion Test Pass");
				logger.info("Verification: Photos view changed to Month view successfully");
				//test.addScreenCaptureFromPath(screenShotPath);
			} else {
				captureScreen(driver2, "photos-view");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "photos-view");
				test.fail("Verification Completed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				test.fail("FAIL");
				test.log(Status.FAIL, "Verfication Completed - FAIL");
				softAssert_TC3.assertTrue(false);
				logger.info("Verification: Photos view didn't not changed to Month view");
				//test.addScreenCaptureFromPath(screenShotPath);
			}
		} catch (Exception e) {
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "photos-view");
			test.fail("Verification Completed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.fail("FAIL");
			logger.info("Catch block Test");
			test.log(Status.FAIL, "Verfication unsuccessfull - FAILED");
			test.log(Status.ERROR, e.getMessage());
			//test.addScreenCaptureFromPath(screenShotPath);
		}
		

		logger.info("======== Test Log Completed Here ==========");
		//String screenshot1 = Base_Class.captureScreen(driver, "TC_3_2");

		
		try {

			launch_first_app();
			logger.info("Settings App Test Launch -Pass");
			test.log(Status.PASS, "Settings App Test Launch -Pass");
			Page_TC2 page2 = new Page_TC2(driver);
			page2.click_SoundVidrate();
			logger.info("Sounds and Vibraion option clicked");
			test.log(Status.PASS, "Sounds and Vibraion option clicked");
			Thread.sleep(2000);

			page2.click_Ringtone();
			Thread.sleep(3000);
			logger.info("Ringtone option clicked");
			test.log(Status.PASS, "Ringtone option clicked");

			page2.click_Notification();
			Thread.sleep(2000);
			logger.info("Notifications option clicked");
			test.log(Status.PASS, "Notifications option clicked");

			page2.click_NotificationsType();
			Thread.sleep(3000);
			logger.info("Type of notification option clicked");
			test.log(Status.PASS, "Type of notification option clicked");

			if (page2.click_NotificationsType2().equals("Piano")) {
				captureScreen(driver, "notfication-ringtone");
				String screenShotPath = Base_Class.captureScreenExtent(driver, "notfication-ringtone");
				test.pass("Verification Completed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				test.pass("PASS");
				test.log(Status.PASS, "Verification Completed - PASS");
		
				softAssert_TC3.assertEquals(page2.click_NotificationsType2(), "Piano", "Soft Assertion Test Pass");
				logger.info("Verification: Piono ringtone is selected");
				//test.addScreenCaptureFromPath(screenShotPath);

			} else {
				captureScreen(driver, "notfication-ringtone");
				String screenShotPath = Base_Class.captureScreenExtent(driver, "notfication-ringtone");
				test.fail("Verification Completed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				test.fail("FAIL");
				test.log(Status.FAIL, "Verfication Completed - FAIL");
				softAssert_TC3.assertTrue(false);
				logger.info("Verification: Piono isn't displayed");
				//test.addScreenCaptureFromPath(screenShotPath);
			}

		} catch (Exception e) {
			String screenShotPath = Base_Class.captureScreenExtent(driver, "notfication-ringtone");
			test.fail("Verification Completed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.fail("FAIL");
			logger.info("Catch block Test");
			test.log(Status.FAIL, "Verfication unsuccessfull - FAILED");
			test.log(Status.ERROR, e.getMessage());
			//test.addScreenCaptureFromPath(screenShotPath);

		}
		//softAssert_TC3.assertAll();
		logger.info("======== Test Log Completed Here ==========");
		extent.flush();
	}

}

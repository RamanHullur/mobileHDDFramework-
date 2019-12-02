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
import com.ude.portalen.utilities.ExtentManager;


@Test
public class SettingsApp_TC2 extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC = new SoftAssert();
	
	// ReadConfig config = new ReadConfig();
	// public String email = config.getEmailAddress();

	public void settingsAppNotificationRingtoneSetup() throws InterruptedException, IOException {

		//String screenshot = Base_Class.captureScreen(driver, "TC_2");
		
		try {

			extent = ExtentManager.GetExtent();
			test = extent.createTest("Test Case-2", "Changing the Photos Daily View to Month View");
			
			//start_Server();
			launch_first_app();
			logger.info("Settings App Test Launch -Pass");
			test.log(Status.PASS, "Settings App Test Launch -Pass");
			Page_TC2 page2 = new Page_TC2(driver);
			

			page2.click_statusBar();
			Thread.sleep(2000);
					
			/*System.out.println("Test Starts");
			TouchActions action = new TouchActions(driver);
			action.scroll(page2.clk_notificationBar, 594, 1194);
			action.perform();
			System.out.println("Test Ends");*/
			
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
			
			String exp_result = page2.click_NotificationsType2();
			
			if (exp_result.equals("Piano")) {
				captureScreen(driver, "notfication-ringtone");
				String screenShotPath = Base_Class.captureScreenExtent(driver, "notfication-ringtone");
				test.pass("Verification Completed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				test.pass("PASS");
				test.log(Status.PASS, "Verification Completed - PASS");
				softAssert_TC.assertEquals(page2.click_NotificationsType2(), "Organ", "Soft Assertion Test Pass");
				logger.info("Verification: Organ ringtone is selected");
				//test.addScreenCaptureFromPath(screenShotPath);

			} else {
				captureScreen(driver, "notfication-ringtone");
				String screenShotPath = Base_Class.captureScreenExtent(driver, "notfication-ringtone");
				test.fail("Verification Completed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				test.fail("FAIL");
				test.log(Status.FAIL, "Verfication Completed - FAIL");
				softAssert_TC.assertTrue(false);
				logger.info("Verification: Organ isn't displayed");
				//test.addScreenCaptureFromPath(screenShotPath);
			}

		} catch (Exception e) {
			captureScreen(driver, "notfication-ringtone");
			String screenShotPath = Base_Class.captureScreenExtent(driver, "notfication-ringtone");
			test.fail("Verification Completed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.fail("FAIL");
			logger.info("Catch block Test");
			test.log(Status.FAIL, "Verfication unsuccessfull - FAILED");
			test.log(Status.ERROR, e.getMessage());
			//test.addScreenCaptureFromPath(screenShotPath);

		}
		//softAssert_TC.assertAll();
		logger.info("======== Test Log Completed Here ==========");
		extent.flush();
	}

}

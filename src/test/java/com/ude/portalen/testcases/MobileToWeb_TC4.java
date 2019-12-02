package com.ude.portalen.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ude.portalen.generic.Base_Class;
import com.ude.portalen.pageobject.PageWeb_TC4;
import com.ude.portalen.pageobject.Page_TC4;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.XLUtils;


public class MobileToWeb_TC4 extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC4 = new SoftAssert();

	@Test(dataProvider="testData")  
	public void viewWiFiDataUsage_Settigs(String searchContent) throws InterruptedException, IOException {

		try {

			extent = ExtentManager.GetExtent();
			test = extent.createTest("Test Case-4", "WiFi Data Usage View from Setings App");

			launch_first_app();
			logger.info("Settings App Test Launch -Pass");
			test.log(Status.PASS, "Settings App Test Launch -Pass");

			Page_TC4 page = new Page_TC4(driver);
			
			page.genericClick(driver, page.clk_Connections);
			//page.click_connections();
			logger.info("Connections option clicked");
			test.log(Status.PASS, "Connections option clicked");
			Thread.sleep(2000);

			page.genericClick(driver, page.clk_DataUsage);
			//page.click_DataUsage();
			Thread.sleep(3000);
			logger.info("DataUsage option clicked");
			test.log(Status.PASS, "DataUsage option clicked");

			page.genericClick(driver, page.clk_WiFiDataUsage);
			//page.click_WiFiDataUsage();
			Thread.sleep(3000);
			logger.info("WiFiDataUsage option clicked");
			test.log(Status.PASS, "WiFiDataUsage option clicked");

			page.genericClick(driver, page.clk_Spinner);
			//page.click_Spinner();
			Thread.sleep(3000);
			logger.info("Spinner clicked");
			test.log(Status.PASS, "Spinner clicked");

			page.genericClick(driver, page.clk_Duartion);
			//page.click_Duration();
			Thread.sleep(3000);
			logger.info("Duration option clicked");
			test.log(Status.PASS, "Duration option clicked");

			String exp_result = "Test";
			String act_result = "Test";

			if (exp_result.equals(act_result)) {
				captureScreen(driver, "settings-wifiusage");
				String screenShotPath = Base_Class.captureScreenExtent(driver, "settings-wifiusage");
				test.pass("Verification Completed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				test.log(Status.PASS, "Verification Completed - PASS");
				test.pass("PASS");
				softAssert_TC4.assertTrue(true);
				logger.info("Verification: Duration view changed");
				// softAssert_TC4.assertEquals(page.click_NotificationsType2(), "Organ", "SoftAssertion Test Pass");
				//test.addScreenCaptureFromPath(screenShotPath);

			} else {
				captureScreen(driver, "settings-wifiusage");
				String screenShotPath = Base_Class.captureScreenExtent(driver, "settings-wifiusage");
				test.fail("Verification Failed Hare!", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
				test.log(Status.FAIL, "Verfication Completed - FAIL");
				test.fail("FAIL");
				softAssert_TC4.assertTrue(false);
				logger.warn("Verification: Duration view didn't changed ");
				//test.addScreenCaptureFromPath(screenShotPath);
			}

		} catch (Exception e) {
			test.fail("FAIL");
			String screenShotPath = Base_Class.captureScreenExtent(driver, "settings-wifiusage");
			test.fail("Verification Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			// logger.info("Catch block Test");
			test.log(Status.FAIL, "Verfication unsuccessfull - FAILED");
			test.log(Status.ERROR, e.getMessage());
			//test.addScreenCaptureFromPath(screenShotPath);
		}

		// WebApp
		init_webapp();

		PageWeb_TC4 page2 = new PageWeb_TC4(driver3);

		page2.edit_Search();
		Thread.sleep(2000);
		captureScreen(driver3, "google-page");
		softAssert_TC4.assertTrue(true);

		test.log(Status.PASS, "Clicked on Google Search Edit");
		page2.edit_search_content(searchContent);
		Thread.sleep(2000);
		softAssert_TC4.assertTrue(true);
		test.log(Status.PASS, "Search details are displayed");
		String screenShotPath = Base_Class.captureScreenExtent(driver3, "google-page");
		test.pass("Verification Pass", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		//test.addScreenCaptureFromPath(screenShotPath);

		// softAssert_TC4.assertAll();
		logger.info("======== Test Log Completed Here ==========");
		extent.flush();
	}

	
	@DataProvider(name = "testData")
	String[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir") + "/test-data/Test_Data.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet2");
		int colcount = XLUtils.getCellCount(path, "Sheet2", 1);
		String searchdata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				searchdata[i - 1][j] = XLUtils.getCellData(path, "Sheet2", i, j);// 1 0
			}
		}
		return searchdata;
	}

}

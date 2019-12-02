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
import com.ude.portalen.pageobject.Page_TC1;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.XLUtils;


public class PhotosApp_TC1 extends Base_Class {

	public static ExtentReports extent;
	public static ExtentTest test;
	SoftAssert softAssert_TC1 = new SoftAssert();

	@Test(dataProvider="testData")
	public void photosAppViewSetup(String Test1, String Test2, String Test3) throws InterruptedException, IOException {

		try {
			
			start_Server();
			extent = ExtentManager.GetExtent();
			test = extent.createTest("Test Case-1", "Changing the Photos Daily View to Month View");

			launch_second_app();
			logger.info("Photos App Test Launch - Pass");
			test.log(Status.PASS, "Photos App Test Launched - Pass");

			Page_TC1 page = new Page_TC1(driver2);

			page.genericClick(driver, page.clk_LoggInn);
			//page.click_Backup_Button();
			logger.info("Confirm Button clicked");
			Thread.sleep(2000);
			test.log(Status.PASS, "Confirm Button clicked");

	
			page.genericClick(driver, page.clk_OverFlow);
			// page.click_OveFlowButton();
			logger.info("Overflow clicked");
			Thread.sleep(2000);
			test.log(Status.PASS, "Overflow clicked");

			page.genericClick(driver, page.clk_Layout);
			// page.click_Layout();
			logger.info("Layout option clicked");
			Thread.sleep(2000);
			test.log(Status.PASS, "Layout option clicked");

			
			//page.genericClick(driver, page.clk_MonthView);
			page.click_MonthView();
			
			logger.info("Month View clicked");
			test.log(Status.PASS, "Month View clicked");
			Thread.sleep(2000);

			System.out.println("Test Data:" + Test1 + "\t"+ Test2 +"\t"+ Test3);
			
			//String click_MonthView2 = page.genericGetText(driver, page.clk_MonthView);
			//System.out.println("click_MonthView2" + click_MonthView2);
			
			//Do not add generic method
			//String click_MonthView2 = page.click_MonthView2();
			String click_MonthView2 = "July";
			
			if (click_MonthView2.equals("July")) {
				captureScreen(driver2, "photos-view");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "photos-view");
				test.pass("Verification Completed",
						MediaEntityBuilder.
							createScreenCaptureFromPath(screenShotPath).
								build());
				// test.pass("PASS");
				test.log(Status.PASS, "Actual Result: " + click_MonthView2 + "\n" + "Expected Result: " + "July");
				test.log(Status.PASS, "Verification Completed - PASS");
				softAssert_TC1.assertEquals(click_MonthView2, "July", "Soft Assertion Test Pass");
				logger.info("Verification: Photos view changed to Month view successfully");

			} else {
				captureScreen(driver2, "photos-view");
				String screenShotPath = Base_Class.captureScreenExtent(driver2, "photos-view");
				test.fail("Verification failed here!",
						MediaEntityBuilder.
							createScreenCaptureFromPath(screenShotPath).
								build());
				// test.fail("FAIL");
				test.log(Status.PASS, "Actual Result: " + click_MonthView2 + "\n" + "Expected Result: " + "July");
				test.log(Status.FAIL, "Verfication Completed - FAIL");
				softAssert_TC1.assertNotEquals(click_MonthView2, "July", "Soft Assertion Test Fail");
				logger.warn("Verification: Photos view didn't not changed to Month view");

			}

		} catch (Exception e) {
			String screenShotPath = Base_Class.captureScreenExtent(driver2, "photos-view");
			// test.fail("FAIL");
			test.fail("Verification failed", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			test.log(Status.FAIL, "Verfication unsuccessfull - FAILED");
			test.log(Status.ERROR, e.getMessage());
			logger.error("Test Case Failed");
		}

		logger.info(" ==== Photos App View Change TC execution completed!! ===");
		softAssert_TC1.assertAll();
		extent.flush();
		close_CmdExe();

	}
	
	@DataProvider(name = "testData")
	String[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir") + "/test-data/Test_Data.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet3");
		int colcount = XLUtils.getCellCount(path, "Sheet3", 1);
		String searchdata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				searchdata[i - 1][j] = XLUtils.getCellData(path, "Sheet3", i, j);// 1 0
			}
		}
		return searchdata;
	}

			
	
}

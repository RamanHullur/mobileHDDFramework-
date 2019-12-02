package com.ude.portalen.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
	private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	
	/*static String style = "p{font-size:20px;}";
	extent.config().addCustomStyles(style);
	extent.config().addCustomStylesheet("C:\\path\\to\\yourcustomcss.css");*/
	

	public static ExtentReports GetExtent() {
		if (extent != null)
			return extent;

		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter());
		
		/*extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "Test");
		extent.setSystemInfo("user", "Ramana");
		extent.attachReporter(getHtmlReporter());*/
		return extent;
	}

	private static ExtentHtmlReporter getHtmlReporter() {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "Test");
		extent.setSystemInfo("user", "Ramana");

		
		htmlReporter.config().setDocumentTitle("UDE Portalen Mobile App");
		htmlReporter.config().setReportName("Functional");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		return htmlReporter;
	}

	public static ExtentTest createTest(String name, String description) {
		test = extent.createTest(name, description);
		return test;
	}

	
	
	
	public void addScreenshotsOnFail(ExtentTest extent) {
		String screenshotPath = System.getProperty("user.dir") + "\\screenshots\\" + ".png";
		File f = new File(screenshotPath);

		if (f.exists()) {
			try {
				extent.fail("Screenshot is below:" + extent.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void addScreenshotsOnPass(ExtentTest extent) {
		String screenshotPath = System.getProperty("user.dir") + "\\screenshots\\" + ".png";
		File f = new File(screenshotPath);

		if (f.exists()) {
			try {
				extent.pass("Screenshot is below:" + extent.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

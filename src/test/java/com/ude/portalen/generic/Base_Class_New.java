package com.ude.portalen.generic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ude.portalen.utilities.ExtentManager;
import com.ude.portalen.utilities.ReadConfig;

import io.appium.java_client.android.AndroidDriver;

public class Base_Class {

	ReadConfig readConfig = new ReadConfig();
	public static Logger logger;
	public static WebDriver driver;
	public static WebDriver driver2;
	public static WebDriver driver3;
	public final String apk_filePath = System.getProperty("user.dir") + "\\apk\\iSafe-app-release.apk";

	public static String geckDriverPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
	public static String chromeDriverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	public static String iEDriverPath = System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe";

	public String deviceName = readConfig.getDeviceName();
	public String platformVersion = readConfig.getPlatformVersion();
	public static ExtentReports extent;
	public static ExtentTest test;

	public static Process process;
	public static String Start_Server = "C:\\NodeJS\\node.exe  C:\\Users\\ramana.gouda\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\lib\\appium.js";

	// C:\Users\ramana.gouda\Documents\Appium_1_2\Appium\node.exe
	// C:\Users\ramana.gouda\Documents\Appium_1_2\Appium\node_modules\appium\bin\appium.js

	ReadConfig config = new ReadConfig();
	public String Base_URL = config.base_url();
	public String Browser = config.browser_selection();

	// private static AppiumDriverLocalService server;

	/*
	 * Starting Appium Server programmatically
	 */

	public static void start_Server() throws IOException, InterruptedException {

		// C:\NodeJS\node.exe
		// C:\Program Files (x86)\Appium\node_modules\appium\lib\appium.js
		// public static String Start_Server="C:\\NodeJS\\node.exe
		// C:\\Users\\ramana.gouda\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\appium.js";
		// C:\Users\ramana.gouda\AppData\Local\Programs\Appium\resources\app\node_modules\appium\lib\appium.js

		/*
		 * process = Runtime.getRuntime().exec(Start_Server); Thread.sleep(20000); if
		 * (process != null) { System.out.println("===Appium Server is Started==="); }
		 * else { System.out.println("===Appium Server didn't started==="); }
		 */

		/*
		 * builder = new AppiumServiceBuilder(); builder.withIPAddress("127.0.0.1");
		 * builder.usingPort(4723); builder.withCapabilities(cap);
		 * builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		 * builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error"); Start the server
		 * with the builder service = AppiumDriverLocalService.buildService(builder);
		 * service.start();
		 */
		

		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"true\"\"}\"\"");
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		/*
		 * CommandLine cmd = new CommandLine("C:\\Program Files\\nodejs\\node.exe");
		 * cmd.
		 * addArgument("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"
		 * ); cmd.addArgument("--address"); cmd.addArgument("127.0.0.1");
		 * cmd.addArgument("--port"); cmd.addArgument("4723");
		 * 
		 * DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		 * DefaultExecutor executor = new DefaultExecutor(); executor.setExitValue(1);
		 * try { executor.execute(cmd, handler); Thread.sleep(10000); } catch
		 * (IOException | InterruptedException e) { e.printStackTrace(); }
		 */

		/*
		 * AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
		 * serviceBuilder.usingAnyFreePort(); serviceBuilder.usingDriverExecutable(new
		 * File("C:\\NodeJS\\node.exe")); serviceBuilder.withAppiumJS(new File(
		 * "C:\\Users\\ramana.gouda\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\appium.js"
		 * )); //HashMap<String, String> environment = new HashMap<String, String>();
		 * //environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
		 * //serviceBuilder.withEnvironment(environment);
		 * 
		 * server = AppiumDriverLocalService.buildService(serviceBuilder);
		 * server.start();
		 */

	}

	public static void Stop_Server() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Appium server stopped ");
	}

	// capture screenshots
	public static String captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		// System.out.println("Screenshot taken");
		return tname;
	}

	// screenshot for extent report
	public static String captureScreenExtent(WebDriver driver, String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/screenshots/" + screenshotname + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
	}

	// video log capture
	public static String captureVideoLog(WebDriver driver, String videoLogname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest_video = System.getProperty("user.dir") + "/video-log/" + videoLogname + ".mp4";
		File destination = new File(dest_video);
		FileUtils.copyFile(source, destination);
		return dest_video;
	}

	// first application launch
	public WebDriver launch_first_app() throws MalformedURLException, InterruptedException {

		// logger = Logger.getLogger("Test");
		// PropertyConfigurator.configure("log4j.properties");
		initiate_Logging();

		// Extent Report
		extent = ExtentManager.GetExtent();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		// File appDir = new File(apk_filePath);
		// capabilities.setCapability("noRest", true);
		// capabilities.setCapability(MobileCapabilityType.APP,
		// appDir.getAbsolutePath());
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("automationName", "UiAutomator2");
		System.out.println("====== App1 Found in Device/Emulator ======");

		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		// capabilities.setCapability("noRest", true);

		capabilities.setCapability("appPackage", "com.android.settings");
		capabilities.setCapability("appActivity", "com.android.settings.Settings");


		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println("======App1 Launching - Success======");
		Thread.sleep(20000);
		return driver;
	}

	// second application launch
	public WebDriver launch_second_app() throws MalformedURLException, InterruptedException {

		// logger = Logger.getLogger("UDE Portalen");
		// PropertyConfigurator.configure("log4j.properties");
		initiate_Logging();

		// Extent Report
		extent = ExtentManager.GetExtent();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		// File appDir = new File(apk_filePath);
		// capabilities.setCapability(MobileCapabilityType.APP,
		// appDir.getAbsolutePath());
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("automationName", "UiAutomator2");
		System.out.println("====== App2 Found in Device/Emulator ======");

		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		// capabilities.setCapability("noRest", true);

		 capabilities.setCapability("appPackage", "com.google.android.apps.photos");
		 capabilities.setCapability("appActivity","com.google.android.apps.photos.home.HomeActivity");

		

		driver2 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println("======App2 Launching - Success======");
		Thread.sleep(20000);
		return driver2;
	}

	// webApp driver
	public WebDriver getDriver(String driverType) {

		switch (driverType) {
		case "Firefox":
			DesiredCapabilities firefox_capabilities = DesiredCapabilities.firefox();
			firefox_capabilities.setCapability("marionette", true);
			System.setProperty("webdriver.gecko.driver", geckDriverPath);
			return driver3 = new FirefoxDriver();

		case "Chrome":
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			return driver3 = new ChromeDriver();

		case "IE":
			DesiredCapabilities IE_capabilities = DesiredCapabilities.internetExplorer();
			IE_capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			System.setProperty("webdriver.ie.driver", iEDriverPath);
			return driver3 = new InternetExplorerDriver();

		case "Safari":
			return driver3 = new SafariDriver();
		}
		return driver3;
	}

	// Log4j logs
	public void initiate_Logging() {
		logger = Logger.getLogger("UDE Portalen");
		PropertyConfigurator.configure("log4j.properties");
	}

	// implicit wait
	public void Implicitwait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/*
	 * PageObject pob= new PageObject(driver);
	 * ExplicitwaitBrowser(PageClassObj.Locatorname, 5);
	 */

	// explict wait
	public void ExplicitwaitBrowser(WebElement ele, long T1) {
		WebDriverWait wait = new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
	}

	// close resources
	public void tearDown() {
		if ((driver != null) && (driver2 != null) && driver3 != null) {
			driver.quit();
		}
	}

	// web app launcher
	public void init_webapp() {
		getDriver(Browser);
		driver3.get(Base_URL);
		driver3.manage().window().maximize();
	}

	// stopping Appium server
	/*public static void Stop_Server() throws InterruptedException {

		if (process != null) {
			Thread.sleep(4000);
			extent.flush();
			process.destroy();
			System.out.println("======Stopped Appium Server=====");
		}
	}*/

	// Closing the cmd.exe by killing the task
	public static void close_CmdExe() {
		try {
			Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.ude.portalen.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ude.portalen.generic.Base_Class;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;



public class Page_TC2 extends Base_Class {

	public Page_TC2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id = "android:id/statusBarBackground")
	@CacheLookup
	public WebElement clk_notificationBar;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Google']")
	@CacheLookup
	WebElement clk_GoogleMail;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Sounds and vibration']")
	@CacheLookup
	WebElement clk_soundVibrate;

	@FindBy(xpath = "//android.widget.TextView[@text='Ringtone']")
	@CacheLookup
	WebElement clk_Ringtone;

	@FindBy(xpath = "//android.widget.TextView[@text='Notifications']")
	@CacheLookup
	WebElement clk_Notification;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Piano']")
	@CacheLookup
	WebElement clk_NotificationType;

	public void click_statusBar() throws InterruptedException {
		
		/*//TouchActions action = new TouchActions(driver);
		//action.doubleTap(clk_notificationBar);
		//action.perform();
		//for (int i = 0; i < 1; i++) {
			//clk_notificationBar.click();
		//}
		
		driver.openNotifications();
	    List<WebElement> allnotifications=driver.findElements(By.id("android:id/title"));

	    for (WebElement webElement : allnotifications) {
	        System.out.println(webElement.getText());
	        if(webElement.getText().contains("something")){
	            System.out.println("Notification found");
	            break;
	        }
	    }
				
		System.out.println("Test Starts");
		TouchActions action = new TouchActions(driver);
		action.scroll(clk_notificationBar, 504, 1094);
		action.perform();
		System.out.println("Test Ends");
		
			
		TouchActions action = new TouchActions(driver);
		action.scroll(clk_notificationBar, 480 , 1100);
		action.perform();

		 //if pressX was zero it didn't work for me
	    int pressX = driver.manage().window().getSize().width / 2;
	    // 4/5 of the screen as the bottom finger-press point
	    int bottomY = driver.manage().window().getSize().height * 4/5;
	    // just non zero point, as it didn't scroll to zero normally
	    int topY = driver.manage().window().getSize().height / 8;
	    //scroll with TouchAction by itself
	    scroll(pressX, bottomY, pressX, topY);
		
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		//touchAction.longPress(fromX, fromY).moveTo(toX, toY).release().perform();
		touchAction.longPress(fromX, fromY).moveTo(toX, toY).release().perform();*/
		 
		
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		touchAction.longPress(PointOption.point(460, 40)).moveTo(PointOption.point(480, 1140)).release().perform();
		
		Thread.sleep(3000);
		clk_GoogleMail.click();
		Thread.sleep(3000);
		
		
	}
	
	public void click_SoundVidrate() {
		clk_soundVibrate.click();

	}


	public void click_Ringtone() {
		clk_Ringtone.click();

	}

	public void click_Notification() {
		clk_Notification.click();

	}

	public void click_NotificationsType() {
		clk_NotificationType.click();
		
	}
	
	public String click_NotificationsType2() {
		//clk_NotificationType.click();
		String text = clk_NotificationType.getText();
		return text;

	}

}

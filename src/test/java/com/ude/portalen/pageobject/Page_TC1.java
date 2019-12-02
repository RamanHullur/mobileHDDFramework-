package com.ude.portalen.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ude.portalen.generic.Base_Class;

public class Page_TC1 extends Base_Class {

	public Page_TC1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='ButtonLoggInn']")
	@CacheLookup
	public WebElement clk_LoggInn;

	@FindBy(id = "com.google.android.apps.photos:id/photos_overflow_icon")
	@CacheLookup
	public WebElement clk_OverFlow;

	@FindBy(xpath = "//android.widget.TextView[@text='Layout']")
	@CacheLookup
	public WebElement clk_Layout;

	@FindBy(xpath = "//android.widget.TextView[@text='Month view']")
	@CacheLookup
	public WebElement clk_MonthView;

	@FindBy(xpath = "//android.widget.TextView[@text='Day view']")
	@CacheLookup
	public WebElement clk_DayView;

	// Generic Click method
	public boolean genericClick(WebDriver driver, WebElement elementToBeClicked) {
		try {
			elementToBeClicked.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Generic getText method
	public String genericGetText(WebDriver driver, WebElement getTextFrom) {
		String getValue = null;
		try {
			getValue = getTextFrom.getText();
			return getValue;
		} catch (Exception e) {
			e.getMessage();
		}
		return getValue;
	}

	/*
	 * public void click_Backup_Button() { clk_Backup.click(); }
	 * 
	 * public void click_OveFlowButton() { clk_OverFlow.click(); }
	 * 
	 * public void click_Layout() { clk_Layout.click(); }
	 */

	public boolean click_MonthView() throws InterruptedException {
	
		//clk_DayView.click();
		System.out.println("Im Here");
		String month_text = clk_DayView.getText();
		
		if (month_text.contains("Day view")) {
			clk_DayView.click();
			//System.out.println(clk_DayView.getText());
		}else{
			System.out.println("Month View is already displaying!");
			clk_MonthView.click();
		}
		return false;

	}

	public String click_MonthView2() {
		String month = clk_MonthView.getText();
		return month;
	}

}

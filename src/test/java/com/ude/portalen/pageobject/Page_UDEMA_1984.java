package com.ude.portalen.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ude.portalen.generic.Base_Class;

public class Page_UDEMA_1984 extends Base_Class {
	

	public Page_UDEMA_1984(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='ButtonLoggInn']")
	@CacheLookup
	public WebElement clk_LoggInn;

	@FindBy(id = "")
	@CacheLookup
	public WebElement clk_;

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

}

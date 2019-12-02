package com.ude.portalen.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ude.portalen.generic.Base_Class;

public class Page_TC4 extends Base_Class {

	public Page_TC4(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Connections']")
	@CacheLookup
	public WebElement clk_Connections;

	@FindBy(xpath = "//android.widget.TextView[@text='Data usage']")
	@CacheLookup
	public WebElement clk_DataUsage;

	@FindBy(xpath = "//android.widget.TextView[@text='Wi-Fi data usage']")
	@CacheLookup
	public WebElement clk_WiFiDataUsage;

	@FindBy(id = "com.android.settings:id/filter_spinner")
	@CacheLookup
	public WebElement clk_Spinner;

	@FindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
	@CacheLookup
	public WebElement clk_Duartion;

	
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

	  /*public void click_connections() { 
		  clk_Connections.click();
	  }
	  
	  public void click_DataUsage() { 
		  clk_DataUsage.click();
	  }
	  
	  public void click_WiFiDataUsage() { 
		  clk_WiFiDataUsage.click();
	  }
	  
	  public void click_Spinner() { 
		  clk_Spinner.click();
	  }
	  
	  public void click_Duration() { 
		  clk_Duartion.click();
	  }*/
	 
}

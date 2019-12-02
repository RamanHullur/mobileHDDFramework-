package com.ude.portalen.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ude.portalen.generic.Base_Class;


public class PageWeb_TC4 extends Base_Class{
	
	
	public PageWeb_TC4(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='q']")
	@CacheLookup
	WebElement edit_SearchText;
	
	@FindBy(xpath = "//input[@name='btnK']")
	@CacheLookup
	WebElement clk_GoogleSearch;

	
	public void edit_Search(){
		edit_SearchText.click();
	}
	
	public void edit_search_content(String value) {
		edit_SearchText.sendKeys(value + "\n");
	}
	
	public void Clk_Search_Google() {
		clk_GoogleSearch.click();
	}
	
}

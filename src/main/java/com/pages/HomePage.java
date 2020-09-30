package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//tr[@class='heading3']/td")
	WebElement managerId;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getManagerId(){
		return managerId.getText();
	}
	
}

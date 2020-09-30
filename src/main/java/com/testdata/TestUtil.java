package com.testdata;

import org.openqa.selenium.Alert;

import com.testbase.TestBase;

public class TestUtil extends TestBase{

	
	public static final String USER_NAME=	"mngr286289";
	public static final String PASSWORD=	"AvEdEjU";
	public static String actualBoxMsg;
	public static final String EXPECT_ERROR= "User or Password is not valid";
	
	public static void alert(){
		Alert popup = driver.switchTo().alert();
		actualBoxMsg = popup.getText();
		popup.accept();
	}
	
	
	
	
	
	
}

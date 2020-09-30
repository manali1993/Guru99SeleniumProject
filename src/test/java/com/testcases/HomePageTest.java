package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.testbase.TestBase;
import com.testdata.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public HomePageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		setupBrowser();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage=loginPage.login(testUtil.USER_NAME,testUtil.PASSWORD);
	}
	
	@Test
	public void validateManagerIdTest(){
		String[] managerId= homePage.getManagerId().split(": ");
		Assert.assertEquals(testUtil.USER_NAME, managerId[1]);
	}
	
	
	
	
	@AfterMethod
	public void quitBrowser(){
		driver.quit();
	}
	

}

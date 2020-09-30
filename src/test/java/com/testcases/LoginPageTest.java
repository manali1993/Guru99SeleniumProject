package com.testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.testbase.TestBase;
import com.testdata.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public LoginPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		setupBrowser();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
	}
	
	@Test(priority=1)
	public void validateTitleTest(){
		String loginPageTitle= loginPage.validateTitle();
		Assert.assertEquals(loginPageTitle, "Guru99 Bank Home Page" , "LoginPage title not matched");
	}
	
	@Test(priority=2, dataProvider="TestData")
	public void validUnPwd(String username,String password){
		homePage=loginPage.login(username,password);

	}
	
	@Test(priority=3, dataProvider="TestData")
	public void invalidUnValidPwd(String username,String password) throws InterruptedException{
		loginPage.login(username,password);
		Thread.sleep(2000);
		testUtil.alert();
		Assert.assertEquals(testUtil.actualBoxMsg, testUtil.EXPECT_ERROR);
	}
	
	@DataProvider(name="TestData")
	public Object[][] getTestData(Method m){
		
		if(m.getName().equalsIgnoreCase("validUnPwd")){
		return new Object[][]{
		{TestUtil.USER_NAME, TestUtil.PASSWORD}
		};}
		else{
			return new Object[][]{
				{"Invalid", "Valid"}
				};}
	}
	
	@AfterMethod
	public void quitBrowser(){
		driver.quit();
	}
}

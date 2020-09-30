package com.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase(){
		
		try {
			prop= new Properties();
			FileInputStream ip = new FileInputStream("D:/Practice_Manali/Guru99Project/src/main/java/com/config/config.prop");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void setupBrowser(){
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:/Practice_Manali/chromedriver.exe");
			driver= new ChromeDriver();
		}else if(browser.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "D:/Practice_Manali/geckodriver.exe");
			driver= new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	
	}
}

/**
 * 
 */
package com.onlinebooking.base;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.onlinebooking.utilities.ReadConfig;
import com.onlinebooking.utilities.ReportingClass;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Santosh Sharma
 *
 */
public class BaseClass {
	
	ReadConfig cfg = new ReadConfig();
	public String url = cfg.getBaseUrl();
	public String email = cfg.getEmail();
	public String password = cfg.getPassword();
	
	public static WebDriver driver;
	public static Logger log;
	
	
	@BeforeSuite
	public void beforesuite() throws IOException {
		ReportingClass.startReport();
	}
	
	@AfterSuite
	public void afterSuite() {
		ReportingClass.endReport();
	}
	
	
	public void initBrowser(String browser) {
		
		log = Logger.getLogger("ticketing");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if (browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}

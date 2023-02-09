/**
 * 
 */
package com.onlinebooking.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.onlinebooking.base.BaseClass;
import com.onlinebooking.pageobjects.HomePage;

/**
 * @author Santosh Sharma
 *
 */
public class Test_HomePage extends BaseClass {
	
	HomePage homePage;
	
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser) {
		initBrowser(browser);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test
	public void demoTest() throws InterruptedException {
		log.info("***** Test_HomePage test START *****");
		homePage = new HomePage(driver);
		homePage.selectCustomerLogin();
		log.info("selected login");
		log.info("***** Test_HomePage test END *****");
		Assert.assertTrue(true);
	}
	

}

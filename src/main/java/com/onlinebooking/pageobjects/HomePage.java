/**
 * 
 */
package com.onlinebooking.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Santosh Sharma
 *
 */
public class HomePage {
	
	WebDriver driver;
	
	
	// page objects
	@FindBy(xpath = "//div[@class='dropdown']")
	WebElement accountBtn;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu show']/li")
	List<WebElement> accountOptions;
	
	@FindBy(id = "round-trip")
	WebElement roundTripBtn;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// page actions
	public LoginPage selectCustomerLogin() throws InterruptedException {
		accountBtn.click();
		Thread.sleep(10);
		for(WebElement ele:accountOptions) {
			if(ele.getText().equalsIgnoreCase("Customer Login")) {
				ele.click();
				break;
			}
		}
		
		return new LoginPage(driver);
	}
	
	public void searchFlights() {
		;
	}
	
	
}

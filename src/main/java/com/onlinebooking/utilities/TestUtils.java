/**
 * 
 */
package com.onlinebooking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Santosh Sharma
 *
 */
public class TestUtils {

	public static String captureScreen(WebDriver driver, String filename) {

		String dateTime = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String imgFileName = filename + "_" + dateTime + ".png";

		TakesScreenshot tscr = (TakesScreenshot) driver;
		File imgSource = tscr.getScreenshotAs(OutputType.FILE);
		String imgDestination = System.getProperty("user.dir") + "/screenshots/" + imgFileName;

		try {

			FileUtils.copyFile(imgSource, new File(imgDestination));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// path for jenkins
		String imgPathJenkins = "http://localhost:8080/job/online-booking-maven-project/ws/screenshots/" + imgFileName;

		// return imgDestination;
		
		return imgPathJenkins;
	}

}

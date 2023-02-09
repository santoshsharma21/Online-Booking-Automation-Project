/**
 * 
 */
package com.onlinebooking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

/**
 * @author Santosh Sharma
 *
 */
public class ReportingClass {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void startReport() throws IOException {
		
		String dateTime = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String reportName = "Test-Report_" + dateTime + ".html"; 
		
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentreports/" + reportName);
		spark.loadJSONConfig(new File(System.getProperty("user.dir") + "/spark-config.json"));
		spark.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.AUTHOR
                ,ViewName.DEVICE, ViewName.EXCEPTION}).apply();
		
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Project Name", "Online Ticketing Automation Project");
		extent.setSystemInfo("App URL", ReadConfig.prop.getProperty("baseurl"));
		extent.setSystemInfo("Windows version", System.getProperty("os.name"));
		extent.setSystemInfo("Java version", System.getProperty("java.version"));
		
	}
	
	public static void endReport() {
		extent.flush();
	}

}

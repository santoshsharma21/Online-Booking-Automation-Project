/**
 * 
 */
package com.onlinebooking.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.onlinebooking.base.BaseClass;

/**
 * @author Santosh Sharma
 *
 */
public class ListenerClass extends ReportingClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getName());
		test.assignAuthor("santosh").assignDevice("chrome");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Passed", ExtentColor.GREEN));
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			try {
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Failed", ExtentColor.RED));
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Failed", ExtentColor.RED));

				String imagePath = TestUtils.captureScreen(BaseClass.driver, result.getName());
				test.fail("Screenshot is attached" , MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Skiped", ExtentColor.ORANGE));
		}

	}

}

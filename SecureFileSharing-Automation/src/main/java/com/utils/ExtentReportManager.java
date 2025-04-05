package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	 private static ExtentReports extent;
	    private static ExtentTest test;

	    public static ExtentReports getReportInstance() {
	        if (extent == null) {
	            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
	            extent = new ExtentReports();
	            extent.attachReporter(sparkReporter);
	        }
	        return extent;
	    }

	    public static ExtentTest createTest(String testName) {
	        test = extent.createTest(testName);
	        return test;
	    }

}

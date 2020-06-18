package com.weather.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.weather.basepage.BasePage;

public class MainUtilities extends BasePage{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	
	public static void takeScreenshot() throws IOException
	{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currDir +"/screenshots/" +System.currentTimeMillis() +".png"));

	}
	
}

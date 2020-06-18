package com.weather.homepagetests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.weather.basepage.BasePage;
import com.weather.pages.CovidPage;
import com.weather.pages.HomePage;

public class CovidPageTests extends BasePage{

	CovidPage covidPage;
	HomePage homePage;
	
	public CovidPageTests() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		BasePage.init();
		homePage = new HomePage();
		covidPage = new CovidPage();
	}
	
	@Test
	public void validateCovidPageHeader() throws InterruptedException
	{
		homePage.clickCovidIcon();
		Assert.assertEquals(covidPage.getTextofCovidPageHeader(), "CORONAVIRUS (COVID-19)");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

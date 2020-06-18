package com.weather.homepagetests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.weather.basepage.BasePage;
import com.weather.pages.CovidPage;
import com.weather.pages.HomePage;
import com.weather.util.DataProviderUtilities;

public class HomePageTests extends BasePage{
	
	HomePage homePage;
	CovidPage covidPage;
	
	@DataProvider
	public Object[][] getLocationData()
	{
		Object data[][] = DataProviderUtilities.getCityNamesFromExcel("Locations");
		return data;
	}
	
	
	public HomePageTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		init();
		homePage = new HomePage();
	}
	
	
	@Test
	public void validatePresenceOfCovidIcon()
	{	
		Assert.assertEquals(homePage.validateCovidIconDisplay(),true);
	}
	
	@Test
	public void verifyClickingCovid19icon() {
		homePage.clickCovidIcon();
	}
		
	@Test()
	public void verifyClickingMonsoonLink()	{
		homePage.clickHamburgerIcon();
		homePage.clickMonsoonLink();
	}
	
	@Test(dataProvider="getLocationData")
	public void validateSearchCities(String cityName)
	{
		homePage.searchCityByName(cityName);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

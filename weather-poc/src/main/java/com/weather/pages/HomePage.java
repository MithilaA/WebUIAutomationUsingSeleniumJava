package com.weather.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.weather.basepage.BasePage;

public class HomePage extends BasePage{	
	//Object repository
	@FindBy(xpath="//input[contains(@aria-label,'Search')]")
	WebElement searchBar;
	
	@FindBy(xpath="//span[contains(@class,'locationName')]")
	WebElement currentLocationName;
	
	@FindBy(xpath="//span[contains(text(),'COVID')]")
	WebElement covidIcon;
	
	@FindBy(xpath="//button[@data-testid='hamburgerMenu']")
	WebElement hamburgerIcon;
	
	@FindBy(xpath="//a[text()='Monsoon']")
	WebElement monsoonLink;
	
	@FindBy(xpath = "//button[@id='LocationSearch_listbox-0']")
	WebElement firstLocationInSearchResults;
	
	@FindBy(xpath = "//h1[@class='h4 today_nowcard-location']")
	WebElement nowCardLocationNameOnLocationSearch;
	
	@FindBy(xpath = "//div[contains(@class,'today_nowcard-main')]")
	WebElement nowCardOnLocationSearch;

	//Initialization of page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	String firstLocationNametext;
	
	public boolean validateCovidIconDisplay()
	{
		return covidIcon.isDisplayed();
	}
	
	public CovidPage clickCovidIcon()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(covidIcon));
		covidIcon.click();
		return new CovidPage();
	}
	
	public void enterTextInSearchBar()
	{
		searchBar.sendKeys("New york");
	}
	
	public void clickHamburgerIcon()
	{	
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(hamburgerIcon));
		hamburgerIcon.click();
	}
	
	public MonsoonPage clickMonsoonLink()
	{
	
		Actions action = new Actions(driver);
		action.moveToElement(monsoonLink).build().perform();
		monsoonLink.click();
		return new MonsoonPage();
	}
	
	public void searchCityByName(String cityName)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.elementToBeClickable(searchBar));
		searchBar.click();
		searchBar.sendKeys(cityName);
		firstLocationInSearchResults.click();

	}
	

	
}
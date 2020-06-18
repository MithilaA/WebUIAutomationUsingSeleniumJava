package com.weather.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.weather.basepage.BasePage;

public class CovidPage extends BasePage{
	
	//Object repository
	@FindBy(xpath="//h1[text() = \"CORONAVIRUS (COVID-19)\"]")
	WebElement covidPageHeader;
	
	//initialise page objects
	
	public CovidPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String getTextofCovidPageHeader()
	{
		return covidPageHeader.getText();
	}
}

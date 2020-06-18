package com.weather.basepage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.weather.util.MainUtilities;
import com.weather.util.WebEventListenerUtility;

public class BasePage {

	public static WebDriver driver = null;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListenerUtility eventListner;
	
	public BasePage()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\mithilaa\\eclipse-workspace\\myworkspace\\weather-poc\\src\\main\\java\\com\\weather\\config\\environment.properties");
			prop.load(ip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void init()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\mithilaa\\eclipse-workspace\\myworkspace\\weather-poc\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\mithilaa\\eclipse-workspace\\myworkspace\\weather-poc\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListner = new WebEventListenerUtility();
		e_driver.register(eventListner);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(MainUtilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(MainUtilities.IMPLICIT_WAIT, TimeUnit.SECONDS);	
		
		driver.get(prop.getProperty("url"));
	}
	
	
}

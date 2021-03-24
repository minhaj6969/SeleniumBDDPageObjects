package com.testautomation.Stepdef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.testautomation.PageObject.YoutubeChannelPage;
import com.testautomation.PageObject.YoutubeResultPage;
import com.testautomation.PageObject.YoutubeSearchPage;
import com.testautomation.Utility.BrowserUtility;
import com.testautomation.Utility.PropertiesFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YoutubeChannelValidationsStepDef {
	
	PropertiesFileReader obj= new PropertiesFileReader();
	
	private WebDriver driver;
	
	
	@Given("^Open Chrome browser with URL$")
	public void open_Chrome_browser_with_URL() throws Throwable {
		
		Properties properties = obj.getProperty(); 
		
		driver = BrowserUtility.OpenBrowser(driver,  properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
	    
	    
	}

	@When("^Search channel name$")
	public void search_channel_name() throws Throwable {
		
		new YoutubeSearchPage(driver).NavigateToResultPage();
	    
	    
	}

	@When("^Click on channel name$")
	public void click_on_channel_name() throws Throwable {
		
		new YoutubeResultPage(driver).NavigateToChannelName();
	    
	    
	}

	@Then("^Validate channel name$")
	public void validate_channel_name() throws Throwable {
		
		String ExpectedChannelName="Maher Zain - YouTube";
		String ActualChannelName=new YoutubeChannelPage(driver).getTitle();
		Assert.assertEquals(ActualChannelName, ExpectedChannelName, "Channel Name Are not Match");
	    driver.quit();
	}

}

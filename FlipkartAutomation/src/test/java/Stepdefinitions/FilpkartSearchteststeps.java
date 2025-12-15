package Stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Baseclass.libarrayclass;
import Pages.FlipkartSearchpage;
import Utilities.Reusablefunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilpkartSearchteststeps extends libarrayclass {
	
	Reusablefunctions re;
    FlipkartSearchpage search;
    private static final Logger logger = LogManager.getLogger(libarrayclass.class);
   
	@Given("To launch the browser and enter url")
	public void to_launch_the_browser_and_enter_url() {
		    
	        
	        logger.info("Application Launched");
	        re = new Reusablefunctions(driver);
	        search = new FlipkartSearchpage(driver);
	        
		
	}

	@When("Enter text in the Search field")
	public void enter_text_in_the_search_field() {
		search.search("Mobiles");
		logger.info("Searched Mobiles");
		search.clicksearch();
		logger.info("Clicked Search");
	   
	}
	@Then("Search result should get displayed")
	public void search_result_should_get_displayed() {
	    re.getTitle();
	    logger.info("Naviagted to result page");
	}

	@Then("Take screenshot and close browser")
	public void take_screenshot_and_close_browser() throws IOException {
	   re.takescreenshot("src/test/resources/screenshot/flipkartsearch.png");
	   logger.info("Took screenshot");
	   
	   logger.info("Closed Browser");
	}

}

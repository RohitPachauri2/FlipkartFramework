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

public class searchstepswithmultiplevalues extends libarrayclass {
	Reusablefunctions re;
    FlipkartSearchpage search;
    private static final Logger logger = LogManager.getLogger(libarrayclass.class);
	
	@Given("Launch the browser and enter url")
	public void launch_the_browser_and_enter_url() {
		
	        logger.info("Application Launched");
	        re = new Reusablefunctions(driver);
	        search = new FlipkartSearchpage(driver);
	}  
		

	@When("Enter {string} in the Search field")
	public void enter_in_the_search_field(String text) {
		search.search(text);
		logger.info("Searched " + text);
		search.clicksearch();
		logger.info("Clicked Search");
	   
	}

	@Then("Search result should be displayed")
	public void search_result_should_be_displayed() {
		re.getTitle();
	    logger.info("Naviagted to result page");
	}

	@Then("Verify the reult")
	public void verify_the_reult() {
		logger.info("Verified Result e");
	}

	@Then("Take  the screenshot and close  the browser")
	public void take_the_screenshot_and_close_the_browser() throws IOException {
		 re.takescreenshot("src/test/resources/screenshot/flipkartsearch.png");
		   logger.info("Took screenshot");
		  
		   logger.info("Closed Browser");

	}
}

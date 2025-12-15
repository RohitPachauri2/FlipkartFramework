package Stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Baseclass.libarrayclass;
import Pages.FlipkartSearchpage;
import Utilities.Reusablefunctions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Searchwithdatatable extends libarrayclass {
	
	Reusablefunctions re;
    FlipkartSearchpage search;
    private static final Logger logger = LogManager.getLogger(libarrayclass.class);
	@Given("To launch  browser and enter url")
	public void to_launch_browser_and_enter_url() {
		 logger.info("Application Launched");
	        re = new Reusablefunctions(driver);
	        search = new FlipkartSearchpage(driver);
	        
	}

	@When("Enter the following text in the Search field")
	public void enter_the_following_text_in_the_search_field(io.cucumber.datatable.DataTable dataTable) {
		List<String> searchItems = dataTable.asList(String.class);

        for (String text : searchItems) {
            search.search(text);      // enters text in search box
            search.clicksearch();     // simulates pressing ENTER or clicking icon
            
             // wait for results to appear
            logger.info("Searched for: " + text);

            // Navigate back or refresh to prepare for next search
            driver.navigate().back();  // or driver.get("https://www.flipkart.com");
               // wait for the search box to reappear
        }
	}

	@Then("Search results should get displayed for each product")
	public void search_results_should_get_displayed_for_each_product() {
		 re.getTitle();
		    logger.info("Naviagted to result page");
	}

	@Then("Take screenshot  close browser")
	public void take_screenshot_close_browser() throws IOException {
		re.takescreenshot("src/test/resources/screenshot/flipkartsearch.png");
		   logger.info("Took screenshot");  
	}

}

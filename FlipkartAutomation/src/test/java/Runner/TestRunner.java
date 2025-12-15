package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;





@RunWith(Cucumber.class)
@CucumberOptions(
	    features = {"src/test/resources/Features/flipkart.feature"},      // Path to feature files
	    glue = {"Stepdefinitions", "Hooks"}, 
	    		tags = "@tc003",
	    		plugin = {
	    		        "pretty",
	    		        "html:target/cucumber-html-report",
	    		        "json:target/cucumber.json",
	    		        "rerun:target/rerun.txt",
	    		        "TestRunner.CucumberExtentReportPlugin"
	    		       	    		    },
	    				dryRun = false,
	    		
	    		 monochrome = false
	    
	   
	)
	public class TestRunner  {
	    // Empty class - the annotations drive the configuration
}
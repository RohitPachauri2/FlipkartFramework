package Runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/Features/flipkart.feature",  // Path to feature files
	    glue = "Stepdefinitions",                 // Path to step definitions
	    plugin = {"pretty", "html:target/cucumber-reports.html"}
	)
	public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {

	    

	    
	}

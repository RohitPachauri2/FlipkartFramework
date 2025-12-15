package Testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Baseclass.libarrayclass;
import Pages.FlipkartResultPage;
import Pages.FlipkartSearchpage;
import Utilities.Reusablefunctions;


public class FlipkartSearchtest extends libarrayclass {
	Reusablefunctions re;
    FlipkartSearchpage search;
    private static final Logger logger = LogManager.getLogger(libarrayclass.class);
   

   

    @BeforeTest
    public void openapp() {
    	
    	
        initializeBrowser();
        openApplication();
        logger.info("Application Launched");
        re = new Reusablefunctions(driver);
        search = new FlipkartSearchpage(driver);
       
    }

    @Test(priority =1)
    public void searchmobile() throws IOException {
        search.search("Mobiles");
        
        search.clicksearch(); 
        logger.info("Searched Mobiles");
        
        re.takescreenshot("src/test/resources/screenshot/flipkartsearch.png");
        logger.info("Took screenshot");
    }
    
    

    @AfterTest
    public void closeapp() throws IOException {
        
        re.getTitle();
        closeBrowser();
        
    }
}

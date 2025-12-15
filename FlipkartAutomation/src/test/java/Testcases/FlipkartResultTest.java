package Testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Baseclass.libarrayclass;
import Pages.FlipkartResultPage;
import Pages.FlipkartSearchpage;
import Utilities.Reusablefunctions;

public class FlipkartResultTest extends libarrayclass{

	Reusablefunctions re;
    FlipkartSearchpage search;
    FlipkartResultPage result;
    @BeforeTest
    public void openapp() {
        initializeBrowser();
        openApplication();
        re = new Reusablefunctions(driver);
        search = new FlipkartSearchpage(driver);
        result = new FlipkartResultPage(driver);
    }


    @Test(priority =1)
    public void searchmobile() throws IOException {
        search.search("Mobiles");
        
        search.clicksearch(); 
        
        re.takescreenshot("src/test/resources/screenshot/flipkartsearch.png");
    }
    
    @Test(priority=2)
    
    public void resultclick() throws IOException {
    	result.clickresult();
    	re.takescreenshot("src/test/resources/screenshot/result.png");
    }

    @AfterTest
    public void closeapp() throws IOException {
        
        re.getTitle();
        closeBrowser();
        
    }
}

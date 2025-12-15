package Stepdefinitions;

import Baseclass.libarrayclass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends libarrayclass{
	@Before
    
	 public void setUp() throws Exception {
		initializeBrowser();
		openApplication();
	    }
 

   @After
   public void tearDown() {
	   closeBrowser();
   }
}

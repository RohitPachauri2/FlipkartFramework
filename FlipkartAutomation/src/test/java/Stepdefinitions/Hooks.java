package Stepdefinitions;

import io.cucumber.java.Scenario;

import Baseclass.libarrayclass;
import Utilities.Reusablefunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends libarrayclass {
	public static Scenario scenario;
	Reusablefunctions rf;

	@Before

	public void setUp(Scenario CucumberScenario) throws Exception {
		scenario = CucumberScenario;
		initializeBrowser();
		openApplication();
	}

	@After
	public void tearDown(Scenario scenario) {
		rf = new Reusablefunctions(driver);
		rf.attachscreenshotwithextentreports(scenario);
		closeBrowser();

	}
}

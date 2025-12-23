package Stepdefinitions;

import java.io.IOException;

import Baseclass.libarrayclass;
import Pages.FlipkartSearchpage;
import Utilities.Reusablefunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Excelreadfileteststepdefinition extends libarrayclass{

	FlipkartSearchpage sp;
	Reusablefunctions rf;
	@Given("enter search value in search box")
	public void enter_search_value_in_search_box() throws IOException, InterruptedException {
		sp=new FlipkartSearchpage(driver);
		sp.searchwithexcel();
	}

	@When("click search ico or enter")
	public void click_search_ico_or_enter() throws IOException {
		rf=new Reusablefunctions(driver);
		rf.takescreenshot("C:\\Users\\PC\\git\\Flipkart\\FlipkartAutomation\\src\\test\\resources\\screenshot\\excel.png");
	}

	@Then("shows the respective results")
	public void shows_the_respective_results() {
		rf.getTitle();

	}

}

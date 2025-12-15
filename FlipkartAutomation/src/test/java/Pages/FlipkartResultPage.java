package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Reusablefunctions;

public class FlipkartResultPage {
	
	private WebDriver driver;
	Reusablefunctions re;
	
	
    @FindBy(xpath = "//div[contains(text(),'CMF by Nothing Phone 2 Pro')]")
    WebElement firstsearch;
	
    public FlipkartResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickresult() {
    	re = new Reusablefunctions(driver);
    	re.waitforclickable(firstsearch);
    	firstsearch.click();
    }
    
    
}

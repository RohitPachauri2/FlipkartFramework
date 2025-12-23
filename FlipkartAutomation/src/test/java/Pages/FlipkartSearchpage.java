package Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Stepdefinitions.Excelfleread;
import Utilities.Reusablefunctions;

public class FlipkartSearchpage {

	
	private WebDriver driver;
	Reusablefunctions re;
	
	
    @FindBy(css = "input[class='lNPl8b']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchbutton;

    @FindBy(css = "button._2KpZ6l._2doB4z")
    WebElement closeLoginPopup;
    
    @FindBy(css="#container > div > div.rX6Fng > div")
    WebElement homepage;
    
    
    public FlipkartSearchpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        re = new Reusablefunctions(driver);
    }

    public void closePopupIfPresent() {
        try {
            if (closeLoginPopup.isDisplayed()) {
                closeLoginPopup.click();
            }
        } catch (NoSuchElementException ignored) {
        }
    }

    public void search(String text) {
    	
        closePopupIfPresent();
        searchBox.sendKeys(text);
    }

    public void clicksearch() {
        try {
        	
        	searchBox.sendKeys(Keys.ENTER);
            
        } catch (NoSuchElementException e) {
            System.out.println("Search button not found.");
        } catch (ElementNotInteractableException e) {
            System.out.println("Search button found but not interactable.");
        }
    }
  
    public void searchwithexcel() throws IOException, InterruptedException {
    	Excelfleread ef=new Excelfleread();
    	for(int i=1;i<6;i++) {
    		re.enterText(searchBox, ef.Excelfleread("Sheet1", i, 0));
    		searchBox.sendKeys(Keys.ENTER);
    		Thread.sleep(2000);
    		if(homepage.isDisplayed()) {
    			ef.excelwrite("Sheet1", i, 1, "passed");
    		}
    		else {
    			ef.excelwrite("Sheet1", i, 1, "failed");
    		}
    		re.navigateback();
    	}
    }
}

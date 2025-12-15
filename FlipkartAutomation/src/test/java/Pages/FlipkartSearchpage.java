package Pages;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Reusablefunctions;

public class FlipkartSearchpage {

	
	private WebDriver driver;
	Reusablefunctions re;
	
	
    @FindBy(xpath = "//input[@name='q' and @type='text']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchbutton;

    @FindBy(css = "button._2KpZ6l._2doB4z")
    WebElement closeLoginPopup;

    public FlipkartSearchpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        	re = new Reusablefunctions(driver);
        	re.waitforclickable(searchbutton);
            searchbutton.click();
            
        } catch (NoSuchElementException e) {
            System.out.println("Search button not found.");
        } catch (ElementNotInteractableException e) {
            System.out.println("Search button found but not interactable.");
        }
    }
  
}

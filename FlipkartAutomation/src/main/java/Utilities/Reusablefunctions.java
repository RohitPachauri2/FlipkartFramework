package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusablefunctions {

	WebDriver driver;

    public Reusablefunctions(WebDriver driver) {
        this.driver = driver;
    }
// wait for visiblity
    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void waitforclickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    
   //click the element
    public void clickElement(WebElement element) {
        waitForElementToBeVisible(element);
        element.click();
    }
    
    public void waitForSearchResults() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._1YokD2 ._1AtVbE")) // Adjust based on result section
        );
    }

    public void waitForSearchPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
            ExpectedConditions.visibilityOfElementLocated(By.name("q"))
        );
    
    }
    //enter text
    public void enterText(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }
    
    public void takescreenshot(String path) throws IOException {
    	TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        // Now copy the screenshot to desired location using copyFile method
        FileUtils.copyFile(src, new File(path));
    	
    }
    
    
    
    public void scrolldown(String element) throws InterruptedException {

		   JavascriptExecutor js =(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(5000);
		   WebElement ele = driver.findElement(By.xpath(element));
		   js.executeScript("arguments[0].click();", ele);
		   
    	
    }
    
    
    public void windowhandling(String element) {
    	
    	driver.findElement(By.xpath(element)).click();
		   String mainWindow = driver.getWindowHandle();
		   System.out.println(mainWindow);
		   Set<String> allWindows = driver.getWindowHandles();
		  
		   for (String window : allWindows) {
			   
			   driver.switchTo().window(window);
			   
            System.out.println("Switched to new window: " + driver.getTitle());
			   
		   }
		   driver.switchTo().window(mainWindow);
    	
    }
    
    public void alerthandling(String value) throws InterruptedException {
    	
    	 Alert alert = driver.switchTo().alert();
		   Thread.sleep(4000);
		   alert.sendKeys(value);
		   alert.accept();
    	
    }
    public void getTitle() {
        System.out.println( driver.getTitle());;
    }
}

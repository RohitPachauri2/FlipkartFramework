package Baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.nio.file.Files;
import java.nio.file.Paths; 
import io.github.bonigarcia.wdm.WebDriverManager;

public class libarrayclass {

    protected static WebDriver driver;
    protected static Properties config = new Properties();
    // Make logger static so it can be used in static methods
    protected static final Logger logger = LogManager.getLogger(libarrayclass.class);

    // Load config.properties
    public static void loadConfig() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/Configuration.Properties/Config.property")) {
            config.load(fis);
            logger.info("Read Property file successfully");
        } catch (IOException e) {
            logger.error("Failed to load configuration: " + e.getMessage(), e);
        }
    }

    // Initialize browser based on config
    public static void initializeBrowser() {
        loadConfig();
        String browser = config.getProperty("browser", "chrome");
        logger.info("Launching browser: " + browser);
        
        int implicitWait = Integer.parseInt(config.getProperty("implicitWait", "10"));

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            try {
                String tempProfileDir = Files.createTempDirectory("chrome-profile").toString();
                options.addArguments("--user-data-dir=" + tempProfileDir);
            } catch (IOException e) {
                logger.warn("Could not create temp Chrome profile dir: " + e.getMessage());
            }

            driver = new ChromeDriver(options);
            logger.info("Chrome browser launched");
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            logger.info("Firefox browser launched");
        } else {
            logger.error("Unsupported browser specified in config: " + browser);
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        logger.info("Browser maximized and implicit wait set to " + implicitWait + " seconds");
    }

    // Open application using config URL
    public static void openApplication() {
        String url = config.getProperty("url");
        if (url == null || url.isEmpty()) {
            logger.error("URL not specified in config file");
            throw new RuntimeException("URL not specified in config file");
        }
        driver.get(url);
        logger.info("Navigated to URL: " + url);
    }

    // Close the browser
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            logger.info("Closed Browser");
        }
    }
}

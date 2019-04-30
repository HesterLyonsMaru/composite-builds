package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseDefinitions {

    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) throws Exception {
        System.out.println(scenario);
        driver = getChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Browser is " + System.getProperty("browser"));
    }


    // local drivers
    private WebDriver getChromeDriver() {
        String path = getClass()
                .getClassLoader()
                .getResource("chromedriver.exe") // Change this to just "chromedriver" if you're on a unix machine, and get chromedriver from http://chromedriver.chromium.org/
                .getPath();
        System.setProperty("webdriver.chrome.driver", path);
        return new ChromeDriver();
    }


    /**
     * Fairly self explanatory method. This will run after every test, so if there's anything you want to do (like
     * collecting screenshots, removing data from the DB etc.) then this is the place.
     */
    @After
    public void teardown() {
        driver.close();
        try {
            driver.quit();
        }
        catch(Exception e) {
            System.out.println("Caught driver error on quit.");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
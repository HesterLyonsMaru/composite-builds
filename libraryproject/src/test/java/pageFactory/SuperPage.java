package pageFactory;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class SuperPage {

    public WebDriver driver;

    public SuperPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



}
package pageFactory.examplePages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactory.SuperPage;

public class GoogleSearchHomepage extends SuperPage {

    @FindBy(css = ".gsfi[name='q']")
    public WebElement searchTextField;

    @FindBy(css = "[value='Google Search'][name='btnK']")
    public WebElement searchButton;

    public GoogleSearchHomepage(WebDriver driver) {
        super(driver);
    }

    public void typeInSearchField(String text) {
        searchTextField.sendKeys(text);
    }

    public pageFactory.examplePages.GoogleSearchResultsPage clickSearchButton() {
        searchTextField.sendKeys(Keys.RETURN);
        return new pageFactory.examplePages.GoogleSearchResultsPage(driver);
    }

    public GoogleSearchHomepage visit() {
        driver.get("https://www.google.co.uk/");
        return new GoogleSearchHomepage(driver);
    }


}

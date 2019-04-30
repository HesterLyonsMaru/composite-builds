package pageFactory.examplePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactory.SuperPage;

import java.util.List;

public class GoogleSearchResultsPage extends SuperPage {

    @FindBy(className = "r:first-of-type")
    public List<WebElement> searchTextField;

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfResult(Integer resultNumberToGet) {
        // Get the search results panel that contains the link for each result.
        WebElement resultsPanel = driver.findElement(By.id("search"));

        // Get all the links only contained within the search result panel.
        searchTextField = resultsPanel.findElements(By.xpath(".//a"));

        if (searchTextField.size() >   0) {
            return searchTextField.get(resultNumberToGet - 1).getText(); // 0 based array
        }
        else
        {
            System.out.println("Cannot find first Google result.");
            return "";
        }
    }

}

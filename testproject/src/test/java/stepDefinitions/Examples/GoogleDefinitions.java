package stepDefinitions.Examples;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import libraryproject.pageFactory.examplePages.GoogleSearchHomepage;
import libraryproject.pageFactory.examplePages.GoogleSearchResultsPage;
import stepDefinitions.BaseDefinitions;

import static org.hamcrest.Matchers.containsString;

public class GoogleDefinitions {

    private BaseDefinitions baseDefinitions;
    private WebDriver driver;

    public GoogleDefinitions (BaseDefinitions baseDefinitions) {
        this.baseDefinitions = baseDefinitions;
        this.driver = baseDefinitions.getDriver();
    }

    @Given("^I visit the Google search page$")
    public void iVisitTheGoogleSearchPage() {
        GoogleSearchHomepage googleSearchHomepage = new GoogleSearchHomepage(driver);
        googleSearchHomepage.visit();
    }

    @When("^I enter the text \"([^\"]*)\" into the search box$")
    public void iEnterTheTextIntoTheSearchBox(String textToEnter) {
        GoogleSearchHomepage googleSearchHomepage = new GoogleSearchHomepage(driver);
        googleSearchHomepage.typeInSearchField(textToEnter);
    }

    @And("^I click the search button$")
    public void iClickTheSearchButton() {
        GoogleSearchHomepage googleSearchHomepage = new GoogleSearchHomepage(driver);
        googleSearchHomepage.clickSearchButton();
    }

    @Then("^I should see the top result mentioning cats$")
    public void iShouldSeeTheTopResultMentioningCats() {
        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage(driver);
        assertThat(googleSearchResultsPage.getTextOfResult(1).toLowerCase(), containsString("cat"));
    }
}

package stepdefinitions;

import Page.GeneratePage;
import Page.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import manager.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    GeneratePage generatePage;
    PageObjectManager pageObjectManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageObjectManager = new PageObjectManager(driver);
    }

    @After
    public void tearDown() {driver.close();}

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageObjectManager.getHomePage();
        homePage.openHomePage(url);
    }


    @And("User сhooses a city {string}")
    public void userChoosesCity(final String keyword) {
        homePage.searchByKeyword(keyword);
    }

    @And("User сhooses a date")
    public void userChoosesADate() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickOnChooseDate();
        for (int i =0; i <=2;i++) homePage.clickOnArrow();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickOnCheckInDay();
        homePage.clickOnCheckOutDay();
    }


    @And("User clicks search button")
    public void ClicksSearchButton()  {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickOnSearchButton();
    }


    @Then("User checks that the text of the first page, which contains the city and the date")
    public void userChecksFirstPageContent() {
        generatePage = pageObjectManager.getGeneatePage();
        generatePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(generatePage.getCheckInDate().contains("Thursday 1 December 2022"));
        Assert.assertTrue(generatePage.getCheckOutDate().contains("Friday 30 December 2022"));
        generatePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        generatePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        Assert.assertEquals(26, generatePage.getSearchResultsPageList().size());
    }


    @And("User chooses three adults")
    public void userChoosesThreeAdults() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickOnGuestsCount();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickOnIncreaseNumberOfAdult();


    }

    @Then("User checks that the properties found equal to {string}")
    public void userChecksThatThePropertiesFoundEqualToAmout(final String amount) {
        generatePage = pageObjectManager.getGeneatePage();
        generatePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(generatePage.getAmountProperties().contains(amount));

    }
}


package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    By searchButton = By.xpath("//button[contains(@class, 'sb-searchbox__button')]");

    By searchCity = By.xpath("//*[@id = \"ss\"]");

    By chooseDateField = By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span");

    By clickCheckInDay = By.xpath("//*[@aria-label = \"1 December 2022\"]");

    By clickCheckOutDay = By.xpath("//*[@aria-label = \"30 December 2022\"]");

    By clickNextMonth = By.cssSelector("#frm > div.xp__fieldset.js--sb-fieldset.accommodation " +
            "> div.xp__dates.xp__group > div.xp-calendar > div > div " +
            "> div.bui-calendar__control.bui-calendar__control--next > svg");

    By clickGuestsCount = By.xpath("//span[contains(@class, 'xp__guests__count')]");

    By clickIncreaseNumberOfAdults = By.xpath("//button[contains(@aria-label, 'Increase number of Adults')]");




    public void openHomePage(String url) {
        driver.get(url);
    }


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void searchByKeyword (final String keyword) {
       driver.findElement(searchCity).sendKeys(keyword);
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickOnChooseDate() {
        driver.findElement(chooseDateField).click();
    }

    public void clickOnArrow() {
        driver.findElement(clickNextMonth).click();
    }

    public void clickOnCheckInDay() {
        driver.findElement(clickCheckInDay).click();
    }

    public void clickOnCheckOutDay() {
        driver.findElement(clickCheckOutDay).click();
    }

    public void clickOnGuestsCount() {
        driver.findElement(clickGuestsCount).click();
    }

    public void clickOnIncreaseNumberOfAdult() {
        driver.findElement(clickIncreaseNumberOfAdults).click();
    }



}


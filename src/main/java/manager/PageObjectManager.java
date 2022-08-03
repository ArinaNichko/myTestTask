package manager;

import Page.GeneratePage;
import Page.HomePage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public GeneratePage getGeneatePage() {
        return new GeneratePage(driver);
    }

}

package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class GeneratePage extends BasePage {

    By pageList = By.xpath("//span[contains(text(), 'New York') and  @class= 'f4bd0794db b4273d69aa']");

    By containsCheckInDate = By.xpath("//*[@id=\"left_col_wrapper\"]/div[1]/div/div/form/div/div[3]/div[2]/button");

    By containsCheckOutDate = By.xpath("//*[@id=\"left_col_wrapper\"]/div[1]/div/div/form/div/div[3]/div[4]/button");

    By amountProperties = By.xpath("//h1[contains(text(),'Paris: 5,268 properties found')]");



    public GeneratePage(WebDriver driver) {
        super(driver);
    }

    public String getCheckInDate () {
         return driver.findElement(containsCheckInDate).getText();
    }

    public String getCheckOutDate () {
        return driver.findElement(containsCheckOutDate).getText();
    }

    public String getAmountProperties () {
        return driver.findElement(amountProperties).getText();
    }

    public List<WebElement> getSearchResultsPageList() {
        return driver.findElements(pageList);
    }
}
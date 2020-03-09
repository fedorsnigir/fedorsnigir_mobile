package pageObjects.web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertNotNull;

public class YandexPage {

    private AppiumDriver driver;

    private By searchTextField = By.xpath("//input[@type='search']");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By searchResults = By.xpath("//div[@class='serp-item']");

    public YandexPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void open(String sut, WebDriverWait wait) {
        driver.get(sut);
        wait.until(ExpectedConditions.urlToBe(sut + "/"));
    }

    public void search(String string) {
        driver.findElement(searchTextField).sendKeys(string);
        driver.findElement(searchButton).click();
    }

    public void checkNonEmptyResults() {
        List<WebElement> results = driver.findElements(searchResults);
        assertNotNull(results);
    }
}

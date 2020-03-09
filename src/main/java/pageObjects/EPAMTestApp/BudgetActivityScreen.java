package pageObjects.EPAMTestApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class BudgetActivityScreen {

    private AppiumDriver driver;

    private String expectedPageTitle = "BudgetActivity";
    private By title = By.xpath("//*[@resource-id='platkovsky.alexey.epamtestapp:id/action_bar']/*");

    public BudgetActivityScreen(AppiumDriver appiumDriver) {
        driver = appiumDriver;
    }

    public void checkTitle(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        assertEquals(driver.findElement(title).getText(), expectedPageTitle);
    }
}

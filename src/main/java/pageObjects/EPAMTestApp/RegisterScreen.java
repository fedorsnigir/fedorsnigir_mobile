package pageObjects.EPAMTestApp;

import entities.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class RegisterScreen {

    private AppiumDriver driver;

    private By email = By.id("platkovsky.alexey.epamtestapp:id/registration_email");
    private By username = By.id("platkovsky.alexey.epamtestapp:id/registration_username");
    private By password = By.id("platkovsky.alexey.epamtestapp:id/registration_password");
    private By confirmPassword = By.id("platkovsky.alexey.epamtestapp:id/registration_confirm_password");
    private By registerAccountButton = By.id("platkovsky.alexey.epamtestapp:id/register_new_account_button");

    public RegisterScreen(AppiumDriver appiumDriver) {
        driver = appiumDriver;
    }

    public void createNewAccount(User user) {
        driver.findElement(email).sendKeys(user.email);
        driver.findElement(username).sendKeys(user.username);
        driver.findElement(password).sendKeys(user.password);
        driver.findElement(confirmPassword).sendKeys(user.password);
        driver.findElement(registerAccountButton).click();
    }
}

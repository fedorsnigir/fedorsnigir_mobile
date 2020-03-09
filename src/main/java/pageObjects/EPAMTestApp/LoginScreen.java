package pageObjects.EPAMTestApp;

import entities.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginScreen {

    private AppiumDriver driver;

    private String app_package_name = "platkovsky.alexey.epamtestapp:id/";
    private By email = By.id(app_package_name + "login_email");
    private By password = By.id(app_package_name + "login_pwd");
    private By signInButton = By.id(app_package_name + "email_sign_in_button");
    private By registerButton = By.id(app_package_name + "register_button");

    public LoginScreen(AppiumDriver appiumDriver) {
        driver = appiumDriver;
    }

    public void openRegisterScreen() {
        driver.findElement(registerButton).click();
    }

    public void signIn(User user) {
        driver.findElement(email).sendKeys(user.email);
        driver.findElement(password).sendKeys(user.password);
        driver.findElement(signInButton).click();
    }
}

package hooks;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObjects.EPAMTestApp.BudgetActivityScreen;
import pageObjects.EPAMTestApp.LoginScreen;
import pageObjects.EPAMTestApp.RegisterScreen;
import pageObjects.web.YandexPage;
import setup.DriverSetup;

import static enums.PropertiesEnum.NATIVE;
import static enums.PropertiesEnum.WEB;

public class Hooks extends DriverSetup {

    protected YandexPage yandexPage;
    protected LoginScreen loginScreen;
    protected RegisterScreen registerScreen;
    protected BudgetActivityScreen budgetScreen;

    @BeforeSuite(groups = "web")
    public void setWeb() throws Exception {
        System.out.println("Web driver preparation");
        prepareDriver(WEB);

        yandexPage = new YandexPage(getDriver());
        System.out.println("Web driver prepared");
    }

    @BeforeSuite(groups = "native")
    public void setNative() throws Exception {
        System.out.println("Native driver preparation");
        prepareDriver(NATIVE);

        loginScreen = new LoginScreen(getDriver());
        registerScreen = new RegisterScreen(getDriver());
        budgetScreen = new BudgetActivityScreen(getDriver());
        System.out.println("Native driver prepared");
    }

    @AfterSuite(groups = {"web", "native"})
    public void tearDown() throws Exception {
        System.out.println("Driver closure");
        getDriver().quit();
        System.out.println("Driver closed");
    }
}

package homework2.nativetests;

import homework2.entities.User;
import homework2.pageObjects.EPAMTestApp.BudgetActivityScreen;
import homework2.pageObjects.EPAMTestApp.LoginScreen;
import homework2.pageObjects.EPAMTestApp.RegisterScreen;
import homework2.setup.DriverSetup;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static homework2.enums.PropertyOptionsEnum.NATIVE;

@Test(groups = "native")
public class NativeTest extends DriverSetup {

    private LoginScreen loginScreen;
    private RegisterScreen registerScreen;
    private BudgetActivityScreen budgetScreen;

    @BeforeSuite(description = "Prepare driver")
    public void setUp() throws Exception {
        System.out.println("Driver preparation");
        prepareDriver(NATIVE);
        loginScreen = new LoginScreen(getDriver());
        registerScreen = new RegisterScreen(getDriver());
        budgetScreen = new BudgetActivityScreen(getDriver());
        System.out.println("Driver prepared");
    }

    @AfterSuite(description = "Close driver")
    public void tearDown() throws Exception {
        System.out.println("Driver closure");
        getDriver().quit();
        System.out.println("Driver closed");
    }

    @Test(description = "Register and sign in EPAMTestApp.apk")
    public void nativeTest() throws Exception {

        //Step 1: Register a new account
        loginScreen.openRegisterScreen();
        System.out.println("Register Screen open");
        registerScreen.createNewAccount(User.TEST);
        System.out.println("New Account created");

        //Step 2: Sign in
        loginScreen.signIn(User.TEST);
        System.out.println("User signed in");

        //Step 3: Make sure that you are on the BudgetActivity page
        budgetScreen.checkTitle(getWait());

        System.out.println("Native test finished");
    }
}
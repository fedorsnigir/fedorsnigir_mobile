package nativetests;

import entities.User;
import hooks.Hooks;
import org.testng.annotations.Test;

@Test(groups = "native")
public class NativeTest extends Hooks {

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
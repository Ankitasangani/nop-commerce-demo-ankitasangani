package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 1.LoginPageTest
 * Inside LoginPageTest class create following testmethods
 * 1.userShouldNavigateToLoginPageSuccessFully().
 * Click on login link
 * verify that "Welcome, Please Sign In!" message display
 * 2. verifyTheErrorMessageWithInValidCredentials().
 * Click on login link
 *
 * Enter EmailId
 * Enter Password
 * Click on Login Button
 * Verify that the Error message
 * 3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
 * Click on login link
 * Enter EmailId
 * Enter Password
 * Click on Login Button
 * Verify that LogOut link is display
 * 4. verifyThatUserShouldLogOutSuccessFully()
 * Click on login link
 * Enter EmailId
 * Enter Password
 * Click on Login Button
 * Click on LogOut Link
 * Verify that LogIn Link Display
 */
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully(){
       homePage.clickOnLoginLink(); // Click on login link
        // verify that "Welcome, Please Sign In!" message display
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.verifyWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Text didn't match!");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials(){
        homePage.clickOnLoginLink(); // Click on login link
        loginPage.enterEmailId("example123@gmail.com"); // Enter EmailId
        loginPage.enterPassword("example123"); // Enter Password
        loginPage.clickOnLoginButton(); // Click on Login Button
        // Verify that the Error message
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = loginPage.verifyErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage, "Text didn't match!");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        homePage.clickOnLoginLink(); // Click on login link
        loginPage.enterEmailId("khimjidaruwala@gmail.com"); // Enter EmailId
        loginPage.enterPassword("a1b2c3d4e5"); // Enter Password
        loginPage.clickOnLoginButton(); // Click on Login Button
        // Verify that LogOut link is display
        String expectedMessage = "Log out";
        String actualMessage = loginPage.verifyLogOutLink();
        Assert.assertEquals(expectedMessage, actualMessage, "Text didn't match!");

    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully(){
        homePage.clickOnLoginLink(); // Click on login link
        loginPage.enterEmailId("khimjidaruwala@gmail.com"); // Enter EmailId
        loginPage.enterPassword("a1b2c3d4e5"); // Enter Password
        loginPage.clickOnLoginButton(); // Click on Login Button
        loginPage.clickOnLogOutLink(); // Click on LogOut Link
        // Verify that LogIn Link Display
        String expectedMessage = "Log in";
        String actualMessage = homePage.verifyLogInLink();
        Assert.assertEquals(expectedMessage, actualMessage, "Text didn't match!");

    }

}

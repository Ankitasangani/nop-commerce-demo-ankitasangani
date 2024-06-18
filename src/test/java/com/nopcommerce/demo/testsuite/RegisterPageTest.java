package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Inside RegisterPageTest class create following testmethods
 * 1. verifyUserShouldNavigateToRegisterPageSuccessfully()
 * Click on Register Link
 * Verify "Register" text
 * 2.verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandator
 * y()
 * Click on Register Link
 * Click on "REGISTER" button
 * Verify the error message "First name is required."
 * Verify the error message "Last name is required."
 * Verify the error message "Email is required."
 * Verify the error message "Password is required."
 * Verify the error message "Password is required."
 * 2. verifyThatUserShouldCreateAccountSuccessfully()
 * Click on Register Link
 * Select gender "Female"
 * Enter firstname
 * Enter lastname
 * Select day
 * Select month
 * Select year
 * Enter email
 * Enter password
 * Enter Confirm Password
 * Click on "REGISTER" button
 * Verify message "Your registration completed"
 */

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {

    RegisterPage registerPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        registerPage = new RegisterPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnRegisterLink(); // Click on Register Link
        // Verify "Register" text
        String expectedMessage = "Register";
        String actualMessage = registerPage.verifyRegisterText();
        Assert.assertEquals(expectedMessage, actualMessage, "Text didn't match!");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickOnRegisterLink(); // Click on Register Link
        registerPage.clickOnRegisterButton(); // Click on Register Button
        // Verify the error message "First name is required."
        String expectedMessage = "First name is required.";
        String actualMessage = registerPage.verifyErrorFirstName();
        Assert.assertEquals(expectedMessage, actualMessage, "Text didn't match!");
        // Verify the error message "Last name is required."
        String expectedError1 = "Last name is required.";
        String actualError1 = registerPage.verifyErrorLastName();
        Assert.assertEquals(expectedError1, actualError1, "Text didn't match!");

        // Verify the error message "Email is required."
        String expectedError2 = "Email is required.";
        String actualError2 = registerPage.verifyErrorEmail();
        Assert.assertEquals(expectedError2, actualError2, "Text didn't match!");

        //Verify the error message "Password is required."
        String expectedError3 = "Password is required.";
        String actualError3 = registerPage.verifyErrorPassword();
        Assert.assertEquals(expectedError3, actualError3, "Text didn't match!");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickOnRegisterLink(); // Click on Register Link
        registerPage.selectGender(); // Select gender "Female"
        registerPage.enterFirstName("Ankita"); // Enter firstname
        registerPage.enterLastName("Sangi"); // Enter lastname
        registerPage.selectDay("5"); // Select day
        registerPage.selectMonth("4"); // Select month
        registerPage.selectYear("1995"); // Select year
        registerPage.enterEmailId(); // Enter email
        registerPage.enterPassword("Ankita@1995"); // Enter password
        registerPage.enterConfirmPassword("Ankita@1995"); // Enter Confirm Password
        registerPage.clickOnRegisterButton(); // Click on "REGISTER" button

        //Verify message "Your registration completed"
        String expectedMessage = "Your registration completed";
        String actualMessage = registerPage.verifyRegistrationMessage();
        Assert.assertEquals(expectedMessage, actualMessage, "Text didn't match!");

    }

}

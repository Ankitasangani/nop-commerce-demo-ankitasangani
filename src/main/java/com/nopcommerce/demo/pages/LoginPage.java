package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * 1.LoginPage - Email, password, Login Button and "Welcome, Please Sign In!" text Locators and
 * create appropriate methods for it.
 */
public class LoginPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement text;

    @CacheLookup
    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]")
    WebElement error;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logout;


    public String verifyWelcomeText() {
        String message = getTextFromElement(text);
        Reporter.log("Add User" + text.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }

    public void enterEmailId(String emailId) {
        sendTextToElement(emailField, emailId);
        Reporter.log("Email" + emailField.toString());
        CustomListeners.test.log(Status.PASS, "Enter email id" + emailId);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        Reporter.log("Password" + passwordField.toString());
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        Reporter.log("Login button" + loginButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }

    public String verifyErrorMessage() {
        String message = getTextFromElement(error);
        Reporter.log("Error" + error.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }

    public String verifyLogOutLink() {
        String message = getTextFromElement(logout);
        Reporter.log("Log Out" + logout.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }

    public void clickOnLogOutLink() {
        clickOnElement(logout);
        Reporter.log("Login button" + logout.toString());
        CustomListeners.test.log(Status.PASS, "Click on logOut link");
    }

}

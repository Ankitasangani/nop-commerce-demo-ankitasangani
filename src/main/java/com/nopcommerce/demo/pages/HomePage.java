package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * 2.HomePage - All Menu (Seven menu), LoginLink, registerLink, nopcommerce logo, My account
 * link and LogOut link locators and create appropriate methods for it.
 */
public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registerLink;

    public void clickOnLoginLink() {
        clickOnElement(loginLink);
        Reporter.log("Log in" + loginLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on login link");
    }

    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
        Reporter.log("Register Link" + registerLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on Register Link");
    }

    public String verifyLogInLink() {
        String message = getTextFromElement(loginLink);
        Reporter.log("Log In" + loginLink.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }
}

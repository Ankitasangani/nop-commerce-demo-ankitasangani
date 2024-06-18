package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * 6.RegisterPage - Register Text, male female radio, Firstname, lastname, Date of Birth drop
 * down, email, Password, Confirm Password, Register Button, "First name is required.","Last name
 * is required.", "Email is required.","Password is required.", "Password is required." error message,
 * "Your registration completed" message, "CONTINUE" button
 * Locators and it's actions
 */
public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerText;

    @CacheLookup
    @FindBy(xpath = "//button[@id='register-button']")
    WebElement registerButton;

    @CacheLookup
    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement error1;

    @CacheLookup
    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement error2;

    @CacheLookup
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement error3;

    @CacheLookup
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement error4;

    @CacheLookup
    @FindBy(xpath = "//input[@id='gender-female']")
    WebElement gender;

    @CacheLookup
    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstname;

    @CacheLookup
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastname;

    @CacheLookup
    @FindBy(xpath = "//input[@id='Email']")
    WebElement eMail;

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]")
    WebElement dy;

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]")
    WebElement mnth;

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]")
    WebElement yer;

    @CacheLookup
    @FindBy(xpath = "//input[@id='Password']")
    WebElement pasword;

    @CacheLookup
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement confirmPasword;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement completed;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;


    public String verifyRegisterText() {
        String message = getTextFromElement(registerText);
        Reporter.log("Register" + registerText.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
        Reporter.log("Register Button" + registerButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on Register Button");
    }

    public String verifyErrorFirstName() {
        String message = getTextFromElement(error1);
        Reporter.log("Error First name" + error1.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }

    public String verifyErrorLastName() {
        String message = getTextFromElement(error2);
        Reporter.log("Error Last name" + error2.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }

    public String verifyErrorEmail() {
        String message = getTextFromElement(error3);
        Reporter.log("error email" + error3.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }

    public String verifyErrorPassword() {
        String message = getTextFromElement(error4);
        Reporter.log("Error password" + error4.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }

    public void selectGender() {
        clickOnElement(gender);
        Reporter.log("Female" + gender.toString());
        CustomListeners.test.log(Status.PASS, "Select gender female");
    }

    public void enterFirstName(String firstName) {
        sendTextToElement(firstname, firstName);
        Reporter.log("First Name" + firstname.toString());
        CustomListeners.test.log(Status.PASS, "Enter first name" + firstName);
    }

    public void enterLastName(String lastName) {
        sendTextToElement(lastname, lastName);
        Reporter.log("Last Name" + lastname.toString());
        CustomListeners.test.log(Status.PASS, "Enter last name" + lastName);
    }

    public void selectDay(String day) {
        selectByValueFromDropDown(dy, day);
        Reporter.log("Day" + dy.toString());
        CustomListeners.test.log(Status.PASS, "Select day" + day);
    }

    public void selectMonth(String month) {
        selectByValueFromDropDown(mnth, month);
        Reporter.log("Month" + mnth.toString());
        CustomListeners.test.log(Status.PASS, "Select month" + month);
    }

    public void selectYear(String year) {
        selectByValueFromDropDown(yer, year);
        Reporter.log("Year" + yer.toString());
        CustomListeners.test.log(Status.PASS, "Select year" + year);
    }

    public void enterEmailId() {
        String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);  //Create random username
        String emailID = "User" + userName + "@example.com";   //Create random email Id
        sendTextToElement(eMail, emailID);
        Reporter.log("Email Id" + eMail.toString());
        CustomListeners.test.log(Status.PASS, "Enter email id" + emailID);
    }

    public void enterPassword(String password) {
        sendTextToElement(pasword, password);
        Reporter.log("password" + pasword.toString());
        CustomListeners.test.log(Status.PASS, "Enter password" + password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        sendTextToElement(confirmPasword, confirmPassword);
        Reporter.log("confirmPassword" + confirmPasword.toString());
        CustomListeners.test.log(Status.PASS, "Enter confirmPassword" + confirmPassword);
    }

    public String verifyRegistrationMessage() {
        String message = getTextFromElement(completed);
        Reporter.log("Registration completed" + completed.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        Reporter.log("Register Button" + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue Button");
    }

}

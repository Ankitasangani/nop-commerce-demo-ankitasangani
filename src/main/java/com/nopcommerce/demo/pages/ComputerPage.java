package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * 3.ComputerPage - Computers text, DesktopsLink, NotebooksLink, SoftwareLink Locators and
 * create appropriate methods for it.
 */

public class ComputerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[2]/ul[1]/li[1]/a[1]")
    WebElement computerTab;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement computerText;

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]")
    WebElement desktopLink;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Desktops')]")
    WebElement desktopText;


    public void clickOnComputerTab() {
        clickOnElement(computerTab);
        Reporter.log("Computer Tab" + computerTab.toString());
        CustomListeners.test.log(Status.PASS, "Click on Computer Tab");
    }

    public String verifyComputerText() {
        String message = getTextFromElement(computerText);
        Reporter.log("Computer" + computerText.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }

    public void mouseHoverOnComputerTab() {
        mouseHoverToElement(computerTab);
        Reporter.log("Computer Tab" + computerTab.toString());
        CustomListeners.test.log(Status.PASS, "Click on Computer Tab");
    }

    public void clickOnDesktopLink() {
        clickOnElement(desktopLink);
        Reporter.log("desktop Link" + desktopLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on desktop Link");
    }

    public String verifyDesktopsText() {
        String message = getTextFromElement(desktopText);
        Reporter.log("Desktop" + desktopText.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }

}

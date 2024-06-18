package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

/**
 * 5.BuildYourOwnComputerPage - Build your own computer Text, Processor Drop Down, Ram
 * drop down, HDD radios, os radio, software check boxes, Add To Card button, "The product has
 * been added to your shopping cart" message locators and it's actions
 */
public class BuildYourOwnComputerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Build your own computer')]")
    WebElement productName;


    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Build your own computer']")
    WebElement buildYourOwnCompHeadingMsg;

    @CacheLookup
    @FindBy(id = "product_attribute_1")
    WebElement processorDropdown;

    @CacheLookup
    @FindBy(id = "product_attribute_2")
    WebElement ramDropdown;

    @CacheLookup
    @FindBy(name = "product_attribute_3")
    List<WebElement> hddRadio;

    @CacheLookup
    @FindBy(name = "product_attribute_4")
    List<WebElement> osRadio;

    @CacheLookup
    @FindBy(xpath = "//dd[@id='product_attribute_input_5']//input")
    List<WebElement> softwareCheckbox;

    @CacheLookup
    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/p[1]")
    WebElement shoppingCart;


    public void clickOnBuildYourOwnComputer() {
        clickOnElement(productName);
        Reporter.log("Build your own computer" + productName.toString());
        CustomListeners.test.log(Status.PASS, "Click on product name Build your own computer");
    }

    public void selectProcessorFromDropdown(String processor) {
        selectByVisibleTextFromDropDown(processorDropdown, processor);
        Reporter.log("Select " + processorDropdown.toString());
        CustomListeners.test.log(Status.PASS, "Select " + processorDropdown.toString());

    }

    public void selectRam(String ram) {
        selectByVisibleTextFromDropDown(ramDropdown, ram);
        Reporter.log("Select " + ramDropdown.toString());
        CustomListeners.test.log(Status.PASS, "Select " + ramDropdown.toString());

    }

    public void selectHddRadio(String radio) {
        List<WebElement> hddRadios = hddRadio;

        String val = "320 GB";
        String val1 = "400 GB [+$100.00]";

        if (val.equalsIgnoreCase(radio)) {
            hddRadios.get(0).click();
        } else if (val1.equalsIgnoreCase(radio)) {
            hddRadios.get(1).click();
        }

        Reporter.log("Select " + hddRadio.toString());
        CustomListeners.test.log(Status.PASS, "Select " + hddRadio.toString());
    }

    public void selectOs(String os) {
        List<WebElement> osOption = getListOfElements(osRadio);
        String val = "Vista Home [+$50.00]";
        String val1 = "Vista Premium [+$60.00]";
        if (val.equalsIgnoreCase(os)) {
            osOption.get(0).click();
        } else if (val1.equalsIgnoreCase(os)) {
            osOption.get(1).click();
        }

        CustomListeners.test.log(Status.PASS, "Select " + osRadio.toString());
        Reporter.log("Select " + osRadio.toString());
    }

    public void selectCheckBox(String software) {
        List<WebElement> softwareOption = getListOfElements(softwareCheckbox);
        String val0 = "Microsoft Office [+$50.00]";
        String val1 = "Acrobat Reader [+$10.00]";
        String val2 = "Total Commander [+$5.00]";

        //deselect all before performing next action
        for (WebElement chkbox : softwareOption) {
            if (chkbox.isSelected())
                chkbox.click();
        }

        //clicking on checkbox
        if (val0.equalsIgnoreCase(software)) {
            softwareOption.get(0).click();
        } else if (val1.equalsIgnoreCase(software)) {
            softwareOption.get(1).click();
        } else if (val2.equalsIgnoreCase(software)) {
            softwareOption.get(2).click();
        }

        CustomListeners.test.log(Status.PASS, "Select " + softwareCheckbox);
        Reporter.log("Select " + softwareCheckbox.toString());
    }


    public void clickOnAddToCart() {
        clickOnElement(addToCartButton);        //CLick add to cart
        CustomListeners.test.log(Status.PASS, "Click on " + addToCartButton);
        Reporter.log("Click on " + addToCartButton.toString());
    }

    public String verifyShoppingCartMessage() {
        String message = getTextFromElement(shoppingCart);
        Reporter.log("shopping cart message" + shoppingCart.toString());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return message;
    }

}

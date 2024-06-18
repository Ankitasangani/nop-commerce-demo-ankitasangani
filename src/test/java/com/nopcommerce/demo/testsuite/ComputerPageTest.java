package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customelisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

/**
 * 3. ComputerPageTest
 * Inside ComputerPageTest class create following testmethods
 * 1. verifyUserShouldNavigateToComputerPageSuccessfully()
 * Click on Computer tab
 * Verify "Computer" text
 * 2. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * Click on Computer tab
 * Click on Desktops link
 * Verify "Desktops" text
 * 3. verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String
 * processor, String ram, String hdd, String os, String software)
 * Click on Computer tab
 * Click on Desktops link
 * Click on product name "Build your own computer"
 * Select processor "processor"
 * Select RAM "ram"
 * Select HDD "hdd"
 * Select OS "os"
 * Select Software "software"
 * Click on "ADD TO CART" Button
 * Verify message "The product has been added to your shopping cart"
 */
@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {

    ComputerPage computerPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        computerPage = new ComputerPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }


    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        computerPage.clickOnComputerTab(); // Click on Computer tab
        // Verify "Computers" text
        String expectedMessage = "Computers";
        String actualMessage = computerPage.verifyComputerText();
        Assert.assertEquals(expectedMessage, actualMessage, "Text didn't match!");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        computerPage.mouseHoverOnComputerTab(); // Click on Computer tab
        computerPage.clickOnDesktopLink(); // click on desktop link
        // Verify "Desktops" text
        String expectedMessage = "Desktops";
        String actualMessage = computerPage.verifyDesktopsText();
        Assert.assertEquals(expectedMessage, actualMessage, "Text didn't match!");
    }

    @Test(groups = {"regression"}, dataProvider = "buildComData", dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        computerPage.mouseHoverOnComputerTab(); // Click on Computer tab
        computerPage.clickOnDesktopLink(); // click on desktop link
        buildYourOwnComputerPage.clickOnBuildYourOwnComputer(); // Click on product name "Build your own computer"
        buildYourOwnComputerPage.selectProcessorFromDropdown(processor); // Select processor "processor"
        buildYourOwnComputerPage.selectRam(ram); // Select RAM "ram"
        buildYourOwnComputerPage.selectHddRadio(hdd); // Select HDD "hdd"
        buildYourOwnComputerPage.selectOs(os); // Select OS "os"
        buildYourOwnComputerPage.selectCheckBox(software); // Select Software "software"
        buildYourOwnComputerPage.clickOnAddToCart();  // Click on "ADD TO CART" Button
        // Verify message "The product has been added to your shopping cart"
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = buildYourOwnComputerPage.verifyShoppingCartMessage();
        Assert.assertEquals(expectedMessage, actualMessage, "Text didn't match!");
    }

}

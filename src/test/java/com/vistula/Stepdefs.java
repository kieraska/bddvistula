package com.vistula;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;

public class Stepdefs {

    AndroidDriver driver;
    SimpleCalculatorPage simplePage;
    AdvancedCalculatorPage advancedPage;

    @Before
    public void setup() throws MalformedURLException {
        URL server = new URL("http://0.0.0.0:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Calculator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        driver = new AndroidDriver(server, capabilities);
        simplePage = new SimpleCalculatorPage(driver);
        advancedPage = new AdvancedCalculatorPage(driver);
    }

    @After
    public void teardown(){
    }

    @Given("I open calculator")
    public void i_open_calculator() {
        // should be empty, calculator is opened in @Before
    }

    @When("I rotate to horizontal position")
    public void i_rotate_to_horizontal_position() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    @Then("advanced options are shown")
    public void advanced_options_are_shown() {
        assertTrue(advancedPage.cosinus.isDisplayed());
    }

    @And("I add two numbers")
    public void i_add_two_numbers() {
        simplePage.two.click();
        simplePage.plus.click();
        simplePage.six.click();
        simplePage.equals.click();
        simplePage.assertResult("8");
    }

    @And("I rotate to portrait position")
    public void i_rotate_to_portrait_position() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

//    // First version
//    @Then("advanced options are not shown")
//    public void advanced_options_are_not_shown(){
//        boolean cosinusPresent = false;
//        try {
//            advancedPage.cosinus.isDisplayed();
//            cosinusPresent = true;
//        } catch (NoSuchElementException ex) {
//            cosinusPresent = false;
//        }
//        assertFalse("cosinus is found", cosinusPresent);
//    }

    //Second version
    @Then("advanced options are not shown")
    public void advanced_options_are_not_shown(){
        try {
            advancedPage.cosinus.isDisplayed();
            fail("cosinus is found");
        } catch (NoSuchElementException ex) {
            //expected exception
        }
    }
}

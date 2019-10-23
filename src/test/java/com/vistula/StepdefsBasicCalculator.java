package com.vistula;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class StepdefsBasicCalculator {

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
    public void teardown() {
        driver.quit();
    }

    @When("I subtract one number from another")
    public void i_subtract_one_number_from_another() {
        simplePage.six.click();
        simplePage.minus.click();
        simplePage.three.click();
        Assert.assertEquals("6−3", simplePage.formula.getText());
        simplePage.equals.click();
    }

    @When("I multiply one number by another")
    public void i_multiply_one_number_by_another() {
        simplePage.two.click();
        simplePage.multiply.click();
        simplePage.six.click();
        Assert.assertEquals("2×6", simplePage.formula.getText());
        simplePage.result.click();
    }

    @When("I divide one number by another")
    public void i_divide_one_number_by_another() {
        simplePage.six.click();
        simplePage.divide.click();
        simplePage.two.click();
        Assert.assertEquals("6÷2", simplePage.formula.getText());
        simplePage.equals.click();
    }

    @Then("Result should be {string}")
    public void resultShouldBe(String expectedResult) {
        simplePage.assertResult(expectedResult);
    }
}

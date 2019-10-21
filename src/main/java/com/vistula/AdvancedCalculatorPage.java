package com.vistula;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class AdvancedCalculatorPage extends SimpleCalculatorPage {


    @FindBy(id="fun_cos")
    WebElement cosinus;

    @FindBy(id="rparen")
    WebElement rightParenthesis;

    @FindBy(id="op_pct")
    WebElement percent;

    public AdvancedCalculatorPage(AndroidDriver driver) {
        super(driver);
    }

//    public void assertAdvancedOptionsAreNotShown(WebElement button){
//        boolean buttonPresent = false;
//        try {
//        button.isDisplayed();
//        buttonPresent = true;
//    } catch (NoSuchElementException ex) {
//        buttonPresent = false;
//    }
//        assertFalse(button + " is found", buttonPresent);
//    }

    public void assertAdvancedOptionsAreNotShown2(WebElement button) {
        try {
            button.isDisplayed();
            fail(button + " is found");
        } catch (NoSuchElementException ex) {
            //expected exception
        }
    }
}

package com.vistula;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}

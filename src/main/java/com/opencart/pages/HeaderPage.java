package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.function.Function;

public class HeaderPage extends BasePage{

    @FindBy (xpath = ".//*[@title='My Account']")
    private WebElement myAccountButton;

    @FindBy (xpath = ".//*[contains (@href, 'register')]")
    private WebElement registerButton;

    public WebElement getMyAccountButton () {
        wait.until(ExpectedConditions.visibilityOf(myAccountButton));
        return myAccountButton;
    }

    public WebElement getRegisterButton () {
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        return registerButton;
    }

}

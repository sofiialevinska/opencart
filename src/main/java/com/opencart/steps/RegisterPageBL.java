package com.opencart.steps;

import com.opencart.datamodel.RegisterModel;
import com.opencart.pages.RegisterPage;
import com.opencart.pages.SuccessRegisterPage;
import com.opencart.repository.RegisterModelRepository;
import com.opencart.util.DriverUtils;
import org.testng.Assert;

public class RegisterPageBL {
    private RegisterPage registerPage;
    private SuccessRegisterPage successRegisterPage;

    public RegisterPageBL () {
        registerPage = new RegisterPage ();
    }

    public RegisterPageBL registerNewPerson () {
        RegisterModel registerModel = RegisterModelRepository.getRegisterModel();
        inputFirstName(registerModel.getFirstName());
        inputLastName(registerModel.getLastName());
        inputEmail(registerModel.getEmail());
        inputTelephone(registerModel.getEmail());
        inputPassword(registerModel.getPassword());
        subscribeNewsletter(1);
        confirmPolicy();
        clickOnContinueButton();

        successRegisterPage = new SuccessRegisterPage();
        return this;
    }

    private void inputFirstName (String firstName){
        registerPage.getFirstNameInput().clear();
        registerPage.getFirstNameInput().sendKeys(firstName);
    }

    private void inputLastName (String lastName) {
        registerPage.getLastNameInput().clear();
        registerPage.getLastNameInput().sendKeys(lastName);
    }

    private void inputEmail (String email) {
        registerPage.getEmailInput().clear();
        registerPage.getEmailInput().sendKeys(email);
    }

    private void inputTelephone (String telephone) {
        registerPage.getTelephoneInput().clear();
        registerPage.getTelephoneInput().sendKeys(telephone);
    }

    private void inputPassword (String password) {
        registerPage.getPasswordInput().clear();
        registerPage.getPasswordInput().sendKeys(password);
        registerPage.getConfirmInput().clear();
        registerPage.getConfirmInput().sendKeys(password);
    }

    private void subscribeNewsletter (int yesNo) {
        new DriverUtils().clickOnElementJS(registerPage.getSubscribedRadioButton(yesNo));
    }

    private void confirmPolicy () {
        new DriverUtils().clickOnElementJS(registerPage.getPolicy());
    }

    private void clickOnContinueButton () {
        registerPage.getContinueButton().click();
    }

    public void verifyUserRegistration () {
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertEquals (successRegisterPage.getSuccessTitle().getText(), expectedMessage, "Incorrect page title");
    }

}


package com.linagora.page.test;

import com.linagora.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    @FindBy(id = "userfield")
    private WebElement usernameInput;

    @FindBy(id = "passwordfield")
    private WebElement passwordInput;

    @FindBy(id = "sign_in_button")
    private WebElement loginButton;

    @FindBy(xpath = "//span[text()='Wrong credentials']")
    private WebElement wrongcredentials;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.loginButton));
        return this.loginButton.isDisplayed();
    }

    public void goTo(String url){
        this.driver.get(url);
    }

    public void login(String username, String password){
        this.usernameInput.sendKeys(username);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();
    }

    public boolean verifyWrongCredentials(){
        this.wait.until(ExpectedConditions.visibilityOf(this.wrongcredentials));
        return this.wrongcredentials.isDisplayed();
    }


}

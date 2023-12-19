package com.cosmotronica.pages.vendorportal;

import com.cosmotronica.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.usernameInput));
        return this.usernameInput.isDisplayed();
    }

    public void goTo(String url){
        this.driver.get(url);
    }



    public void login(String usernames, String passwords){
        this.usernameInput.sendKeys(usernames);
        this.passwordInput.sendKeys(passwords);
        this.loginBtn.click();
    }
}

package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {
WebDriver driver;

@FindBy(id="user-name")
WebElement username;

public WebElement getUsername() {
	return username;
}

@FindBy(id="password")
WebElement password;

public WebElement getPassword() {
	return password;
}

@FindBy(id="login-button")
WebElement loginbutton;

public WebElement getLoginbutton() {
	return loginbutton;
}

@FindBy(xpath="//div[@class='error-message-container error']")
WebElement errormessage;

public String getErrormessage() {
	return errormessage.getText();
}

@FindBy(className="title")
WebElement productheading;

public String getProductheading() {
	return productheading.getText();
}

public LoginPages(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

}

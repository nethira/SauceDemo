package com.qa.stepdefinitions;

import java.sql.DriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.qa.pages.LoginPages;

import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageDefinition {

	WebDriver driver;
	LoginPages login;
	
	@Before
	public void setUp() {
		
		driver=new ChromeDriver();
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("User is on saucedemo login page")
	public void user_is_on_saucedemo_login_page() {
	    driver.get("https://www.saucedemo.com/");
	    login = new LoginPages(driver);
	}

	@Given("User entered a valid username and password")
	public void user_entered_a_valid_username_and_password() {
	    login.getUsername().sendKeys("standard_user");
	    login.getPassword().sendKeys("secret_sauce");
	}

	@When("User click on Login button")
	public void user_click_on_login_button() {
	    login.getLoginbutton().click();
	}

	@Then("User should land on Products Page")
	public void user_should_land_on_products_page() {
	    String title=login.getProductheading();
	    System.out.println(title);
	    Assert.assertEquals(title, "Product");
	}

	@Given("User entered a invalid {string} and {string}")
	public void user_entered_a_invalid_and(String username, String password) {
		login.getUsername().sendKeys(username);
	    login.getPassword().sendKeys(password);
	}

	@Then("User should display error message as {string}")
	public void user_should_display_error_message_as(String error) {
	   String actualerror=login.getErrormessage();
	   System.out.println(actualerror);
	   Assert.assertEquals(actualerror, error);
	}
     
	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
		byte []	screenshotTaken=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotTaken, "image/png", "error screenshot");
		}
	}
}

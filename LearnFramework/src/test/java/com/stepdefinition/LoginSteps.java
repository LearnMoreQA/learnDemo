package com.stepdefinition;

import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import helper.ActionsHelper;
import helper.TextBoxHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resuseable.BrowerInvoke;

import java.io.IOException;

public class LoginSteps extends BrowerInvoke {
    private WebDriver driver;
    private LoginPage login;
    private DashboardPage dashboardPage;

    @Given("User Navigates to Required Url")
    public void navigatesToUrl() throws IOException {
       driver = BrowerInvoke.openBrowser();  // Acutal Property
    }

    @When("User Enters valid Username and Password")
    public void userEntersValidCredentials() {
        login = new LoginPage(driver);
        login.enterValidCredentials();
    }

    @And("User Clicks the Login Button")
    public void userClicksLoginBtn() {
       login.clickLoginButton();
    }

    @Then("Validate System navigates to Home Page")
    public void navigatesToHomePage() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyPageTitle();
    }
}

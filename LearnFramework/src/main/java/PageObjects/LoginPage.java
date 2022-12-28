package PageObjects;

import helper.ActionsHelper;
import helper.TextBoxHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //PageFactory

    TextBoxHelper textBoxHelper;
    ActionsHelper actionsHelper;

    public LoginPage(WebDriver driver){
        textBoxHelper = TextBoxHelper.getInstance(driver);
        actionsHelper = ActionsHelper.getInstance(driver);
        PageFactory.initElements(driver, this); // this --> Same Class Object
    }

    @FindBy(name = "username")
    private WebElement USERNAME;

    @FindBy(name = "password")
   private WebElement PASSWORD;

    @FindBy(xpath = "//button[normalize-space(text()='Login')]")
    private WebElement LOGINBTN;

    // Find Element
    // Enter the UN and Pwd
    // Click Login Btn


    public void enterValidCredentials(){
        textBoxHelper.enterText(USERNAME,"Admin");
        textBoxHelper.enterText(PASSWORD,"admin123");
    }

    public void clickLoginButton(){
        actionsHelper.clickElement(LOGINBTN);
    }

}

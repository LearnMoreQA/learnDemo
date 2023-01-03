package PageObjects;

import Utils.ExcelUtils;
import helper.ActionsHelper;
import helper.TextBoxHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    //PageFactory

    TextBoxHelper textBoxHelper;
    ActionsHelper actionsHelper;

    private List<String> data;

    public LoginPage(WebDriver driver){
        textBoxHelper = TextBoxHelper.getInstance(driver);
        actionsHelper = ActionsHelper.getInstance(driver);
        PageFactory.initElements(driver, this); // this --> Same Class Object
        data = ExcelUtils.readExcelData("LoginData", "Login Data");
    }

    @FindBy(name = "username")
    private WebElement USERNAME;

    @FindBy(name = "password")
   private WebElement PASSWORD;

    @FindBy(xpath = "//button[normalize-space(text()='Login')]")
    private WebElement LOGINBTN;

    @FindBy(xpath = "//div[contains(@class,'content--error')]/child::p")
    private WebElement errorMsg;



    // Find Element
    // Enter the UN and Pwd
    // Click Login Btn


    public void enterValidCredentials(){
        textBoxHelper.enterText(USERNAME, data.get(0));
        textBoxHelper.enterText(PASSWORD, data.get(1));
    }

    public void enterInValidCredentials(){
        textBoxHelper.enterText(USERNAME, data.get(2));
        textBoxHelper.enterText(PASSWORD,data.get(3));
    }

    public void validateErrorMessage(){
        Assert.assertEquals("",errorMsg.getText());
    }

    public void clickLoginButton(){
        actionsHelper.clickElement(LOGINBTN);
    }

}

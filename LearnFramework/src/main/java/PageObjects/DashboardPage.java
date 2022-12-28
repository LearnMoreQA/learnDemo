package PageObjects;

import helper.ActionsHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    ActionsHelper actionsHelper;

    public DashboardPage(WebDriver driver){
       actionsHelper = ActionsHelper.getInstance(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(@class,'header-breadcrumb')]/child::h6")
    private WebElement TITLE;


    public void verifyPageTitle() // Method Declaration
    {
        String actualText = actionsHelper.getTextValue(TITLE);
        Assert.assertEquals("Dashboard",actualText);
    }

}

package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsHelper {
    private WebDriver webDriver;
    private static ActionsHelper actionsHelper;

    public ActionsHelper(WebDriver driver){
        webDriver = driver;
    }

    public static ActionsHelper getInstance(WebDriver driver){
        actionsHelper = new ActionsHelper(driver);
        return actionsHelper;
    }

    public void clickElement(By locator){
        webDriver.findElement(locator).click();
    }

    public String getTextValue(By locator){
      String textValue = webDriver.findElement(locator).getText();
      return textValue;
    }

    public String getTextValue(WebElement element){
        String textValue = element.getText();
        return textValue;
    }

    public void clickElement(WebElement element) {
        element.click();
    }
}

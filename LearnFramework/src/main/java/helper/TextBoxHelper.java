package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxHelper {

    private WebDriver webDriver;

    private static TextBoxHelper textBoxHelper;

    public TextBoxHelper(WebDriver driver){
        webDriver = driver;
    }

    public static TextBoxHelper getInstance(WebDriver driver){
        textBoxHelper = new TextBoxHelper(driver);
        return textBoxHelper;
    }

    public void enterText(By locator,String textValue){
        webDriver.findElement(locator).sendKeys(textValue);
    }

    public void enterText(WebElement element,String textValue){
        element.sendKeys(textValue);
    }

}

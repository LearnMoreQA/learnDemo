package com.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import resuseable.BrowerInvoke;

public class Hooks extends BrowerInvoke {

    @AfterStep
    public void captureScreenshot(Scenario scenario){
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png",null);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}

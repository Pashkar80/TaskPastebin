package tests;

import driver.LocalDriver;
import entity.Paste;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import steps.CommonSteps;

/**
 * Created by user on 11.10.2019.
 */
public class TestNewSimplePaste {

    Paste paste = new Paste("Hello from WebDriver!!!","10 Minutes","helloweb");
    private WebDriver driver;

    @BeforeTest
    public void initeDriver() {
        driver = LocalDriver.initeWebDriver();
    }

    @Test
    public void  isSimplePasteCreatedTest() throws InterruptedException {
        MainPage step = new CommonSteps(driver).createNewSimplePaste(paste);

    }


    @AfterTest
    public void closeDriver() {
        LocalDriver.stopWebDriver();
    }
}

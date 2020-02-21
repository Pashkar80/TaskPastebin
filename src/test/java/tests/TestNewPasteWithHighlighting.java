package tests;

import driver.LocalDriver;
import entity.Paste;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import steps.CommonSteps;

/**
 * Created by user on 17.10.2019.
 */
public class TestNewPasteWithHighlighting {
    Paste paste = new Paste("git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force",
            "Bash",
            "10 Minutes",
            " how to gain dominance among developers");
    private WebDriver driver;


    @BeforeTest

    public void initeDriver() throws InterruptedException {
        driver = LocalDriver.initeWebDriver();
        MainPage step = new CommonSteps(driver).createNewPasteWithHighlighting(paste);

    }


    @Test
    public void checkTitleTest()  {
        CommonSteps steps = new CommonSteps(driver);
        String title = steps.getTitlePage();
        Assert.assertEquals(title, paste.getNamePaste());
    }

    @Test
    public  void checkSyntaxHighlighting(){
        CommonSteps steps = new CommonSteps(driver);
        String valueSyntaxHighlighting=steps.getSyntaxHighlighting();
        Assert.assertEquals(valueSyntaxHighlighting,paste.getHighlighting());

    }

    @Test
    public void checkCodeFromTextArea(){
        CommonSteps steps = new CommonSteps(driver);
        String textCode = steps.getTextCode();
        Assert.assertEquals(textCode,paste.getCode());
    }

    @AfterTest
    public void closeDriver() {
        LocalDriver.stopWebDriver();
    }

}

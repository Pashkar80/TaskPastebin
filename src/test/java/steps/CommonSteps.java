package steps;

import entity.Paste;
import org.openqa.selenium.WebDriver;
import pages.CreatedPastePage;
import pages.MainPage;

/**
 * Created by user on 11.10.2019.
 */
public class CommonSteps {
    private WebDriver driver;


    public CommonSteps(WebDriver driver) {
        this.driver = driver;
    }

    public static  String getPartString(String startLine) {
        String partLine = "";
        String[] parts = startLine.split(" ", 2);
        for (int i = 0; i < parts.length; i++) {
            partLine = parts[parts.length - 1];
        }
        String[] partsLine = partLine.split("-", 2);
        for (int i = 0; i <partsLine.length; i++) {
            partLine = " "+partsLine[partsLine.length-2].trim();
        }
        return  partLine;
    }

    public MainPage createNewSimplePaste(Paste paste) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.fillTextfield(paste.getCode());
        mainPage.selectExpiration(paste.getValueExpiration());
        mainPage.getPasteName(paste.getNamePaste());
        mainPage.submitPaste();
        return mainPage;
    }


    public MainPage createNewPasteWithHighlighting(Paste paste) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.fillTextfield(paste.getCode());
        mainPage.selectHighlighting(paste.getHighlighting());
        mainPage.selectExpiration(paste.getValueExpiration());
        mainPage.getPasteName(paste.getNamePaste());
        mainPage.submitPaste();
        return mainPage;
    }

    public String getTitlePage() {
        CreatedPastePage createdPastePage = new CreatedPastePage(driver);
        String title = createdPastePage.getPageTitle();
       String value = CommonSteps.getPartString(title);
        return value;
    }

    public String getSyntaxHighlighting() {
        CreatedPastePage createdPastePage = new CreatedPastePage(driver);
        String highlightingSyntax = createdPastePage.getHighlighting();
        return highlightingSyntax;
    }

    public String getTextCode() {
        CreatedPastePage createdPastePage = new CreatedPastePage(driver);
        String codeText = createdPastePage.getTextFromTextArea();
        return codeText;
    }
}

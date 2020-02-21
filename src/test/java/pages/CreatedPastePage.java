package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.OperationNotSupportedException;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 17.10.2019.
 */
public class CreatedPastePage extends PageObject {

    public CreatedPastePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);

    }

    @Override
    public void openPage() throws OperationNotSupportedException {

    }


    @FindBy(xpath = "//head/title")
    private WebElement titlePage;

    @FindBy(xpath = "//*[@id='code_buttons']/span[2]/a")
    private WebElement syntaxHighlighting;

    @FindBy(xpath = "//*[@id='paste_code']")
    private WebElement textArea;

    public String getPageTitle() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String title = titlePage.getAttribute("innerHTML");
        return title;
    }

    public String getHighlighting() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String valueHighlighting = syntaxHighlighting.getAttribute("innerHTML");
        return valueHighlighting;
    }

    public String getTextFromTextArea(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String textCode= textArea.getText();
        return textCode;
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by user on 11.10.2019.
 */
public class MainPage extends PageObject {
    private static final String BASE_URL = "https://pastebin.com/";


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void openPage() {
        driver.get(BASE_URL);

    }

    @FindBy(id = "paste_code")
    private WebElement textField;


    @FindBy(xpath = "//*[@id='myform']//descendant::b")
    private WebElement formPasteExpiration;


    @FindBy(xpath = "//*[@id='myform']/descendant::select[@class='post_select select2_nosearch select2-hidden-accessible']")
    private WebElement selectValueExpiration;


    @FindBy(xpath = "//*[@class='form_right']/select")
    private WebElement selectHighlighting;



    @FindBy(xpath = "//*[@class='form_right']/descendant::b")
    private WebElement formHighlighting;


    @FindBy(name = "paste_name")
    private WebElement namePasteField;

    @FindBy(id = "submit")
    private WebElement buttonNewPaste;


    public void fillTextfield(String code) {
        textField.sendKeys(code);
    }

    public void selectExpiration(String valueExpiration) {
        formPasteExpiration.click();
        Select select = new Select(selectValueExpiration);
        select.selectByVisibleText(valueExpiration);
        formPasteExpiration.click();

    }

    public void getPasteName(String namePaste) {
        namePasteField.sendKeys(namePaste);

    }

    public void submitPaste() {
        buttonNewPaste.submit();

    }

    public void selectHighlighting(String valueHighlighting) {
        formHighlighting.click();
        Select select = new Select(selectHighlighting);
        select.selectByVisibleText(valueHighlighting);
        formHighlighting.click();


    }


}
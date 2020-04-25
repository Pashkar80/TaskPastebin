package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by user on 09.10.2019.
 */
public class LocalDriver {
   // private static final String CHROME = "webdriver.chrome.driver";
    private static final String FIREFOX= "webdriver.firefox.driver";
   // private static final String CHROME_PATH = "E:\\webdriver\\chromedriver.exe";
     private static final String FIREFOX_PATH = "E:\\webdriver\\geckodriver.exe";


    private static WebDriver driver;

    public LocalDriver() {
    }

    static {
        initWebDriver();
    }

    public static WebDriver initWebDriver() {
      //  System.setProperty(CHROME, CHROME_PATH);
       System.setProperty(FIREFOX, FIREFOX_PATH);
        if (driver == null) {
         //   driver = new ChromeDriver();
          driver= new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void stopWebDriver() {
        driver.quit();
        driver = null;
    }
}

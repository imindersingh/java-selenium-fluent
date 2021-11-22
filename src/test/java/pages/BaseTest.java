package pages;

import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.ExecutableFinder;

public class BaseTest extends FluentTest {

    private static final String PATH_TO_CHROME_DRIVER = "src/test/resources/chromedriver";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    private static WebDriver webDriver;

    @BeforeClass
    public static void setup() {
        if (systemPropertyNotSet() && executableNotPresentInPath()) {
            setSystemProperty();
        }
        webDriver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
    }

    private static boolean executableNotPresentInPath() {
        return new ExecutableFinder().find("chromedriver") == null;
    }

    private static boolean systemPropertyNotSet() {
        return System.getProperty(CHROME_DRIVER_PROPERTY) == null;
    }

    private static void setSystemProperty() {
        System.setProperty(CHROME_DRIVER_PROPERTY, PATH_TO_CHROME_DRIVER);
    }

}

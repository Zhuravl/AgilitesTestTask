package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.TestContext;
import org.apache.logging.log4j.Logger;

/**
 * Class contains common methods for pages
 */
public abstract class BasePage {
    private WebDriver driver = TestContext.getDriver();
    protected static Logger log = TestContext.getLogger();

    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver(){
        return driver;
    }
}
package pages;

import org.openqa.selenium.support.PageFactory;
import utils.TestContext;
import org.apache.logging.log4j.Logger;

/**
 * Class contains common methods for pages
 */
public abstract class BasePage {
    protected static Logger log = TestContext.getLogger();

    public BasePage(){
        PageFactory.initElements(TestContext.getDriver(), this);
    }
}
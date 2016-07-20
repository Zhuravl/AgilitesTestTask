package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.TestContext;
import java.util.logging.Logger;

/**
 * Class contains common methods for pages
 */
public abstract class BasePage {
    private WebDriver driver;
    private static Logger log = TestContext.getLogger();

    public BasePage(){
        driver = TestContext.getDriver();
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void getToUrl(String url){
        log.info("Navigate to url " + url);
        driver.get(url);
    }

    public void typeInto(WebElement input, String text){
        log.info("Enter text '" + text + "' in the " + input.toString());
        input.clear();
        input.sendKeys(text);
    }

    public void returnToDefaultFrame(){
        log.info("Switch to default frame content");
        driver.switchTo().defaultContent();
    }

    public void switchToFrame(WebElement element){
        log.info("Switch to frame from element '" + element.toString() + "'");
        driver.switchTo().frame(element);
    }
}
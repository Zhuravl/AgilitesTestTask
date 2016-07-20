package components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Class contains description of elements from support page
 */
public class SupportPage extends BasePage{

    @FindBy(id = "txtSearch")
    private WebElement txtSearch;

    @FindBy(xpath = "//div[contains(@class, 'newlikes')]")
    private List<WebElement> likeDislikeElements;

    @FindBy(id = "supportFrame")
    private WebElement outerFrame;

    @FindBy(xpath = "//div[@id='nR_WidgetContainer']/iframe[contains(@id, 'nanoRep_frame_embed_')]")
    private WebElement innerFrame;

    @FindBy(xpath = "//div[@id='searchSuggestions']/div")
    private List<WebElement> allSuggestions;

    public void enterRequest(String text){
        navigateInsideFrames();
        typeInto(txtSearch, text);
        returnToDefaultFrame();
    }

    public void navigateToPage(String url) {
        getToUrl(url);
    }

    public void selectSuggestion(String suggestion){
        navigateInsideFrames();

        for (WebElement s : allSuggestions) {
            if (s.getText().equals(suggestion)) {
                s.click();
                break;
            }
        }

        returnToDefaultFrame();
    }

    public String getLastLikeDislikeValue() {
        WebElement element = getLastLikeDislikeElement();
        if (element != null) {
            return element.getText();
        } else {
            return null;
        }
    }

    public void scrollToLastLikeDislike() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Integer lastElementYLocation = getLastLikeDislikeElement().getLocation().getY();
        returnToDefaultFrame();
        js.executeScript("function f() {window.scrollTo(0, " + lastElementYLocation.toString() + ");} f()");
    }

    private void navigateInsideFrames(){
        returnToDefaultFrame();
        switchToFrame(outerFrame);
        switchToFrame(innerFrame);
    }

    private WebElement getLastLikeDislikeElement() {
        navigateInsideFrames();
        List<WebElement> list = likeDislikeElements;
        if (list.size() > 0) {
            return list.get(list.size() - 1);
        } else {
            return null;
        }
    }
}

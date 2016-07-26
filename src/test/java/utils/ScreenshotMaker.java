package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Class contains implementation of the screenshot attachments
 */
public class ScreenshotMaker extends TestListenerAdapter {

    @Step("Failed test screenshot")
    @Override
    public void onTestFailure(ITestResult tr) {
        saveAllureScreenshot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) TestContext.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

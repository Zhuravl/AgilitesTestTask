package tests;

import org.testng.annotations.Test;
import utils.TestContext;

public class SliderTest extends BaseTest{

    @Test(description = "Like/Dislike number test")
    public void likeDislikeNumberTest() throws InterruptedException{
        sliderFeature.navigateToPage(TestContext.sliderPageUrl);
        log.info("test");
    }
}

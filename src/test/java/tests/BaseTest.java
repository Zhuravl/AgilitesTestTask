package tests;

import features.SliderFeature;
import org.testng.annotations.*;
import utils.TestContext;
import org.apache.logging.log4j.Logger;

/**
 * Contains base test methods
 */
public abstract class BaseTest {

    static Logger log = TestContext.getLogger();
    SliderFeature sliderFeature;

    @BeforeSuite
    public void setUp() {
        TestContext.startTargetApp();

        log.info("Start tests execution");
        sliderFeature = new SliderFeature();
    }

    @AfterSuite
    public void tearDown() {
        log.info("Finish tests execution");
        TestContext.closeDriver();

        TestContext.stopTargetApp();
    }
}
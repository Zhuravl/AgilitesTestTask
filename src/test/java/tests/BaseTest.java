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
        log.info("Start server");
        TestContext.startServer();
        log.info("Server has started successfully");

        log.info("Start tests execution");
        sliderFeature = new SliderFeature();
    }

    @AfterSuite
    public void tearDown() {
        log.info("Finish tests execution");
        TestContext.closeDriver();

        log.info("Stop server");
        TestContext.stopServer();
        log.info("Server has stopped successfully");

    }
}
package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class contains all necessary utils and properties
 */
public class TestContext {
    private static WebDriver driver;
    private static final Logger log = LogManager.getLogger(TestContext.class);
    private static final String APP_NAME = "test-slider-1.0.0-SNAPSHOT";

    public static final long DEFAULT_WAIT_TIME = 1000;
    public static final String SLIDER_PAGE_URL = "http://localhost:4567/index.html";

    /**
     * Creates and returns WebDriver instance
     */
    public static WebDriver getDriver(){
        if (driver == null){
            log.info("Create driver");
            driver = new FirefoxDriver();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    /**
     * Closes WebDriver
     */
    public static void closeDriver(){
        if (driver != null){
            log.info("Close driver");
            driver.close();
        }
    }

    /**
     * Returns Logger instance
     */
    public static Logger getLogger() {
        return log;
    }

    /**
     * Starts target application
     */
    public static void startTargetApp(){
        try {
            log.info("Start server");
            Runtime.getRuntime().exec("java -jar " + APP_NAME + ".jar");
            log.info("Server has started successfully");
        } catch (IOException e) {
            log.error("Server starting failed!");
            e.printStackTrace();
        }
    }

    /**
     * Stops target application
     */
    public static void stopTargetApp(){
        try {
            log.info("Stop server");
            Runtime.getRuntime().exec("taskkill /IM java.exe /T /F");
            log.info("Server has stopped successfully");
        } catch (IOException e) {
            log.error("Server stopping failed!");
            e.printStackTrace();
        }
    }
}

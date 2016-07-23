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

    private static Logger log = LogManager.getLogger(TestContext.class);

    private static final String APP_NAME = "test-slider-1.0.0-SNAPSHOT";
    public static final long DEFAULT_WAIT_TIME = 1000;
    public static final String SLIDER_PAGE_URL = "http://localhost:4567/index.html";

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

    public static void closeDriver(){
        if (driver != null){
            log.info("Close driver");
            driver.close();
        }
    }

    public static Logger getLogger() {
        return log;
    }

    public static void startServer(){
        try {
            log.info("Start server");
            Runtime.getRuntime().exec("java -jar " + APP_NAME + ".jar");
            log.info("Server has started successfully");
        } catch (IOException e) {
            log.error("Server starting failed!");
            e.printStackTrace();
        }
    }

    public static void stopServer(){
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

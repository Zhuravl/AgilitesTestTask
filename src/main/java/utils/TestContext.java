package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class contains all necessary utils and properties
 */
public class TestContext {
    private static WebDriver driver;
    private static Logger log = LogManager.getLogger(TestContext.class);
    private static final String appName = "test-slider-1.0.0-SNAPSHOT";

    public static final String sliderPageUrl = "http://localhost:4567/index.html";

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
            Runtime.getRuntime().exec("java -jar " + appName + ".jar");
        } catch (IOException e) {
            log.error("Server starting failed!");
            e.printStackTrace();
        }
    }

    public static void stopServer(){
        try {
            Runtime.getRuntime().exec("taskkill /IM java.exe /T /F");
        } catch (IOException e) {
            log.error("Server stopping failed!");
            e.printStackTrace();
        }
    }
}

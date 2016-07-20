package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Class contains all necessary utils and properties
 */
public class TestContext {
    private static WebDriver driver;
    private static Logger log;
    private static final String appName = "test-slider-1.0.0-SNAPSHOT";

    public static final String sliderPageUrl = "http://localhost:4567/index.html";

    public static WebDriver getDriver(){
        if (driver == null){
            log.info("Create driver");
            driver = new FirefoxDriver();

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
        if(log == null){
            log = Logger.getLogger(TestContext.class.getName());
        }
        return log;
    }

    public static void startServer(){
        try {
            Runtime.getRuntime().exec("java -jar " + appName + ".jar");
        } catch (IOException e) {
            log.severe("Server starting failed!");
            e.printStackTrace();
        }
    }

    public static void stopServer(){
        try {
            Runtime.getRuntime().exec("taskkill /IM " + appName + ".jar /T /F");
        } catch (IOException e) {
            log.severe("Server stopping failed!");
            e.printStackTrace();
        }
    }
}

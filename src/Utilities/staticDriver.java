package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class staticDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    static {
        closeTheOthers();
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

//    public static void BekleKapat_Y() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        driver.quit();
//    }

    public static void Bekle_Y(double saniye) {

        try {
            Thread.sleep((long) saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void scrollIntro(JavascriptExecutor js, int a, int b) {
        js = (JavascriptExecutor) driver;
        String x = "window.scrollBy(" + a + "," + b + ")";
        js.executeScript(x);
    }
    public static void closeTheOthers() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }
}

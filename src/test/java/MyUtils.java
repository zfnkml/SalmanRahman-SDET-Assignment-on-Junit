import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/*
 ** 2024, December 25, Wednesday, 4:04 PM
 */
public class MyUtils {
    public static void scroll(WebDriver webDriver, int pixel) {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0," + pixel + ")");
    }
    public static void scroll(WebDriver webDriver) {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }
}

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 ** 2024, December 26, Thursday, 4:24 AM
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Q1_DigitalUnite {
    WebDriver webDriver;

    @BeforeAll
    void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    void digitalUnite_formFillUp_confirmationMessage() throws InterruptedException {
        webDriver.get("https://www.digitalunite.com/practice-webform-learners");

        cookieMessageClose();
        formFillUp_firstHalf();

        MyUtils.scroll(webDriver, 360);
        Thread.sleep(1000);

        fileUpload();
        clickCheckBox();
        formSubmissionAndConfirmation();
    }

    private void formSubmissionAndConfirmation() throws InterruptedException {
        webDriver.findElements(By.className("btn-primary")).get(1).click();

        if ("Practice webform for learners"
                .equalsIgnoreCase(webDriver.findElement(By.id("block-pagetitle-2")).getText())) {
            String text = webDriver.findElement(By.className("alert-dismissible")).getText();
            Matcher matcher = Pattern.compile("Please wait (\\d+) seconds").matcher(text);
            int millis = 1000;
            if(matcher.find())
                millis *= Integer.parseInt(matcher.group(1));
            MyUtils.scroll(webDriver);
            Thread.sleep(millis);

            webDriver.findElements(By.className("btn-primary")).get(1).click();
        }

        Assertions.assertEquals("Thank you for your submission!", webDriver.findElement(By.id("block-pagetitle-2")).getText());
    }

    private void clickCheckBox() {
        webDriver.findElement(By.id("edit-age")).click();
    }

    private void fileUpload() throws InterruptedException {
        WebElement chooseFile = webDriver.findElement(By.id("edit-uploadocument-upload"));
        String first = System.getProperty("user.dir");
        String mid = "/src/test/resources/";
        String last = "myImage.jpg";
        chooseFile.sendKeys(first + mid + last);
        Thread.sleep(5000);
    }

    private void formFillUp_firstHalf() {
        List<WebElement> webElementList = webDriver.findElements(By.className("form-control"));
        webElementList.get(0).sendKeys("First Last");
        webElementList.get(1).sendKeys("0123456789");
        webElementList.get(2).sendKeys("2612", Keys.ARROW_RIGHT, "2024");
        webElementList.get(3).sendKeys("first.last@email.com");
        webElementList.get(4).sendKeys("""
                Practicing SQA
                It's been fun so far.
                Lets see where the road take me.
                """);
    }

    private void cookieMessageClose() {
        webDriver.findElements(By.className("onetrust-close-btn-handler")).getFirst().click();
    }

    @AfterAll
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
}

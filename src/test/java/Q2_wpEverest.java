import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

/*
 ** 2024, December 26, Thursday, 4:24 AM
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Q2_wpEverest {
    WebDriver webDriver;
    Random random;

    @BeforeAll
    void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        random = new Random();
    }

    @Test
    void wpEverestFormFillUp_confirmationMessage() throws InterruptedException {
        webDriver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");

        fillUpWithText(
                "First",
                "Last",
                "first.last" + random.nextInt(1000) + "@gmail.com",
                "Password.12345678" + random.nextInt(1000),
                "Bangladeshi",
                "0123456789",
                "Bangladesh"
        );

        clickRadioButton();
        fillUpCalendar();

        Thread.sleep(1000);
        MyUtils.scroll(webDriver);

        tickCheckBox();
        clickSubmitButton();

        Assertions.assertEquals(
                "User successfully registered.",
                webDriver.findElement(By.id("ur-submit-message-node")).getText()
        );
    }

    private void clickSubmitButton() {
        webDriver.findElements(By.cssSelector("[type=\"submit\"]")).get(2).click();
    }

    private void tickCheckBox() {
        webDriver.findElement(By.id("privacy_policy_1665633140")).click();
    }

    private void fillUpWithText(String firstName, String lastName, String email, String password, String nationality, String phoneNumber, String country) throws InterruptedException {
        List<WebElement> inputText = webDriver.findElements(By.className("input-text"));
        inputText.get(0).sendKeys(firstName);
        inputText.get(1).sendKeys(email);
        inputText.get(2).sendKeys(password);
        Thread.sleep(1000);
        inputText.get(3).sendKeys(lastName);
        inputText.get(5).sendKeys(nationality);

        webDriver.findElements(By.id("phone_1665627880")).get(1).sendKeys(phoneNumber);
        new Select(webDriver.findElement(By.id("country_1665629257"))).selectByVisibleText(country);
    }

    private void fillUpCalendar() {
        WebElement calendar = webDriver.findElements(By.cssSelector("[data-label=\"Date of Birth\"]")).getFirst();
        calendar.click();
        calendar.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_RIGHT, Keys.ENTER);
//        new Actions(webDriver).sendKeys(calendar, Keys.ARROW_DOWN, Keys.ARROW_RIGHT, Keys.ENTER).perform();
    }

    private void clickRadioButton() {
        webDriver.findElements(By.className("input-radio")).getFirst().click();
    }

    @AfterAll
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
}

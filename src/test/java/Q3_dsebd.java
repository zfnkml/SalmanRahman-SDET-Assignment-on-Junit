import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

/*
 ** 2024, December 26, Thursday, 4:24 AM
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Q3_dsebd {
    WebDriver webDriver;
    FileWriter fileWriter;

    @BeforeAll
    void setUp() throws IOException {
        webDriver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        fileWriter = new FileWriter("./src/test/resources/scrapData.txt");

    }

    @Test
    void scrapData_htmlTable_textFile() throws IOException {
        webDriver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");

        WebElement table = webDriver.findElements(By.className("table")).get(1);
        List<WebElement> rowList = table.findElements(By.tagName("tr"));
        for (WebElement row : rowList) {
            List<WebElement> dataList = row.findElements(By.tagName("td"));
            for (WebElement data : dataList) {
                System.out.printf("%s\t",data.getText());
                fileWriter.write(String.format("%s\t",data.getText()));
            }
            System.out.println();
            fileWriter.write("\n");
        }

        fileWriter.flush();
    }

    @AfterAll
    void tearDown() throws InterruptedException, IOException {
        fileWriter.close();
        webDriver.quit();
    }
}

package HomeWork;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class H2 extends BaseTest
{
    @BeforeEach
    void SetUp()
    {
            driver.get("https://www.target.com/");
    }
    @Test
    void test() throws InterruptedException, IOException
    {
        driver.findElement(By.id("search")).sendKeys("milk" + Keys.ENTER);
        Thread.sleep(3000);

       // driver.findElement(By.xpath("//div[6]/form[1]/button[2]")).click();
        driver.navigate().refresh();
        Thread.sleep(3000);

        WebElement searchResults =
                driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div[1]/h2[1]"));
        assertTrue(searchResults.getText().contains("results for “milk”"));

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("milks.png"));

        driver.navigate().back();
        Thread.sleep(3000);

    }

}

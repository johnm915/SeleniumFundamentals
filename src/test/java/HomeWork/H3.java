package HomeWork;

import common.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class H3 extends BaseTest
{
    @BeforeEach
    void SetUp()
    {
        driver.get("https://duckduckgo.com/");

    }
    @Test
    void test()
    {
        driver.findElement(By.id("searchbox_input")).sendKeys("maven" + Keys.ENTER);
        WebElement search = driver.findElement(By.name("q"));
        String maven = search.getAttribute("value");
        assertEquals("maven", maven);

        List<WebElement> links = driver.findElements(By.partialLinkText("Apache Maven"));
        assertTrue(links.size() != 0) ;

    }
    @AfterEach
    void tearDown()
    {
        driver.quit();
    }
}

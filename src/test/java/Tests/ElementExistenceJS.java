package Tests;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementExistenceJS extends BaseTest
{
    @BeforeEach
    void setUp()
    {
     driver.get("https://www.amazon.com/");
    }
    @Test
    void ElementExistenceAndScrolling() throws InterruptedException {
        List<WebElement> searchBoxes = driver.findElements(By.id("twotabsearchtextbox"));
        assertEquals(1,searchBoxes.size());

        List<WebElement> jon = driver.findElements(By.id("jon"));
        assertEquals(0, jon.size());

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        jse.executeScript("window.scrollTo(0,3000)");
        Thread.sleep(5000);

    }

}

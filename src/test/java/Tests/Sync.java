package Tests;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sync extends BaseTest
{
    @BeforeEach
    void setUp()
    {
     driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }
    @Test
    void testExplicit()
    {
        driver.findElement(By.tagName("button")).click();

        //WebElement helloWorld = driver.findElement(By.id("finish"));
        WebElement helloWorld = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assertEquals("Hello World!", helloWorld.getText());
    }
    @Test
    void testImplicit()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.tagName("button")).click();
        WebElement helloWorld = driver.findElement(By.id("finish"));
        assertEquals("Hello World!", helloWorld.getText());
    }
    @Test
    void elementNotOnPage()
    {
        List<WebElement> list = driver.findElements(By.id("SP"));
    }
    @Test
    void elementNotOnPageWithImplicitWait()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("SP"));
    }
    @Test
    void elementNotOnPageWithExplicitWait()
    {
        new WebDriverWait(driver, Duration.ofSeconds(0))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("SP")));
    }
}

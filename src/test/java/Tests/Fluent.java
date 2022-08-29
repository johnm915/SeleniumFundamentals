package Tests;

import common.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Fluent extends BaseTest
{
    @BeforeEach
    void setUp()
    {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @Test
    void testExplicit() //used more often
    {
        driver.findElement(By.tagName("button")).click();

        //WebElement helloWorld = driver.findElement(By.id("finish"));
        WebElement helloWorld = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assertEquals("Hello World!", helloWorld.getText());
    }

    @Test
    void testFluent()
    {
        driver.findElement(By.tagName("button")).click();

        WebElement helloWorld = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(By.id("finish")));

    }
    @AfterEach
    void tearDown()
    {
        driver.quit();
    }
}
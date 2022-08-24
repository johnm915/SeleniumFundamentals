package Tests;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class Fluent extends BaseTest
{
    @BeforeEach
    void setUp()
    {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }


    @Test
    void testFluent()
    {
        driver.findElement(By.tagName("button")).click();


    }
}
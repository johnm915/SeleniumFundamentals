package Tests;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElementStates extends BaseTest
{
    @BeforeEach
    void setUp()
    {
        driver.get("https://formy-project.herokuapp.com/form");
    }
    @Test
    void getStates()
    {
        WebElement radio = driver.findElement(By.id("radio-button-3"));
        assertTrue(radio.isDisplayed());
        radio.click();
        assertTrue(radio.isSelected());
    }
    @Test
    void readInputField()
    {
        WebElement first = driver.findElement(By.id("first-name"));
        first.sendKeys("Anthony");
        String name = first.getAttribute("value");
        assertEquals("Anthony", name);
    }
}

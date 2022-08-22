package Tests;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Relative_Locators extends BaseTest
{
    @BeforeEach
    void setUp()
    {
    driver.get("https://automationbookstore.dev/");
    }
    @Test
    void test1()
    {
        String id = driver
                .findElement(RelativeLocator.with(By.tagName("li"))
                        .toLeftOf(By.id("pid6"))
                        .below(By.id("pid1")))
                        .getAttribute("id");
        assertEquals("pid5", id);

    }
    @Test
    void test2()
    {
        String id = driver
                .findElement(RelativeLocator.with(By.tagName("li"))
                        .toRightOf(By.id("pid1"))
                        .above(By.id("pid6")))
                        .getAttribute("id");
        assertEquals("pid2", id);
    }

}

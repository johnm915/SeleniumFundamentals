package HomeWork;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class H5 extends BaseTest
{
    @BeforeEach

    //Open the following page in Chrome: http://opencart.abstracta.us/index.php
    void SetUp() {
        driver.get("http://opencart.abstracta.us/index.php");
    }
    @Test
    void test()
    {
        //Press the Phones & PDAs link
 //Click on the List button above

        driver.findElement(By.partialLinkText("PDAs")).click();
        driver.findElement(By.id("list-view")).click();

        //In the Sort By: dropdown, select
        //    Price (High > Low)
        Select s = new Select(driver.findElement(By.id("input-sort")));
        s.selectByVisibleText("Price (High > Low)" );

        //Verify that the first item price is $337.99
        WebElement price = driver.findElement(By.xpath
                ("//div[2]/div[1]/div[1]/div[2]/div[1]/p[2]"));
        assertTrue(price.getText().contains("$337.99"));

    }
}

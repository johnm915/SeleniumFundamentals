package Tests;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Links extends BaseTest
{
    @BeforeEach
    void setUp()
    {
        driver.get("http://opencart.abstracta.us/");
    }

    @Test
     void testingLinks()
    {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int i = 0;

        for (WebElement link: links)
            System.out.println(++i + "." + link.getText() + " = " + link.getAttribute("href"));
    }
    @Test
    void getPageHtml()
    {
        String html = driver.getPageSource();
        System.out.println("/n" + html);
    }

}

package HomeWork;

import common.BaseTest;
import org.asynchttpclient.request.body.generator.ByteArrayBodyGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Open the Target site in Chrome: https://www.target.com/
Press the link Registry
Press on the button Find a registry
Check that you are on the right page Search Results : Gift Registry
: Target, and that the string Find a registry is present
 */

public class H1 extends BaseTest {
    @BeforeEach
    void setUp() {
        driver.get("https://www.target.com/");
    }

    @Test
    void target() throws InterruptedException {
        driver.findElement(By.linkText("Registry")).click();
        driver.findElement(By.xpath("//div[3]/div[1]/div[2]/button[1]")).click();
        assertEquals("Search Results : Gift Registry : Target", driver.getTitle());


        String header = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Find a registry", header);
        Thread.sleep(3000);
    }

    @AfterEach
    void tearDown()
    {
        driver.quit();
    }


}
       ////div[1]/div[3]/div[1]/div[2]/button[1]
       ////div[3]/div[1]/div[2]/button[1]

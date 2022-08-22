package Tests;

import common.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class NewTabWindow extends BaseTest
{
    private String SeleniumWindowTitle = "Selenium";
    private String JunitTabTitle = "JUnit5";
    private String MavenWindowTitle = "Maven - Welcome to Apache Maven";

    @BeforeEach
    void setUp()
    {
        driver.get("https://www.selenium.dev/");

    }
    @Test
    void test() throws InterruptedException
    {
        String seleniumHandle = driver.getWindowHandle();
        //System.out.println(seleniumHandle);

        //open new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://junit.org/junit5/");
        String jUnit5Handle = driver.getWindowHandle();

        //open new browser
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://maven.apache.org/");
        String mavenHandle = driver.getWindowHandle();
        System.out.println(driver.getTitle());

        //Switching by window handles
        driver.switchTo().window(jUnit5Handle);
        Thread.sleep(2000);
        driver.switchTo().window(seleniumHandle);
        Thread.sleep(2000);
        driver.switchTo().window(mavenHandle);

        //switching by window titles
        switchTo(JunitTabTitle);
        Thread.sleep(3000);
        switchTo(MavenWindowTitle );
        Thread.sleep(3000);
        switchTo(SeleniumWindowTitle);
        Thread.sleep(3000);

    }

    private void switchTo(String windowTitle)
    {
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle: allWindows)
        {

            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(windowTitle));
            {
            System.out.println(windowTitle);
            break;
            }
       }

    }
    @AfterEach
    void tearDown()
    {
        driver.quit();
    }
}

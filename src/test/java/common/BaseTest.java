package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest
{
    protected WebDriver driver;

    @BeforeAll
    static void oneTimeSetUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach

    void setUpBase(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }
}

package Tests;

import common.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;


public class ScreenShot extends BaseTest
{
    @BeforeEach
    void setUp(){
        driver.get("https://www.selenium.dev/");
    }
    @Test
    void getScreenShot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("selenium.png"));


    }



}

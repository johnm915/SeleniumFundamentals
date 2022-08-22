package Tests;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class WorkingWithAlerts extends BaseTest
{
    @BeforeEach
    void setup()
    {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    void jsAlert()
    {
        driver.findElement(By.xpath("//ul[1]/li[1]/button[1]")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
    @Test
        void jsConfirm()
        {
            driver.findElement(By.xpath("//ul[1]/li[2]/button[1]")).click();
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
}

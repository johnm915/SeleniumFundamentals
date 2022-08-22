package Tests;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Locators extends BaseTest
{
    @BeforeEach
    void setUp(){
        driver.navigate().to("http://opencart.abstracta.us/");
    }

    @Test
    void locators() throws InterruptedException {
      //  Thread.sleep(3000);

        //className
        driver.findElement(By.className("swiper-button-next")).click();
        Thread.sleep(3000);

        //name
        driver.findElement(By.name("search")).sendKeys("MacBook");
        Thread.sleep(3000);

        //id
        driver.findElement(By.id("cart-total")).click();

        //CSS selectors
        driver.findElement(By.cssSelector(".btn.btn-default.btn-lg")).click();

        //link test
        driver.findElement(By.linkText("Your Store")).click();

        //partial link test
        driver.findElement(By.partialLinkText("PDAs")).click();

        //tagName
        String body = driver.findElement(By.tagName("body")).getText();
        System.out.println(body);

        //xPath
        driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div[2]/button[1]/span[1]")).click();
        Thread.sleep(5000);


        //xPath
        //*[@id="content"]/div[2]/div[1]/div/div[2]/div[2]/button[1]/span
        //*[@id="content"]/div[2]/div[1]/div/div[2]/div[2]/button[1]/span
        //div[1]/div[1]/div[2]/div[2]/button[1]/span[1]
        //div[1]/div[2]/div[2]/button[1]/span[1]


    }
}

package Tests;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class WorkingWithActions extends BaseTest
{
    private Actions builder;
    @BeforeEach
    void setUp()
    {
        builder = new Actions(driver);
    }


    @Test
    void hoverOver()
    {
        driver.get("https://the-internet.herokuapp.com//hovers");
        WebElement name = driver.findElement(By.xpath("//div[1]/div[1]/h5[1]"));
        System.out.println(name.isDisplayed());
        WebElement imageOne = driver.findElement(By.xpath("//div[1]/div[1]/img[1]"));

        builder.moveToElement(imageOne).perform();
        System.out.println(name.isDisplayed());
    }
    @Test
    void moverMouseWithOffset()
    {
        driver.get("https://www.webminal.org/");
        WebElement button = driver.findElement(By.linkText("Register"));
        int buttonX = button.getLocation().getX();
        int buttonY = button.getLocation().getY();

        builder.moveByOffset(buttonX +6, buttonY + 6)
                .click()
                .perform();
        assertEquals("join", driver.findElement(By.xpath("//h2[1]")).getText());
    }
    @Test
    void dragAndDrop() throws InterruptedException
    {
        driver.get("https://demoqa.com/droppable/");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        builder.dragAndDrop(source,target).perform();

        Thread.sleep(3000);
        assertEquals("Dropped!", target.getText());
    }

    @Test
    void dragByOffset() throws InterruptedException
    {
        driver.get("https://demoqa.com/droppable/");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        int xSource = source.getLocation().getX();
        int ySource = source.getLocation().getY();

        int xTarget = source.getLocation().getX();
        int yTarget = source.getLocation().getY();

        int xMove = xTarget - xSource + 11;
        int yMove = yTarget - ySource + 11;

        builder.dragAndDropBy(source, xMove,yMove).perform();
        Thread.sleep(3000);
        assertEquals("Dropped!", target.getText());
    }


}



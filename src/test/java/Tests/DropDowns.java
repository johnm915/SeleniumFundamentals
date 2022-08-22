package Tests;

import common.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDowns extends BaseTest {
    @BeforeEach
    void setUp() {
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

    }

    @Test
    void testDropDowns() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.name("dropdown"));
        Select s = new Select(dropdown);
       // s.selectByVisibleText("dropdown Item 6");
        s.selectByIndex(1);

        String optionSelected = s.getFirstSelectedOption().getText();
        System.out.println("currently selected option is" + " " + optionSelected);

        List<WebElement> options =  s.getOptions();
        for(WebElement option: options)
            System.out.println(option.getText());
        Thread.sleep(3000);
    }
    @Test
    void testMultiSelect() throws InterruptedException {
        WebElement multi = driver.findElement(By.name("multipleselect[]"));
        var s = new Select(multi);
        s.deselectAll();
        s.selectByIndex(0);
        s.selectByIndex(1);
        Thread.sleep(3000);
    }

    @AfterEach

    void tearDown(){

        driver.quit();

    }
}

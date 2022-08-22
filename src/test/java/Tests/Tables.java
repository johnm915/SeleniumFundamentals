package Tests;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tables extends BaseTest
{
    @BeforeEach
    void setUp(){
        driver.get("https://the-internet.herokuapp.com/tables");
    }
    @Test
    void test(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[2]/tbody/tr"));
        int numberOfRows = rows.size();
        System.out.println("The number of rows in the table 2 is " + numberOfRows);
//1
        System.out.println("\n1st Method");
        for(WebElement row: rows){
            System.out.println(row.getText().split(" ")[3]);
            System.out.println(row.getText().split(" ")[0]);
        }
//2
        System.out.println("\n2nd Method");
        String cellPath = "";
        for(int i =1; i <= numberOfRows;i++)
        {
         cellPath = "//table[2]/tbody[1]/tr[" + i +"]/td[4]";
            System.out.println(driver.findElement(By.xpath(cellPath)).getText());
        }
    }
}
//table[2]/tbody[1]/tr[1]/td[4]
//table[2]/tbody[1]/tr[2]/td[4]
//table[2]/tbody[1]/tr[3]/td[4]
//table[2]/tbody[1]/tr[f]/td[4]
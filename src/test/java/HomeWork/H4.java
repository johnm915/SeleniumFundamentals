package HomeWork;

import common.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class H4 extends BaseTest {
    private String givenHeader = "Email";

    @BeforeEach
    void SetUp() {
        //driver.get("https://demoqa.com/webtables");
        //Or
        String URL = "https://demoqa.com/webtables";
        driver.get(URL);

    }

    @Test
    void getColum() {
        int givenColum = 0;
        int currentColum = 1;

        List<WebElement> headers = driver.findElements(By.xpath("//div[3]/div[1]/div[1]/div[1]/div"));
        for (WebElement header: headers)
        {
            String columHeader = header.getText();
            System.out.println(header.getText());
            if(columHeader.equals(givenHeader))
                givenColum = currentColum;
            else
                currentColum++;
        }
        System.out.println("given colum number is " + givenColum);
        for (int i = 1; i <= 3; i++)
            System.out.println(driver.findElement(By.xpath
                    ("//div[3]/div[1]/div[2]/div["+ i + "]/div[1]/div["+ givenColum + "]")).getText());
    }
    @AfterEach
    void tearDown()
    {
        driver.quit();
    }
}


//div[3]/div[1]/div[2]/div[1]/div[1]/div[6]
//div[3]/div[1]/div[2]/div[2]/div[1]/div[6]
//div[3]/div[1]/div[2]/div[3]/div[1]/div[6]
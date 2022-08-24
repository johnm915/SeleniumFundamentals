package HomeWork;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;

public class H5 extends BaseTest
{
    @BeforeEach
    void SetUp() {
        driver.get("http://opencart.abstracta.us/index.php");


    }
}
/*
Open the following page in Chrome: http://opencart.abstracta.us/index.php

• Press the Phones & PDAs link

• Click on the List button above

    HTC Touch HD

• In the Sort By: dropdown, select

    Price (High > Low)

• Verify that the first item price is $337.99
 */
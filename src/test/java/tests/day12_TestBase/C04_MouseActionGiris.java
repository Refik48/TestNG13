package tests.day12_TestBase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

public class C04_MouseActionGiris extends TestBaseClass {

    @Test
    public void test() {
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
    }
}

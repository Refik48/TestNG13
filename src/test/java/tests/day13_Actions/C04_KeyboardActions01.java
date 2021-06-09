package tests.day13_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseMethod;

public class C04_KeyboardActions01 extends TestBaseMethod {
    /*
        1- Bir Class olusturalim D14_KeyboardActions1
        2- https://www.amazon.com sayfasina gidelim
        3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        4- aramanin dogru yapildigini test edin
     */
    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        WebElement searchSubmit = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        actions.
                click(searchBox).
                sendKeys("samsung ").
                keyDown(Keys.SHIFT). // keyDown (): Klavyede tusa basma islemi gerceklestirir
                sendKeys("a").
                keyUp(Keys.SHIFT). // keyUp (): Klavyede tusu serbest birakma islemi gerceklestirir
                sendKeys("71").
                click(searchSubmit).
                perform();
        // Aramanin dogru oldugunu title, url, aramalardan vs. kontrol edebilirim
        // 4- aramanin dogru yapildigini test edin

        String actualTitle = driver.getTitle();
        String expectedTitle = "samsung A71";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        // equals yaparsam birebir ayni mi diye bakar.
    }
}

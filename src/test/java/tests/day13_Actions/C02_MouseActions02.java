package tests.day13_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseMethod;

public class C02_MouseActions02 extends TestBaseMethod {
    /*
        Yeni bir class olusturalim: D14_MouseActions2
        1- https://demoqa.com/droppable adresine gidelim
        2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */
    @Test
    public void test01(){
        // 1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement tasinacakElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement tasinacakHedef = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(tasinacakElement,tasinacakHedef).perform();

        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement dropedYazisiWebelementi = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualDroppedYazisi = dropedYazisiWebelementi.getText();
        String expectedDroppedYazisi = "Dropped!";
        Assert.assertEquals(actualDroppedYazisi,expectedDroppedYazisi);
    }
}

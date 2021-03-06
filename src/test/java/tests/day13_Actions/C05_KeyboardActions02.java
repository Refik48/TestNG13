package tests.day13_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBaseMethod;

public class C05_KeyboardActions02 extends TestBaseMethod {
    /*
        1- Bir Class olusturalim D14_KeyboardActions2
        2- https://html.com/tags/iframe/ sayfasina gidelim
        3- video’yu gorecek kadar asagi inin
        4- videoyu izlemek icin Play tusuna basin
        5- videoyu calistirdiginizi test edin
     */

    @Test
    public void test01() throws InterruptedException {
        // 2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        // 3- video’yu gorecek kadar asagi inin

        Actions actions = new Actions(driver);
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();

        // 4) videoyu izlemek icin Play tusuna basin
        // iframe oldugu icin once iframe icine girmem gerekiyor.
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iFrame);
        WebElement youtubeVideoWE = driver.
                findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        actions.click(youtubeVideoWE).perform();

        // 5- videoyu calistirdiginizi test edin
        // Videoyu calistirdigimizi nasil test ederiz ?
        // Video calismaya
    }
}

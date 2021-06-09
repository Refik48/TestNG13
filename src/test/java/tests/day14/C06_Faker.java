package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

public class C06_Faker extends TestBaseClass {
    /*
        1."https://facebook.com" Adresine gidin
        2.“create new account” butonuna basin
        3.“firstName” giris kutusuna bir isim yazin
        4.“surname” giris kutusuna bir soyisim yazin
        5.“email” giris kutusuna bir email yazin
        6.“email” onay kutusuna emaili tekrar yazin
        7.Bir sifre girin
        8.Tarih icin gun secin
        9.Tarih icin ay secin
        10.Tarih icin yil secin
        11.Cinsiyeti secin
        12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        13.Sayfayi kapatin
     */
    @Test
    public void test01() {
        // 1."https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        // 2.“create new account” butonuna basin
        WebElement createAccountButton = driver.
                findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        createAccountButton.click();

        // 3.“firstName” giris kutusuna bir isim yazin
        WebElement isimBox = driver.findElement(By.name("firstname"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String fakeMail = faker.internet().emailAddress();
        // Kaydolurken 2. defa ayni maili girmemizi istedigi icin oncesinde String'e atatim.
        actions.
                click(isimBox).sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(fakeMail). // Ayni maili 2 kez kullandigimiz icin String'e atadik.
                sendKeys(Keys.TAB).
                sendKeys(fakeMail). // Ayni maili 2 kez kullandigimiz icin String'e atadik.
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB). // Tarihe gecmek icin 2 tab istiyor.
                sendKeys("6").
                sendKeys(Keys.TAB).
                sendKeys("May").
                sendKeys(Keys.TAB).
                sendKeys("1996").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT). // Erkege gecis yaptik
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

    }
}

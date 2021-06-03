package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_Dropdown01 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        // driver.close();
    }
    /*
        ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        4.Tüm dropdown değerleri(value) yazdırın
        5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
     */

    @Test
    public void dropDownTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // dropdown'i kullanabilmek icin 3 asama yapmamiz gerekir.
        // 1. Asama = Dropdown'u locate etmek.
        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));

        // 2.asama = Yeni Select objesine locate ettigimiz dropdown'u parametre olarak ekliyoruz.
        Select dropdownListe = new Select(dropdownMenu);

        // 3. asama = Dropdown icin kullanilan 3 yontemden biriyle dropdown menusundeki
        //        elemanlardan istediginizi seciniz. Asagida a), b), c) seklinde yontemler yazildi.

        // a) 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        dropdownListe.selectByIndex(1);
        // Bunu bir Array olarak dusunecegiz birinci secenek icin 0.(sifirinci) index manasinda 0 yazacagim.
        // burada istenen Secek 1 oldugu icin 1 yaziyorum (Cunku 1. indexte)
        System.out.println("listeden : " + dropdownListe.getFirstSelectedOption().getText()); // Option 1
        System.out.println("get text : " + dropdownMenu.getText()); // Listenin butun hali
    }

    @Test
    public void degerKullanma() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement acilirListe = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(acilirListe);
        // b) 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        // Parantez icerisine yazdigimiz sey incele'de sectigimin value karsiligidir. Index degil.

        System.out.println(select.getFirstSelectedOption().getText()); // Option 2
        // "select objesi ile git secileni bul ve oradaki text'i getir" diyorum.
    }

    @Test
    public void gorunurIsim() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // c) 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement acilirListe = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(acilirListe);
        select.selectByVisibleText("Option 1"); // Bu yontem de ise sececegimiz seyin ismini yaziyoruz.
        System.out.println(select.getFirstSelectedOption().getText());
    }

    @Test
    public void tumListe() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // 4.Tüm dropdown değerleri(value) yazdırın
        WebElement acilirListe = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(acilirListe);
        // getOptions method'u WebElementler'den olusan bir Liste dondurur o yuzden Listeye koyacagim.
        List<WebElement> tumOpsiyonlar = select.getOptions();
        for (WebElement w : tumOpsiyonlar) {
            System.out.println(w.getText());
        }
        System.out.println("Dropdown'daki web element sayisi : " + tumOpsiyonlar.size());
    }
}

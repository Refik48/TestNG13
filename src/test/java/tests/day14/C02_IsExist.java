package tests.day14;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_IsExist {
    @Test
    public void test01() {
        // Masaustundeki flower dosyasinin oldugunu test ediniz (Derste indirdigimiz resim dosyasi)

        // 1) Main path'i String olarak kaydedelim
        String mainPath = System.getProperty("user.home");

        // 2) Dosya yolunu String olarak kaydedelim
        String dosyaYolu = mainPath + "\\Desktop" + "\\FLOWER.jpg";
        System.out.println(dosyaYolu); // C:\Users\nihat\Desktop\FLOWER.jpg

        // 3) Assertion yapalim
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        // String oldugu icin direkt kullanilamiyor,
        // burada Files.exists(Paths.get(dosyaYolu)) bu kodu yazmaliyiz kontrol icin.

    }
}

package tests.day14;

import org.testng.annotations.Test;

public class C01_BilgisayardakiDosyalaraUlasma {

    @Test
    public void test01() {
        // System.getProperty("user.dir"); // icinde oldugumuz projenin bilgisayardaki yolunu verir.
        System.out.println(System.getProperty("user.dir")); // C:\Users\nihat\IdeaProjects\com.testNG13

        // System.getProperty("user.home"); // kullandigimiz bilgisayarin main path'ini verir.
        System.out.println(System.getProperty("user.home")); // C:\Users\nihat

        // Bir dosyaya dinamik olarak uslabilmek icin

        // Masaustune ulasmak istiyorsam
        String masaUstuDosyaYolu = System.getProperty("user.home") + "\\Desktop";
        System.out.println(masaUstuDosyaYolu); // C:\Users\nihat\Desktop

    }
}

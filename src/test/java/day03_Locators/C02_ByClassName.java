package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        // amazon a gidip nutella için arama yapın
        // ilk sayfada çıkan ürünlerin içerisinde
        //en yüksek fiyatı bulun

        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.name("field-keywords"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        List<WebElement>fiyatlarListesi=driver.findElements(By.className("a-price-whole"));
            //webElement bir obje olduğundan direk yazdırılamaz
        System.out.println(fiyatlarListesi);
        // bunun için bir for each loop kullanarak
        // her bir web element üzerindeki yazıları tek tek yazdırmalıyız
        String fiyatStr;
        Integer fiyatint;
        Integer enYuksekFiyat = 0;
        for (WebElement each:fiyatlarListesi
             ) {
            fiyatStr = each.getText();
            fiyatint=Integer.parseInt(fiyatStr);
            System.out.print(fiyatint+" ");

            if (fiyatint>enYuksekFiyat){
                enYuksekFiyat=fiyatint;
            }
        }
        //en yüksek fiyatı bulabilmek için java bilgimizi kullanmalıyız
        // 1---web elementlerden getTex ile fiyatı String olarak alıp 
        // 2---string fiyatı kıyaslamak için integer a çevirin
        // 3---en yüksek fiyatı bulup yazdırın
        System.out.println();
        System.out.println("en yüksek fiyat: "+enYuksekFiyat+ " $");


        Thread.sleep(3000);
        driver.quit();

    }
}

package day05_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver  driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //2- arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi=driver.findElement(By.xpath("//span[text()='1-16 of 246 results for']"));
        System.out.println(sonucSayisi.getText());
        driver.findElement(By.xpath("(//div[@class='sg-col sg-col-4-of-12 sg-col-4-of-" +
                                    "16 sg-col-4-of-20 s-list-col-left'])[1]")).click();
        driver.navigate().back();
        //6- Sayfadaki tum basliklari yazdiralim
        List<WebElement>basliklarWebElemtiListesi=driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));
        for (WebElement each:basliklarWebElemtiListesi
             ) {
            System.out.println(each.getText());
        }


        Thread.sleep(4000);
        driver.close();


    }
}

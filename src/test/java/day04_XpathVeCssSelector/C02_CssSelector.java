package day04_XpathVeCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
       //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
       //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();
       //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedTitle="Spend less";
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title testi passed");
        }else {
            System.out.println("Title testi failed");
        }
       //6- Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();
       //7- Birthday butonuna basin
     driver.findElement(By.xpath("//a[@aria-label='Birthday']")).click();


       //8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//li[@class='a-carousel-card acswidget-carousel__card'])[1]")).click();
       //9- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();
       //10-Urun ucretinin 25$ oldugunu test edin
        String actualyUcretTexti=driver.findElement(By.xpath("(//span[text()='$25.00'])[1]")).getText();
        String expectedUcretTexi="$25.00";

        if (actualyUcretTexti.equals(expectedUcretTexi)){
            System.out.println("urun 25$ testi passed");
        }else {
            System.out.println("urun 25$ testi failed");
        }
        //11-Sayfayi kapatin

        Thread.sleep(2000);
        driver.quit();
    }
}

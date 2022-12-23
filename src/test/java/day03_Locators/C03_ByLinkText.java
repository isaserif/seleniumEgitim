package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLinkText {
    public static void main(String[] args) throws InterruptedException {
        // amazon ana sayfasına gidin
        // gift cards linkini tıklayın
        // gift cards sayfasına gittiğini test edin

        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        Thread.sleep(4000);
        WebElement giftCardLinki=driver.findElement(By.partialLinkText("Gift"));
        giftCardLinki.click();


        // istenen sayfaya gidildiğini test etmek için
        // title in Gift Card içerdiğini test edebiliriz.
        String expectedKelime="Gift Cards";
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        if (actualTitle.contains(expectedKelime)){
            System.out.println("Gift Cards Test passed");
        }else {
            System.out.println("Gift Cards Test Failed");
        }



Thread.sleep(3000);
        driver.quit();
    }
}

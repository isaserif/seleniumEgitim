package day02_driverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DriverMangeMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //implicitlyWait: gittiğimiz sayfa acılıncaya kadar veya aradığımız elemnt bulununcaya kadar
        // driver in bekleyebileceği mav sureyi belirler.

        driver.navigate().to("https://www.amazon.com");


        Thread.sleep(2000);
        driver.quit();
    }
}

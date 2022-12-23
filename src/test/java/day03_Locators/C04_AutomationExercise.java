package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AutomationExercise {
    // https://www.automationexercises.com/ adresine gidin
    //Sayfada 147 adet link olduğunu test edin
    // sayfayı kapatın
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.automationexercise.com/");
        List<WebElement>linkListesi=driver.findElements(By.tagName("a"));
        System.out.println(linkListesi);
        if (linkListesi.size()==147){
            System.out.println("link listesi passed");
        }else {
            System.out.println("lik listesi failed");
        }

        // Products linkine tıklayın
       driver.findElement(By.partialLinkText("Products")).click();
        Thread.sleep(5000);

        //specialoffer yazısının göründüğünü test edin
        WebElement specialoffer=driver.findElement(By.id("sale_image"));
            if (specialoffer.isDisplayed()){
                System.out.println("pass");
            }else {
                System.out.println("failed");
            }
        /*
        NoSuchElementException driver findElement ile
         aradığı bir elemeti bulamazsa oluşur
         */
Thread.sleep(3000);
        driver.quit();
    }
}
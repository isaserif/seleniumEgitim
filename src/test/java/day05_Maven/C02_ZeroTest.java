package day05_Maven;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class C02_ZeroTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com/");
//2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
//3. Login alanine  “username” yazdirin
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginButton.sendKeys("username");
//4. Password alanine “password” yazdirin
        WebElement passwordButton = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordButton.sendKeys("password");
//5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();
//6. Pay Bills sayfasina gidin
        // bu sayfaya gidebilmek için önce online bakingg clik yapmalıyız
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
//7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amaountKutusu = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amaountKutusu.sendKeys("50");
//8. tarih kismina “2020-09-10” yazdirin
        WebElement tarihKutusu = driver.findElement(By.xpath("//input[@id='sp_date']"));
        tarihKutusu.sendKeys("2020-09-10");
        Thread.sleep(1000);
//9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
//10. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        if (sonucYazisi.isDisplayed()) {
            System.out.println("sonuc yazisi testi passed");
        } else {
            System.out.println("sonuc yazisi testi failed");
        }
        Thread.sleep(3000);
        driver.close();
    }
}

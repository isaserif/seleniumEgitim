package day04_XpathVeCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C04_team3Calismasi {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html  adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        WebElement byArea=driver.findElement(By.xpath("//*[text()='Bay Area']"));

        WebElement berlin1= driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(byArea));
        berlin1.click();
        WebElement portland=driver.findElement(RelativeLocator.with(By.tagName("img")).above(byArea));
        portland.click();







Thread.sleep(2000);
//driver.quit();


    }
}

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GoogleTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void testYandexSite () {
        driver.manage().window().maximize();
        driver.get("https://yandex.ru/");
        driver.findElement(By.id("text")).sendKeys("Сейчас будем кликать мышкой на яндекс-маркет");
        driver.findElement(By.cssSelector("[data-id=market]")).click();
        driver.findElement(By.cssSelector("[class^=button2][class*=button2_size_m][class*=n-region-notification__ok]")).click(); //подтверждение региона, который у меня выскакивает при открытии маркета
        driver.findElement(By.xpath("//span[@class='n-w-tab__control-caption'][text()='Компьютерная техника']")).click();
        driver.findElement(By.xpath("//a[text()='Ноутбуки']")).click();
    }

    @After
    public void stop (){
        driver.quit();
        driver = null;
    }
}

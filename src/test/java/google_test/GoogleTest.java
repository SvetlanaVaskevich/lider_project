package google_test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleTest {
    public static WebDriver driver;

    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector("input[name=q]")).sendKeys("купить кофемашину bork c804");
        driver.findElement(By.cssSelector("input[name=q]")).sendKeys(Keys.ENTER);
        Thread.sleep(500);
        String count = driver.findElement(By.cssSelector("#extabar #result-stats")).getText();
        System.out.println(count);
        List<WebElement> b = driver.findElements(By.cssSelector("a h3"));
        boolean isMvideo = false;
        for (int i = 0; i < b.size(); i++) {
            System.out.println(b.get(i).getText());
            if(b.get(i).getText().contains("М.Видео")){
                isMvideo = true;
                break;
            }
        }
        Assertions.assertTrue(isMvideo,"М-Видео нет в результатх поиска");

    }
    @AfterAll
    public static void close(){
        driver.quit();
    }

}

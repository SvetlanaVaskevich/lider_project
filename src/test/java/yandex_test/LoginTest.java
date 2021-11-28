package yandex_test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static WebDriver driver;

    By enter = By.cssSelector("a[class*='HeadBanner-Button-Enter with-shadow']");
    By login = By.cssSelector("#passp-field-login");
    By buttonLogin = By.cssSelector("div[class*='passp-sign-in-button'] button");
    By password = By.cssSelector("#passp-field-passwd");
    By buttonPassword = By.cssSelector("div[class*='passp-sign-in-button'] button");
    By menu = By.cssSelector("div[class*='legouser_hidden_yes i-bem']");
    By loginName = By.cssSelector("div[class*='legouser_hidden_yes i-bem']>:nth-of-type(1) span");
    By exit = By.cssSelector("a[class*='legouser__menu-item_action_exit']");


    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test() {
        driver.get("https://mail.yandex.ru/");
        driver.findElement(enter).click();
        driver.findElement(login).sendKeys("Svetlana-Vch");
        driver.findElement(buttonLogin).click();
        driver.findElement(password).sendKeys("251121.Date");
        driver.findElement(buttonPassword).click();
        driver.findElement(menu).click();
        String result = driver.findElement(loginName).getText();
        Assertions.assertEquals("Svetlana-Vch",result);
        driver.findElement(exit).click();
    }

    @AfterAll
    public static void close(){
        driver.quit();
    }
}


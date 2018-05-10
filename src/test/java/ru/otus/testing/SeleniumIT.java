package ru.otus.testing;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumIT {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/JavaEE/chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "C:/JavaEE/geckodriver.exe");
//        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void shouldTestOpenBrowse() {
        // Открываем гугл, используя драйвер
        driver.get("http://www.google.com");
        // По-другому это можно сделать так:
        // driver.navigate().to("http://www.google.com");

        // Находим элемент по атрибуту name
        WebElement element = driver.findElement(By.name("q"));

        // Вводим текст
        element.sendKeys("Selenium");

        // Отправляем форму, при этом дравер сам определит как отправить форму по элементу
        element.submit();

        // Страницы гугл динамически отрисовывается с помощью javascript
        // Ждем загрузки страницы с таймаутом в 10 секунд

        new WebDriverWait(driver, 10).until(webDriver ->
                webDriver.getTitle().toLowerCase().startsWith("selenium"));

        // Закрываем браузер
        driver.quit();
    }
}


import com.google.common.util.concurrent.ListenableFuture;
import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class TestMts {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeEach
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        acceptCookie();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    private void acceptCookie() {
        try {
            WebElement cookie = wait.until(ExpectedConditions.elementToBeClickable
                    (By.xpath("//button[contains(text(),'Принять')]")));
            cookie.click();
        } catch (Exception e) {
            System.out.println("Модальное окно 'Обработка файлов cookie' не появилось ");
        }
    }


    @Test
    public void TestTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='pay__wrapper']/h2")));

        Assertions.assertTrue(title.getText().contains("Онлайн пополнение"), "Название блока не соответствует");
    }

    @Test
    public void TestPaymentImg() {
        List<WebElement> payments = driver.findElements(By.xpath("//div[@class='pay__partners']/ul/li/img"));
        for (WebElement s : payments) {
            String src = s.getAttribute("src");
            Assertions.assertNotNull(src, "Атрибут src не должен быть null");
            Assertions.assertTrue(src.contains(".svg"), "Логотип должен быть формата SVG");
        }
    }

    @Test
    public void TestLink() {
        WebElement link = driver.findElement(By.xpath("//div[@class='pay__wrapper']//child::a"));
        link.click();
        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Ссылка не работает");
    }

    @Test
    public void continueButton() {
        WebElement FieldNumber = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        FieldNumber.click();
        FieldNumber.sendKeys("297777777");

        WebElement FieldPay = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        FieldPay.click();
        FieldPay.sendKeys("5");

        WebElement FieldEmail = driver.findElement(By.xpath("//input[@id='connection-email']"));
        FieldEmail.click();
        FieldEmail.sendKeys("test@gmail.com");

        WebElement ContinueButton = driver.findElement(By.xpath("//form[@class='pay-form opened']/button"));
        ContinueButton.click();

        WebElement modalPay = wait.until(visibilityOfElementLocated(By.xpath("//div[@class='bepaid-app']")));
        Assertions.assertTrue(modalPay.isDisplayed(), "Кнопка 'Продолжить' не работает.");


    }


}


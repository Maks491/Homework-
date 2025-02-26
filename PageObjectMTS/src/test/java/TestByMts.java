import com.github.dockerjava.api.model.Link;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestByMts {

    private WebDriver driver;
    private MtsForm mtsForm;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mtsForm = new MtsForm(driver);
        mtsForm.acceptCookie();


    }

    @AfterEach
    public void tearDown() {
        driver.quit();


    }

    @Test
    public void TestTitle() {
        Assertions.assertTrue(mtsForm.getTitle().contains("Онлайн пополнение"),
                "Название блока не соответствует");

    }

    @Test
    public void TestLogoPayment() {
        for (WebElement s : mtsForm.getTestLogoPayment()) {
            String src = s.getAttribute("src");
            Assertions.assertNotNull(src, "Атрибут src не должен быть null");
            Assertions.assertTrue(src.contains(".svg"), "Логотип должен быть формата SVG");
        }

    }

    @Test
    public void TestLink() {
        mtsForm.ClickLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        Assertions.assertTrue(driver.getCurrentUrl().contains
                ("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"), "Ссылка не работает");
    }


    @Test
    public void continueButtonTest() {
        mtsForm.enterPhoneNumber("297777777");
        mtsForm.enterSum("5");
        mtsForm.enterEmail("test@gmail.com");
        mtsForm.clickContinue();
        Assertions.assertTrue(mtsForm.displayedModalPay(), "Кнопка 'Продолжить' не работает.");
    }

    @Test
    public void CheckPlaceHolderCommunicationService() {
        Assertions.assertEquals("Номер телефона", mtsForm.getPlaceHolderNumber()
                , "Неверный плейсхолдер в поле Номер");
        Assertions.assertEquals("Сумма", mtsForm.getPlaceHolderSum(),
                "Неверный плейсхолдер в поле Сумма");
        Assertions.assertEquals("E-mail для отправки чека", mtsForm.getPlaceHolderEmail(),
                "Неверный плейсхолдер в поле E-mail");

    }

    @Test
    public void checkPlaceHolderHomeInternet() {
        mtsForm.checkoutDropdownHomeInternet();
        Assertions.assertEquals("Номер абонента", mtsForm.getFieldInternetNumber(),
                "Неверный плейсхолдер в поле Номер");

        Assertions.assertEquals("Сумма", mtsForm.getFieldInternetSum(),
                "Неверный плейсхолдер в поле Сумма");

        Assertions.assertEquals("E-mail для отправки чека", mtsForm.getFieldInternetEmail(),
                "Неверный плейсхолдер в поле E-mail для отправки чека ");
    }

    @Test
    public void checkPlaceHolderInstalment() {
        mtsForm.checkoutDropdownInstalment();
        Assertions.assertEquals("Номер счета на 44", mtsForm.getFieldInstalmentNumber(),
                "Неверный плейсхолдер в поле Номер счета на 44");

        Assertions.assertEquals("Сумма", mtsForm.getFieldInstalmentSum(),
                "Неверный плейсхолдер в поле Сумма");

        Assertions.assertEquals("E-mail для отправки чека", mtsForm.getFieldInstalmentEmail(),
                "Неверный плейсхолдер в поле E-mail для отправки чека ");
    }

    @Test
    public void checkPlaceHolderArrears() {
        mtsForm.checkoutDropdownArrears();
        Assertions.assertEquals("Номер счета на 2073", mtsForm.getFieldArrearsNumber(),
                "Неверный плейсхолдер в поле 'Номер счета на 2073'");

        Assertions.assertEquals("Сумма", mtsForm.getFieldArrearsSum(),
                "Неверный плейсхолдер в поле 'Сумма'");

        Assertions.assertEquals("E-mail для отправки чека", mtsForm.getFieldArrearsEmail(),
                "Неверный плейсхолдер в поле 'E-mail для отправки чека'");
    }

    @Test
    public void checkCostModalPay() {
        mtsForm.enterPhoneNumber("297777777");
        mtsForm.enterSum("5");
        mtsForm.clickContinue();
        Assertions.assertTrue(mtsForm.getCostModalPay().contains("5.00 BYN"));

    }

    @Test
    public void checkCostButtonText() {
        mtsForm.enterPhoneNumber("297777777");
        mtsForm.enterSum("5");
        mtsForm.clickContinue();
        Assertions.assertTrue(mtsForm.getCostButton().contains("Оплатить 5.00 BYN"));

    }

    @Test
    public void checkPhoneNumberModal() {
        mtsForm.enterPhoneNumber("297777777");
        mtsForm.enterSum("5");
        mtsForm.clickContinue();
        Assertions.assertTrue(mtsForm.getPhoneNumberModal().contains("Оплата: Услуги связи Номер:375297777777"));

    }

    @Test
    public void checkFieldCardNumber() {
        mtsForm.enterPhoneNumber("297777777");
        mtsForm.enterSum("5");
        mtsForm.clickContinue();
        Assertions.assertTrue(mtsForm.getCardNumber().contains("Номер карты"));

    }

    @Test
    public void checkCardUntilDate() {
        mtsForm.enterPhoneNumber("297777777");
        mtsForm.enterSum("5");
        mtsForm.clickContinue();
        Assertions.assertTrue(mtsForm.getUntilDateCard().contains("Срок действия"));

    }

    @Test
    public void checkCardCVC() {
        mtsForm.enterPhoneNumber("297777777");
        mtsForm.enterSum("5");
        mtsForm.clickContinue();
        Assertions.assertTrue(mtsForm.getCVC().contains("CVC"));

    }

    @Test
    public void checkCardHolderName() {
        mtsForm.enterPhoneNumber("297777777");
        mtsForm.enterSum("5");
        mtsForm.clickContinue();
        Assertions.assertTrue(mtsForm.getCardHolderName().contains("Имя держателя (как на карте)"));

    }

    @Test
    public void checkModalLogos() {
        mtsForm.enterPhoneNumber("297777777");
        mtsForm.enterSum("5");
        mtsForm.clickContinue();
        List<WebElement> logos = mtsForm.getLogosInModalWindow();
        Assertions.assertFalse(logos.isEmpty(), "Логотипы не найдены!");
        for (WebElement logo : logos) {
            String src = logo.getAttribute("src");
            Assertions.assertNotNull(src, "Атрибут src не должен быть null");
            Assertions.assertTrue(src.endsWith(".svg"), "Логотип должен быть формата SVG");
        }
    }

}

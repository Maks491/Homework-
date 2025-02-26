import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MtsForm extends BaseMts {


    @FindBy(xpath = "//button[contains(text(),'Принять')]")
    private WebElement CookieButton;

    @FindBy(xpath = "//div[@class='pay__wrapper']/h2")
    private WebElement title;

    @FindBy(xpath = "//div[@class='pay__partners']/ul/li/img")
    private List<WebElement> LogoPayment;

    @FindBy(xpath = "//div[@class='pay__wrapper']//child::a")
    private WebElement link;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement fieldNumber;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement fieldSum;

    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//form[@class='pay-form opened']/button")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='bepaid-app']")
    private WebElement modalPay;

    @FindBy(xpath = "//p[@class='select__option' and contains(text(),'Домашний интернет')]")
    private WebElement selectHomeInternet;

    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement dropdown;

    @FindBy(xpath = "//input[@id='internet-phone']")
    private WebElement fieldNumberHomeInternet;

    @FindBy(xpath = "//input[@id='internet-sum']")
    private WebElement fieldSumInternetHome;

    @FindBy(xpath = "//input[@id='internet-email']")
    private WebElement fieldEmailHomeInternet;

    @FindBy(xpath = "//p[@class='select__option' and contains(text(),'Рассрочка')]")
    private WebElement selectInstalment;

    @FindBy(xpath = "//input[@id='score-instalment']")
    private WebElement fieldInstalmentNumber;

    @FindBy(xpath = "//input[@id='instalment-sum']")
    private WebElement fieldInstalmentSum;

    @FindBy(xpath = "//input[@id='instalment-email']")
    private WebElement fieldInstalmentEmail;

    @FindBy(xpath = "//p[@class='select__option' and contains(text(),'Задолженность')]")
    private WebElement selectArrears;

    @FindBy(xpath = "//input[@id='score-arrears']")
    private WebElement fieldNumberArrears;

    @FindBy(xpath = "//input[@id='arrears-sum']")
    private WebElement fieldSumArrears;

    @FindBy(xpath = "//input[@id='arrears-email']")
    private WebElement fieldEmailArrears;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span[1]")
    private WebElement costModalPay;

    @FindBy(xpath = "//button[@class='colored disabled']")
    private WebElement costButtonModalPay;

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement phoneNumberModalWindow;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-1']/child::label")
    private WebElement cardNumber;

    @FindBy(xpath = "//iframe[1]")
    private WebElement frame;

    @FindBy(xpath = "//label[@class='ng-tns-c46-4 ng-star-inserted']")
    private WebElement DateUntilCard;

    @FindBy(xpath = "//label[@class='ng-tns-c46-5 ng-star-inserted']")
    private WebElement cvc;

    @FindBy(xpath = "//label[@class='ng-tns-c46-3 ng-star-inserted']")
    private WebElement cardHolderName;

    @FindBy(xpath = "//div[contains(@class, 'cards-brands__container')]")
    private WebElement cardLogos;


    public MtsForm(WebDriver driver) {
        super(driver);
        driver.get("https://www.mts.by/");

    }

    public void acceptCookie() {
        try {

            if (wait.until(ExpectedConditions.visibilityOf(CookieButton)).isDisplayed()) {
                CookieButton.click();
            }
        } catch (Exception e) {
            System.out.println("Модальное окно 'Обработка файлов cookie' не появилось ");
        }

    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOf(title)).getText();
    }

    public List<WebElement> getTestLogoPayment() {
        return LogoPayment;
    }

    public void ClickLink() {
        link.click();

    }

    public void clickContinue() {
        continueButton.click();
    }


    public void enterPhoneNumber(String phone) {
        WebElement phoneNumber = wait.until(ExpectedConditions.elementToBeClickable(fieldNumber));
        phoneNumber.sendKeys(phone);
    }

    public void enterSum(String sum) {
        WebElement sumNumber = wait.until(ExpectedConditions.elementToBeClickable(fieldSum));
        sumNumber.sendKeys(sum);
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(fieldEmail));
        emailInput.sendKeys(email);
    }

    public boolean displayedModalPay() {
        return wait.until(ExpectedConditions.visibilityOf(modalPay)).isDisplayed();
    }

    public String getPlaceHolderNumber() {
        return wait.until(ExpectedConditions.visibilityOf(fieldNumber)).getDomAttribute("placeholder");

    }

    public String getPlaceHolderSum() {
        return wait.until(ExpectedConditions.visibilityOf(fieldSum)).getDomAttribute("placeholder");
    }

    public String getPlaceHolderEmail() {
        ;
        return wait.until(ExpectedConditions.visibilityOf(fieldEmail)).getDomAttribute("placeholder");
    }

    public void checkoutDropdownHomeInternet() {
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        dropdown.click();
        WebElement select = wait.until(ExpectedConditions.elementToBeClickable(selectHomeInternet));
        select.click();

    }

    public String getFieldInternetNumber() {
        return wait.until(ExpectedConditions.visibilityOf(fieldNumberHomeInternet)).getDomAttribute
                ("placeholder");
    }

    public String getFieldInternetSum() {
        return wait.until(ExpectedConditions.visibilityOf(fieldSumInternetHome)).getDomAttribute
                ("placeholder");
    }

    public String getFieldInternetEmail() {
        return wait.until(ExpectedConditions.visibilityOf(fieldEmailHomeInternet)).getDomAttribute
                ("placeholder");
    }


    public void checkoutDropdownInstalment() {
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        dropdown.click();
        WebElement selectInstalmetn = wait.until(ExpectedConditions.elementToBeClickable(selectInstalment));
        selectInstalmetn.click();

    }

    public String getFieldInstalmentNumber() {
        return wait.until(ExpectedConditions.visibilityOf(fieldInstalmentNumber)).getDomAttribute
                ("placeholder");
    }

    public String getFieldInstalmentSum() {
        return wait.until(ExpectedConditions.visibilityOf(fieldInstalmentSum)).getDomAttribute
                ("placeholder");
    }

    public String getFieldInstalmentEmail() {
        return wait.until(ExpectedConditions.visibilityOf(fieldInstalmentEmail)).getDomAttribute
                ("placeholder");
    }

    public void checkoutDropdownArrears() {
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        dropdown.click();
        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(selectArrears));
        checkout.click();

    }

    public String getFieldArrearsNumber() {
        return wait.until(ExpectedConditions.visibilityOf(fieldNumberArrears)).getDomAttribute
                ("placeholder");
    }

    public String getFieldArrearsSum() {
        return wait.until(ExpectedConditions.visibilityOf(fieldSumArrears)).getDomAttribute
                ("placeholder");
    }

    public String getFieldArrearsEmail() {
        return wait.until(ExpectedConditions.visibilityOf(fieldEmailArrears)).getDomAttribute
                ("placeholder");
    }

    public String getCostModalPay() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        String cost = wait.until(ExpectedConditions.visibilityOf(costModalPay)).getText();
        driver.switchTo().defaultContent();
        return cost;
    }

    public String getCostButton() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        String costButtonText = wait.until(ExpectedConditions.visibilityOf(costButtonModalPay)).getText();
        driver.switchTo().defaultContent();
        return costButtonText;
    }

    public String getPhoneNumberModal() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        String modalWindowNumber = wait.until(ExpectedConditions.visibilityOf(phoneNumberModalWindow)).getText();
        driver.switchTo().defaultContent();
        return modalWindowNumber;
    }

    public String getCardNumber() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        String FieldCardNumber = wait.until(ExpectedConditions.visibilityOf(cardNumber)).getText();
        driver.switchTo().defaultContent();
        return FieldCardNumber;
    }

    public String getUntilDateCard() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        String fieldCardUntilDate = wait.until(ExpectedConditions.visibilityOf(DateUntilCard)).getText();
        driver.switchTo().defaultContent();
        return fieldCardUntilDate;
    }

    public String getCVC() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        String CardCVC = wait.until(ExpectedConditions.visibilityOf(cvc)).getText();
        driver.switchTo().defaultContent();
        return CardCVC;

    }

    public String getCardHolderName() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        String holderName = wait.until(ExpectedConditions.visibilityOf(cardHolderName)).getText();
        driver.switchTo().defaultContent();
        return holderName;


    }

    public List<WebElement> getLogosInModalWindow() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        WebElement logos = wait.until(ExpectedConditions.visibilityOf(cardLogos));
        driver.switchTo().defaultContent();
        return wait.until(ExpectedConditions.visibilityOfAllElements(logos));
    }

}
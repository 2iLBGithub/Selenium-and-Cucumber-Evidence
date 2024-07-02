package MainDirectory.pom_files;

import MainDirectory.utilities.UtilityLibrary;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPagePOM {
    protected WebDriver driver;
    @FindBy(id = "billing_first_name")
    WebElement getFirstName;
    @FindBy(id = "billing_last_name")
    WebElement getLastName;
    @FindBy(css = "#select2-billing_country-container")
    WebElement getBillingCountry;
    @FindBy(css = "body > span > span > span.select2-search.select2-search--dropdown > input")
    WebElement getBillingCountryInput;
    @FindBy(id = "billing_address_1")
    WebElement getBillingAddressStreetAndNumber;
    @FindBy(id = "billing_city")
    WebElement getBillingCity;
    @FindBy(id = "billing_postcode")
    WebElement getBillingPostCode;
    @FindBy(id = "billing_phone")
    WebElement getBillingPhone;
    @FindBy(css = "#payment > ul > li.wc_payment_method.payment_method_cheque > label")
    WebElement paymentMethodCheque;
    @FindBy(id = "place_order")
    WebElement placeOrder;
    @FindBy(css = ".blockUI.blockOverlay")
    WebElement obstruction;

    public CheckoutPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputFirstName(String firstName) {
        UtilityLibrary.waitForElementToBeInvisible(this.driver, this.obstruction, 10);
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.getFirstName, 3);
        this.getFirstName.click();
        this.getFirstName.clear();
        this.getFirstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        UtilityLibrary.waitForElementToBeInvisible(this.driver, this.obstruction, 10);
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.getLastName, 3);
        this.getLastName.click();
        this.getLastName.clear();
        this.getLastName.sendKeys(lastName);
                }

    public void inputBillingCountry(String countryName) {
        UtilityLibrary.waitForElementToBeInvisible(this.driver, this.obstruction, 10);
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.getBillingCountry, 3);
        this.getBillingCountry.click();
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.getBillingCountryInput, 3);
        this.getBillingCountryInput.click();
        this.getBillingCountryInput.sendKeys(countryName);
    }

    public void inputBillingCity(String cityName) {
        UtilityLibrary.waitForElementToBeInvisible(this.driver, this.obstruction, 10);
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.getBillingCity, 3);
        this.getBillingCity.click();
        this.getBillingCity.clear();
        this.getBillingCity.sendKeys(cityName);
    }
    public void inputBillingAddressNameAndNumber(String address) {
        UtilityLibrary.waitForElementToBeInvisible(this.driver, this.obstruction, 10);
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.getBillingAddressStreetAndNumber, 3);
        this.getBillingAddressStreetAndNumber.click();
        this.getBillingAddressStreetAndNumber.clear();
        this.getBillingAddressStreetAndNumber.sendKeys(address);
    }

    public void inputBillingPostCode(String postcode) {
        UtilityLibrary.waitForElementToBeInvisible(this.driver, this.obstruction, 10);
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.getBillingPostCode, 3);
        this.getBillingPostCode.click();
        this.getBillingPostCode.clear();
        this.getBillingPostCode.sendKeys(postcode);
    }

    public void inputBillingPhone(String phoneNumber) {
        UtilityLibrary.waitForElementToBeInvisible(this.driver, this.obstruction, 10);
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.getBillingPhone, 3);
        this.getBillingPhone.click();
        this.getBillingPhone.clear();
        this.getBillingPhone.sendKeys(phoneNumber);

    }

    public void inputPaymentMethodCheque() {
        UtilityLibrary.waitForElementToBeInvisible(this.driver, this.obstruction, 10);
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.paymentMethodCheque, 3);
        this.paymentMethodCheque.click();
    }

    public void finaliseOrder() {
        UtilityLibrary.waitForElementToBeInvisible(this.driver, this.obstruction, 10);
        UtilityLibrary.waitForElementToBeVisible(this.driver, this.placeOrder, 3);
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.placeOrder, 3);
        this.placeOrder.click();
    }
}

package MainDirectory.pom_files;

import java.math.BigDecimal;

import MainDirectory.utilities.UtilityLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPOM {
    protected WebDriver driver;
    protected BigDecimal sumAsBigDecimal;
    protected BigDecimal postDeductionSumAsBigDecimal;
    protected BigDecimal shippingFeeAsBigDecimal;
    protected BigDecimal finalFeeAsBigDecimal;
    @FindBy(
            name = "coupon_code"
    )
    WebElement couponCodeField;
    @FindBy(
            name = "apply_coupon"
    )
    WebElement applyCoupon;
    @FindBy(
            css = "#post-5 > div > div > div.cart-collaterals > div > table > tbody > tr.cart-subtotal > td > span > bdi"
    )
    WebElement checkSubtotal;
    @FindBy(
            css = "#post-5 > div > div > div.cart-collaterals > div > table > tbody > tr.cart-discount.coupon-edgewords > td > span"
    )
    WebElement checkDeduction;
    @FindBy(
            css = "#shipping_method > li > label > span > bdi"
    )
    WebElement checkShippingFee;
    @FindBy(
            css = "#post-5 > div > div > div.cart-collaterals > div > table > tbody > tr.order-total > td > strong"
    )
    WebElement checkFinalFee;
    @FindBy(
            css = "#post-5 > div > div > div.cart-collaterals > div > div > a"
    )
    WebElement checkOut;

    public CartPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BigDecimal getSumAsBigDecimal() {
        return this.sumAsBigDecimal;
    }

    public BigDecimal getPostDeductionSumAsBigDecimal() {
        return this.postDeductionSumAsBigDecimal;
    }

    public BigDecimal getShippingFeeAsBigDecimal() {
        return this.shippingFeeAsBigDecimal;
    }

    public BigDecimal getFinalFeeAsBigDecimal() {
        return this.finalFeeAsBigDecimal;
    }

    public void setSumAsBigDecimal(BigDecimal sumAsBigDecimal) {
        this.sumAsBigDecimal = sumAsBigDecimal;
    }

    public void setPostDeductionSumAsBigDecimal(BigDecimal postDeductionSumAsBigDecimal) {
        this.postDeductionSumAsBigDecimal = postDeductionSumAsBigDecimal;
    }

    public void setShippingFeeAsBigDecimal(BigDecimal shippingFeeAsBigDecimal) {
        this.shippingFeeAsBigDecimal = shippingFeeAsBigDecimal;
    }

    public void setFinalFeeAsBigDecimal(BigDecimal finalFeeAsBigDecimal) {
        this.finalFeeAsBigDecimal = finalFeeAsBigDecimal;
    }

    public void findSubTotal() {
        String rawValue = this.checkSubtotal.getText();
        rawValue = rawValue.replaceAll("[^0-9.]", "");
        BigDecimal valueAsBigDecimal = new BigDecimal(rawValue);
        this.setSumAsBigDecimal(valueAsBigDecimal);
    }

    public BigDecimal getCouponDeduction() {
        UtilityLibrary.waitForElementToBeVisible(this.driver, this.checkDeduction, 3);
        String rawValue = this.checkDeduction.getText();
        rawValue = rawValue.replaceAll("[^0-9.]", "");
        return new BigDecimal(rawValue);
    }

    public void accessCouponCodeField(String coupon) {
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.couponCodeField, 3);
        this.couponCodeField.click();
        this.couponCodeField.sendKeys(new CharSequence[]{coupon});
    }

    public void applyCouponToCart() {
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.applyCoupon, 3);
        this.applyCoupon.click();
    }

    public void applyShippingFee() {
        UtilityLibrary.waitForElementToBeVisible(this.driver, this.checkShippingFee, 3);
        String rawValue = this.checkShippingFee.getText();
        rawValue = rawValue.replaceAll("[^0-9.]", "");
        BigDecimal valueAsBigDecimal = new BigDecimal(rawValue);
        this.setShippingFeeAsBigDecimal(valueAsBigDecimal);
    }

    public BigDecimal getFinalSum() {
        UtilityLibrary.waitForElementToBeVisible(this.driver, this.checkFinalFee, 3);
        String rawValue = this.checkFinalFee.getText();
        rawValue = rawValue.replaceAll("[^0-9.]", "");
        return new BigDecimal(rawValue);
    }

    public void goToCheckout() {
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.checkOut, 3);
        this.checkOut.click();
    }
}

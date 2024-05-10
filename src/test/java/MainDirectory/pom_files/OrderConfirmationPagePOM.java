package MainDirectory.pom_files;

import MainDirectory.utilities.UtilityLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPagePOM {
    protected WebDriver driver;
    protected String savedOrderNumber;
    @FindBy(
            css = "#post-6 > div > div > div > ul > li.woocommerce-order-overview__order.order > strong"
    )
    WebElement orderNumber;

    public OrderConfirmationPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSavedOrderNumber() {
        return this.savedOrderNumber;
    }

    public void setSavedOrderNumber(String savedOrderNumber) {
        this.savedOrderNumber = savedOrderNumber;
    }

    public String getOrderNumber() {
        UtilityLibrary.waitForElementToBeVisible(this.driver, this.orderNumber, 3);
        return this.orderNumber.getText();
    }
}

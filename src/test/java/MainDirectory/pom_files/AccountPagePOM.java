package MainDirectory.pom_files;

import java.util.List;

import MainDirectory.utilities.UtilityLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPagePOM {
    protected WebDriver driver;
    @FindBy(
            id = "username"
    )
    WebElement selectUsername;
    @FindBy(
            id = "password"
    )
    WebElement selectPassword;
    @FindBy(
            css = "#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > button"
    )
    WebElement loginButton;
    @FindBy(
            css = "li.woocommerce-MyAccount-navigation-link:nth-child(6) > a:nth-child(1)"
    )
    WebElement logOut;
    @FindBy(
            css = "#post-7 > div > div > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--orders"
    )
    WebElement goToOrders;
    @FindBy(
            css = "#post-7 > div > div > div > table > tbody > tr > td:nth-child(1)"
    )
    List<WebElement> orderNumberCells;
    @FindBy(
            css = "td[data-title='Order'] a"
    )
    WebElement orderDataCell;

    public AccountPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logOutOfSite() {
        this.logOut.click();
    }

    public void logInToSite(String username, String password) {
        UtilityLibrary.waitForElementToBeVisible(this.driver, this.selectUsername, 3);
        this.selectUsername.click();
        this.selectUsername.sendKeys(username);
        this.selectPassword.click();
        this.selectPassword.sendKeys(password);
        this.loginButton.click();
    }

    public void viewOrders() {
        UtilityLibrary.waitForElementToBeVisible(this.driver, this.goToOrders, 3);
        this.goToOrders.click();
    }

    public String checkOrderNumber() {
        String foundValue = this.orderDataCell.getText();
        String sanitisedValue = foundValue.replace("#", "");
        return sanitisedValue;
    }
}
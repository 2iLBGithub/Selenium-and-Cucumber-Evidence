package MainDirectory.pom_files;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPOM {
    protected WebDriver driver;
    @FindBy(
            css = "#menu-item-42 > a:nth-child(1)"
    )
    WebElement selectHomePage;
    @FindBy(
            id = "woocommerce-product-search-field-0"
    )
    WebElement searchBox;
    @FindBy(
            id = "menu-item-46"
    )
    WebElement accountPage;
    @FindBy(
            id = "menu-item-43"
    )
    WebElement shopPage;

    public NavigationPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String product) {
        this.searchBox.sendKeys(new CharSequence[]{product + String.valueOf(Keys.ENTER)});
    }

    public void goToAccount() {
        this.accountPage.click();
    }

    public void goToHome() {
        this.selectHomePage.click();
    }

    public void goToShop() {
        this.shopPage.click();
    }
}

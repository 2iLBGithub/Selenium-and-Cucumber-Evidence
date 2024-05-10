package MainDirectory.pom_files;

import MainDirectory.utilities.UtilityLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPOM {
    protected WebDriver driver;
    @FindBy(
            name = "add-to-cart"
    )
    WebElement addToCartButton;
    @FindBy(
            linkText = "View cart"
    )
    WebElement viewCartLink;

    public SearchResultsPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.addToCartButton, 3);
        this.addToCartButton.click();
    }

    public void viewCart() {
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.viewCartLink, 3);
        this.viewCartLink.click();
    }
}

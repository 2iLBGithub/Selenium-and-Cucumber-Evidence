package MainDirectory.pom_files;

import MainDirectory.utilities.UtilityLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPagePOM {
    protected WebDriver driver;
    @FindBy(
            css = "#main > ul > li.product.type-product.post-27.status-publish.first.instock.product_cat-accessories.has-post-thumbnail.sale.shipping-taxable.purchasable.product-type-simple > a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart"
    )
    WebElement addBeanieHatToCart;
    @FindBy(
            css = "#main > ul > li.product.type-product.post-27.status-publish.first.instock.product_cat-accessories.has-post-thumbnail.sale.shipping-taxable.purchasable.product-type-simple > a.added_to_cart.wc-forward"
    )
    WebElement viewCartPopUp;

    public ShopPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart() {
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.addBeanieHatToCart, 3);
        this.addBeanieHatToCart.click();
    }

    public void addItemToCartParameterised(String itemName) {
        String cssSelector = "[aria-label*='" + itemName + "']";
        WebElement addItemToCartButton = this.driver.findElement(By.cssSelector(cssSelector));
        UtilityLibrary.waitForElementToBeClickable(this.driver, addItemToCartButton, 3);
        addItemToCartButton.click();
    }

    public void viewCartInIcon() {
        UtilityLibrary.waitForElementToBeClickable(this.driver, this.viewCartPopUp, 3);
        this.viewCartPopUp.click();
    }
}

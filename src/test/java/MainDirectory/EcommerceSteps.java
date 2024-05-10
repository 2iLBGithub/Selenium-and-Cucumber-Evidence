package MainDirectory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.math.BigDecimal;
import MainDirectory.pom_files.AccountPagePOM;
import MainDirectory.pom_files.CartPOM;
import MainDirectory.pom_files.CheckoutPagePOM;
import MainDirectory.pom_files.NavigationPOM;
import MainDirectory.pom_files.OrderConfirmationPagePOM;
import MainDirectory.pom_files.SearchResultsPOM;
import MainDirectory.pom_files.ShopPagePOM;
import MainDirectory.utilities.pomUtilities.CartUtilityLibrary;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class EcommerceSteps {
    private SharedDictionary sharedDict;

    public EcommerceSteps(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict;
    }

    @Given("I can access the home page")
    public void i_can_access_the_home_page() {
        NavigationPOM navigation = (NavigationPOM)this.sharedDict.readDict("navigation");
        navigation.goToHome();
    }

    @When("I add an {string} to my cart")
    public void i_add_an_item_to_my_cart(String item) {
        NavigationPOM navigation = (NavigationPOM)this.sharedDict.readDict("navigation");
        SearchResultsPOM results = (SearchResultsPOM)this.sharedDict.readDict("results");
        navigation.searchFor(item);
        results.addToCart();
    }

    @When("I apply a coupon")
    public void i_apply_a_coupon() {
        SearchResultsPOM results = (SearchResultsPOM)this.sharedDict.readDict("results");
        CartPOM cartInteractions = (CartPOM)this.sharedDict.readDict("cartInteractions");
        results.viewCart();
        cartInteractions.accessCouponCodeField("edgewords");
        cartInteractions.applyCouponToCart();
    }

    @Then("I can see {int}% has been deducted")
    public void i_can_see_has_been_deducted(Integer int1) {
        CartPOM cartInteractions = (CartPOM)this.sharedDict.readDict("cartInteractions");
        cartInteractions.findSubTotal();
        BigDecimal subtotal = cartInteractions.getSumAsBigDecimal();
        BigDecimal expectedDeduction = CartUtilityLibrary.calculateDeductionTotal(subtotal, int1);
        cartInteractions.applyShippingFee();
        BigDecimal shippingFee = cartInteractions.getShippingFeeAsBigDecimal();
        BigDecimal expectedFinalSum = CartUtilityLibrary.calculateFinalSum(subtotal, expectedDeduction, shippingFee);
        BigDecimal actualDeduction = cartInteractions.getCouponDeduction();
        BigDecimal actualFinalSum = cartInteractions.getFinalSum();
        MatcherAssert.assertThat(actualDeduction, Matchers.comparesEqualTo(expectedDeduction));
        MatcherAssert.assertThat(actualFinalSum, Matchers.comparesEqualTo(expectedFinalSum));
    }

    @Given("I have access to the shop page")
    public void i_have_access_to_the_shop_page() {
        NavigationPOM navigation = (NavigationPOM)this.sharedDict.readDict("navigation");
        navigation.goToShop();
    }

    @When("I add an {string} of clothing to my cart")
    public void i_add_an_item_of_clothing_to_my_cart(String item) {
        ShopPagePOM shop = (ShopPagePOM)this.sharedDict.readDict("shop");
        shop.addItemToCartParameterised(item);
        shop.addItemToCart();
    }

    @When("I proceed through the purchasing process, entering {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_proceed_through_the_purchasing_process_entering(String firstName, String lastName, String country, String address, String city, String postCode, String phone) {
        CartPOM cartInteractions = (CartPOM)this.sharedDict.readDict("cartInteractions");
        ShopPagePOM shop = (ShopPagePOM)this.sharedDict.readDict("shop");
        CheckoutPagePOM checkout = (CheckoutPagePOM)this.sharedDict.readDict("checkout");
        shop.viewCartInIcon();
        cartInteractions.goToCheckout();
        checkout.inputFirstName(firstName);
        checkout.inputLastName(lastName);
        checkout.inputBillingCountry(country);
        checkout.inputBillingAddressNameAndNumber(address);
        checkout.inputBillingCity(city);
        checkout.inputBillingPostCode(postCode);
        checkout.inputBillingPhone(phone);
        checkout.inputPaymentMethodCheque();
        checkout.finaliseOrder();
    }

    @Then("I should see my order number in the accounts page")
    public void i_should_see_my_order_number_in_the_accounts_page() {
        NavigationPOM navigation = (NavigationPOM)this.sharedDict.readDict("navigation");
        AccountPagePOM account = (AccountPagePOM)this.sharedDict.readDict("account");
        OrderConfirmationPagePOM orderConfirmation = (OrderConfirmationPagePOM)this.sharedDict.readDict("orderConfirmation");
        String orderNumber = orderConfirmation.getOrderNumber();
        this.sharedDict.addDict("orderNumber", orderNumber);
        navigation.goToAccount();
        account.viewOrders();
        String foundOrderNumber = account.checkOrderNumber();
        String savedOrderNumber = (String)this.sharedDict.readDict("orderNumber");
        MatcherAssert.assertThat(foundOrderNumber, Matchers.equalTo(savedOrderNumber));
    }
}

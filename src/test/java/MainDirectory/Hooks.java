package MainDirectory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import MainDirectory.pom_files.AccountPagePOM;
import MainDirectory.pom_files.CartPOM;
import MainDirectory.pom_files.CheckoutPagePOM;
import MainDirectory.pom_files.HomePagePOM;
import MainDirectory.pom_files.NavigationPOM;
import MainDirectory.pom_files.OrderConfirmationPagePOM;
import MainDirectory.pom_files.SearchResultsPOM;
import MainDirectory.pom_files.ShopPagePOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    private WebDriver driver;
    private final SharedDictionary sharedDict;
    String baseUrl = "https://www.edgewordstraining.co.uk/demo-site/";
    HomePagePOM home;
    NavigationPOM navigation;
    AccountPagePOM account;
    CartPOM cartInteractions;
    SearchResultsPOM results;
    ShopPagePOM shop;
    CheckoutPagePOM checkout;
    OrderConfirmationPagePOM orderConfirmation;

    public Hooks(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict;
    }

    @Before
    public void setUp() {
        this.driver = new FirefoxDriver();
        this.sharedDict.addDict("driver", this.driver);
        this.driver.get(this.baseUrl);
        this.home = new HomePagePOM(this.driver);
        this.sharedDict.addDict("home", this.home);
        this.navigation = new NavigationPOM(this.driver);
        this.sharedDict.addDict("navigation", this.navigation);
        this.account = new AccountPagePOM(this.driver);
        this.sharedDict.addDict("account", this.account);
        this.cartInteractions = new CartPOM(this.driver);
        this.sharedDict.addDict("cartInteractions", this.cartInteractions);
        this.results = new SearchResultsPOM(this.driver);
        this.sharedDict.addDict("results", this.results);
        this.shop = new ShopPagePOM(this.driver);
        this.sharedDict.addDict("shop", this.shop);
        this.checkout = new CheckoutPagePOM(this.driver);
        this.sharedDict.addDict("checkout", this.checkout);
        this.orderConfirmation = new OrderConfirmationPagePOM(this.driver);
        this.sharedDict.addDict("orderConfirmation", this.orderConfirmation);
        this.home.acceptCookies();
        this.navigation.goToAccount();
        this.account.logInToSite("fakelewis2@2i.com", "fakepassword@@@@1111");
    }

    @After
    public void tearDown() {
        this.sharedDict.clearDictionary();
        this.navigation.goToAccount();
        this.account.logOutOfSite();
        if (this.driver != null) {
            this.driver.quit();
        }

    }
}

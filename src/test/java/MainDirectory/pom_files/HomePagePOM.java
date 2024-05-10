package MainDirectory.pom_files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {
    protected WebDriver driver;
    @FindBy(
            linkText = "Dismiss"
    )
    WebElement dismissLink;

    public HomePagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        this.dismissLink.click();
    }
}
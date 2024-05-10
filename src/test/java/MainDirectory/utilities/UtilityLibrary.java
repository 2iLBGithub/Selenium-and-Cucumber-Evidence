package MainDirectory.utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityLibrary {
    public UtilityLibrary() {
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((long)seconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((long)seconds));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void waitForElementToBeInvisible(WebDriver driver, WebElement locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((long)seconds));
        wait.until(ExpectedConditions.invisibilityOf(locator));
    }
}
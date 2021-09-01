package baseUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Baseutils {

    WebDriver driver;

    public Baseutils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitClick(int timeOut, By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void moveToClick(String path) {
        Actions action = new Actions(driver);
        WebElement e = driver.findElement(By.xpath(path));
        action.moveToElement(e).click().build().perform();
    }
}

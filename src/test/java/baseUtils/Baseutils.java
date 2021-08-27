package baseUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Baseutils {

    WebDriver driver;

    public Baseutils(WebDriver driver) {
        this.driver = driver;
    }

    public void moveToClick(String path) {
        Actions action = new Actions(driver);
        WebElement e = driver.findElement(By.xpath(path));
        action.moveToElement(e).click().build().perform();
    }
}

package pages;

import baseUtils.Baseutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Ehrpluginpage {
    WebDriver driver;
    Baseutils basic;

    public Ehrpluginpage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEhrplugin() {
        driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
    }

    public void clickViewLiveSample() {
        basic = new Baseutils(driver);
        basic.moveToClick("//a[contains(text(),'View Live Sample')]");
    }

    public void validateEhrSampleUrl(String expectedGinaUrl) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String actualGinaUrl = driver.getCurrentUrl();
        if (actualGinaUrl.equalsIgnoreCase(expectedGinaUrl))
            System.out.println("Ehr is redirected to the proper url: " + actualGinaUrl);
        else
            System.out.println("Ehr is redirected to the proper url: " + actualGinaUrl);

    }
}

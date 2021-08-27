package pages;


import baseUtils.Baseutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Resourcepage {

    WebDriver driver;

    Baseutils basic;

    public Resourcepage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickResource() {
        basic = new Baseutils(driver);
        basic.moveToClick("//a[contains(text(),'Get Resources')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement e = driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]"));
        wait.until(ExpectedConditions.visibilityOf(e));
        System.out.println("Get Resources button is working");
        driver.navigate().back();
        driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
    }

    public void viewOrCustomize(int i) {
        basic = new Baseutils(driver);
        basic.moveToClick("//body/div[3]/div[4]/div[1]/div[" + i + "]/div[1]/div[2]/a[1]");
    }

    public void clickGenerateUrl() {
        driver.findElement(By.xpath(
                "//label[contains(text(),\"Go to my profile settings to grab my organization'\")]")).click();
    }

    public void validateUrl() throws InterruptedException {

        String url = driver.findElement(By.xpath("//input[@id='myInput']")).getText();
        System.out.println("url = " + url);

        for (int i = 0; i <= 5; i++) {
            Thread.sleep(5000);
            String urlGetter = urlGetter();
            if (urlGetter.contains("https://")) {
                System.out.println("Url got generated");
                break;
            } else {
                System.out.println("Still the url not generated");
            }
        }
    }

    public String urlGetter() {

        basic = new Baseutils(driver);
        basic.moveToClick("//input[@id='myInput']");

        String urlGetter = driver.findElement(By.xpath("//input[@id='myInput']")).getAttribute("value");
        System.out.println("url = " + urlGetter);
        return urlGetter;
    }

}

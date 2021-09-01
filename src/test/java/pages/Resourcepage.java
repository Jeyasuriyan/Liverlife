package pages;


import baseUtils.Baseutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

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
            } else
                System.out.println("Still the url not generated");
        }
    }

    public String urlGetter() {

        basic = new Baseutils(driver);
        basic.moveToClick("//input[@id='myInput']");

        String urlGetter = driver.findElement(By.xpath("//input[@id='myInput']")).getAttribute("value");
        System.out.println("url = " + urlGetter);
        return urlGetter;
    }

    public void enterResourceSearch(String value) {
        driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
        driver.findElement(By.xpath("//body/div[3]/div[3]/div[1]/div[1]/div[2]/form[1]/input[1]")).sendKeys(value);
        driver.findElement(By.xpath("//body/div[3]/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
    }

    public void validateSearch(String expectedResourceName) {
        String actualResourceName = driver.findElement(By.xpath("//h3[contains(text(),'Level Check–PBC Predictive Biomarkers')]")).getText();
        if (actualResourceName.equalsIgnoreCase(expectedResourceName))
            System.out.println("Search is working properly");
        else
            System.out.println("Search is not working properly");

    }

    public void clickTargetAudience() {
        driver.findElement(By.xpath("//body/div[3]/div[3]/div[1]/div[1]/div[1]/span[1]")).click();
    }

    public void selectTarget(String targetAudience) {
        if (targetAudience.equalsIgnoreCase("Patient")) {
            driver.findElement(By.xpath("//label[contains(text(),'Patient')]")).click();
            driver.findElement(By.id("filter")).click();
            String resultValue = driver.findElement(By.xpath("//p[contains(text(),'Your Results 4')]")).getText();
            clickTargetAudience();
            driver.findElement(By.xpath("//label[contains(text(),'Patient')]")).click();
            if (resultValue.equalsIgnoreCase("Your Results 4"))
                System.out.println("Patient filter is working properly");
            else
                System.out.println("Patient filter is not working properly");

        } else if (targetAudience.equalsIgnoreCase("healthcare")) {
            driver.findElement(By.xpath("//label[contains(text(),'Health Care Provider')]")).click();
            driver.findElement(By.id("filter")).click();
            String resultValue = driver.findElement(By.xpath("//p[contains(text(),'Your Results 2')]")).getText();
            if (resultValue.equalsIgnoreCase("Your Results 2"))
                System.out.println("Health Care Provider filter is working properly");
            else
                System.out.println("Health Care Provider filter is not working properly");

        }
    }

    public void clickGina() {
        driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
        basic = new Baseutils(driver);
        basic.moveToClick("//a[contains(text(),'GINA™')]");
    }

    public void validateGinaUrl(String expectedGinaUrl) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String actualGinaUrl = driver.getCurrentUrl();
        if (actualGinaUrl.equalsIgnoreCase(expectedGinaUrl))
            System.out.println("Gina is redirected to the proper url: " + actualGinaUrl);
        else
            System.out.println("Gina is redirected to the proper url: " + actualGinaUrl);
    }

}

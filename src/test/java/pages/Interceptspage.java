package pages;

import baseUtils.Baseutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Interceptspage {

    WebDriver driver;
    Baseutils basic;


    public Interceptspage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickIntercepts() {
        driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
    }

    public void viewIntercepts(int i) throws InterruptedException {
        basic = new Baseutils(driver);
        basic.moveToClick("//body/div[3]/div[3]/div[1]/div[" + i + "]/div[1]/div[2]/a[1]");
        Thread.sleep(2000);
    }

    public void openSlide() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@src='//cat02.cc-tools.online/liverlife-platform-overview/?publitas_embed=embedded']")));

        By element = By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[2]/iframe[1]");
        basic.waitClick(3000, element);
        basic.moveToClick(element.toString());
        //driver.findElement(By.xpath("//*[@id=\"embed_controls\"]/nav/button")).click();

    }

    public void closeSlide() {
        driver.findElement(By.xpath("//button[@id='close-embed']")).click();
    }
}

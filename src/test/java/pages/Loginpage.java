package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
    WebDriver driver;

    public Loginpage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password) {
        driver.findElement(By.id("email")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickLogin() throws InterruptedException {
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);

    }

    public void loginValidate() {
        driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
        if (driver.getCurrentUrl().equals("https://liverlifeweb.myliverlife.online/resources"))
            System.out.print("Logged in Success");
        else
            System.out.println("Empty field or Credentials are wrong");

    }
}

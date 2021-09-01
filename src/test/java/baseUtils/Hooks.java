package baseUtils;

import baseUtils.Base;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class Hooks extends Base {

    private final Base base;

    public Hooks(Base base) {
        this.base = base;
    }

    @Before
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
        base.driver = new ChromeDriver();
        base.driver.manage().window().maximize();

        base.driver.get("https://liverlifeweb.myliverlife.online/login");
    }

    @After
    public void tearDown(Scenario scenario) {
        //base.driver.close();
    }
}

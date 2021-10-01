package baseUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkingg {

    private final Base base;

    public Checkingg(Base base) {
        this.base = base;
    }

    @Before
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
        base.driver = new ChromeDriver();
        base.driver.manage().window().maximize();

        base.driver.get("https://liverlifeweb.myliverlife.online/login");
        //adding comments
    }

    @After
    public void tearDown(Scenario scenario) {
        //base.driver.close();
    }
}


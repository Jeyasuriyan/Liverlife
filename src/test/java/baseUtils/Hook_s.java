package baseUtils;

import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook_s extends Base {

    private final Base base;

    public Hook_s(Base base) {
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

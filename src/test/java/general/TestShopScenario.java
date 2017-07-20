package general;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Daniel on 20/07/2017.
 */
public class TestShopScenario {

    protected WebDriver driver;

    @BeforeMethod
    public void setUpChromeDriver(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void killDriver(){
        driver.quit();
    }
}

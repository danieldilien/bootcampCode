package browserDriven;

import browser.BrowserFactoryAdvanced;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 20/07/2017.
 */
public class TestShopScenarioBrowserDriven {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(BrowserFactoryAdvanced.Browser browser){
        ChromeDriverManager.getInstance().setup();
        driver = BrowserFactoryAdvanced.getDriver(browser);
        wait = new WebDriverWait(driver, 5);
        driver.get("https://techblog.polteq.com/testshop/index.php");
//        maximizeWindow();
    }
    @AfterMethod
    public void killDriver() {
       driver.quit();
    }
}

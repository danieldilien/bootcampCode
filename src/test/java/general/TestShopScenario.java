package general;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Daniel on 20/07/2017.
 */
public class TestShopScenario {

    protected WebDriver driver;
    protected WebDriverWait wait;
    @BeforeMethod
    public void setUpChromeDriver(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }
/*
    @AfterMethod
    public void killDriver(){
        driver.quit();
    }
*/
}

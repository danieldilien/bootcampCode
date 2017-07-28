package browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Daniel on 27/07/2017.
 */
public class BrowserFactoryAdvanced {

    public enum Browser{
        CHROME,
        FIREFOX,
        IE,
        EDGE,
        SAFARI;
    }
    public static WebDriver getDriver(Browser browser){
        switch (browser) {
            case FIREFOX:
                return createFirefoxDriver();
            case CHROME:
                return createChromeDriver();
            default: return null;
        }
    }
    private static WebDriver createChromeDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-start-maximized");
        capabilities.setCapability("chrome.switches","--verbose");
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver(capabilities);
        return driver;
    }
    private static WebDriver createFirefoxDriver(){
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.private.browsing.autostart",true);
        capabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
        FirefoxDriverManager.getInstance().setup();
        WebDriver driver = new FirefoxDriver(capabilities);
        return driver;
    }
}

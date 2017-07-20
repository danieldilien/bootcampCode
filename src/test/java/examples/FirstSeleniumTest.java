package examples;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Daniel on 19/07/2017.
 */
public class FirstSeleniumTest {
    public WebDriver driver;

    @Test
    public void logInSuccesFull(){
        //Go to homepage
        goToUrl("https://techblog.polteq.com/testshop/index.php");

        //Login steps
        loginFlow();

        //Assertion on text
        String welcomeText = driver.findElement(By.className("info-account")).getText();
        assertThat(welcomeText).as("Welkomtekst na succesvol inloggen").contains("Welcome to your account.");

        //Assertion on boolean
        boolean signOutButton = driver.findElement(By.className("logout")).isDisplayed();
        assertThat(signOutButton).as("Log uit knop is zichtbaar").isTrue();

        //Close
        killDriver();
    }

    public void goToUrl(String url){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    public void loginFlow(){
        //Click on link 'Sign in'
        driver.findElement(By.className("login")).click();

        //Fill in e-mail
        driver.findElement(By.id("email")).sendKeys("tester@test.com");

        //Fill in pwd
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");

        //Click on button 'Sign in'
        driver.findElement(By.id("SubmitLogin")).click();
    }

    public void killDriver(){
        driver.quit();
    }
}

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
        setUp();
        goToHomePage();
        goToLoginPage();
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
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }
    public void goToHomePage(){
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    public void goToLoginPage(){
        driver.findElement(By.className("login")).click();
        //Assertion on text
        String headingText = driver.findElement(By.className("page-heading")).getText();
        assertThat(headingText).as("Logintekst na klikken op Sign in").contains("AUTHENTICATION");
    }

    public void loginFlow(){
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

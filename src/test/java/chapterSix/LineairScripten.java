package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 19/07/2017.
 */
public class LineairScripten {
    public WebDriver driver;
    @Test
    public void logInSuccesFull(){
        setUp();
        goToHomePage();
        goToLoginPage();
        loginFlow();
        assertSuccesfullLogin();
        killDriver();
    }
    @Test
    public void logOutSuccesFull(){
        setUp();
        goToHomePage();
        maximizeWindow();
        goToLoginPage();
        loginFlow();
        assertSuccesfullLogin();
        goToHomePage();
        logoutFlow();
        assertSuccesfullLogout();
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
        driver.findElement(By.id("email")).sendKeys("tester@test.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();
    }
    public void logoutFlow(){
       driver.findElement(By.className("logout")).click();
    }
    public void assertSuccesfullLogin(){
        boolean signOutButton = driver.findElement(By.className("logout")).isDisplayed();
        assertThat(signOutButton).as("Log uit knop is zichtbaar").isTrue();
    }
    public void assertSuccesfullLogout(){
        boolean signInButton = driver.findElement(By.className("login")).isDisplayed();
        assertThat(signInButton).as("Log in knop is zichtbaar").isTrue();
    }
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
    public void killDriver(){
        driver.quit();
    }
}

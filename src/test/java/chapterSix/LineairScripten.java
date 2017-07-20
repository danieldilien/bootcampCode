package chapterSix;

import general.TestShopScenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 19/07/2017.
 */
public class LineairScripten extends TestShopScenario{

    @Test
    public void logInSuccesFull(){
        goToHomePage();
        goToLoginPage();
        loginFlow();
        assertSuccesfullLogin();
    }
    @Test
    public void logOutSuccesFull(){
        maximizeWindow();
        logInSuccesFull();
        logoutFlow();
        assertSuccesfullLogout();
    }

    @Test
    public void fillCartTest(){
        goToHomePage();
        maximizeWindow();
        assertThat(checkNumberOfCartItems()).isEqualTo("0");


    }
    public String checkNumberOfCartItems(){
        String number;

        if(driver.findElement(By.className("ajax_cart_quantity")).isDisplayed() == true)
            number = driver.findElement(By.className("ajax_cart_quantity")).getText();
        else
            number = "0";

        return number;
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
}

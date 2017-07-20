package chapterSix;

import general.TestShopScenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        clickOnTag("ipod");
        clickOnProductWithTitle("iPod shuffle");
        driver.findElement(By.id("add_to_cart")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span"))).click();
        goToHomePage();
        assertThat(checkNumberOfCartItems()).isEqualTo("1");
    }
    @Test
    public void emptyCartTest(){
        fillCartTest();
        goToShoppingCart();
        driver.findElement(By.className("icon-trash")).click();
        goToHomePage();
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
    public void clickOnTag(String tag){
        driver.findElement(By.xpath(".//*[@id='tags_block_left']/div/*[contains(text(), '" + tag + "')]")).click();
        String searchResult = driver.findElement(By.xpath(".//*[@id='center_column']/h1/span[1]")).getText();
        assertThat(searchResult).contains(tag.toUpperCase());
    }
    public void clickOnProductWithTitle(String title){
        driver.findElement(By.xpath("//*[@class='product-name' and contains(text(),'" + title + "')]")).click();
        String searchResult = driver.findElement(By.xpath("//*[@itemprop='name']")).getText();
        assertThat(searchResult).contains(title);
    }
    public void goToShoppingCart(){
        driver.findElement(By.xpath("//*[@title='View my shopping cart']")).click();
    }
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
}

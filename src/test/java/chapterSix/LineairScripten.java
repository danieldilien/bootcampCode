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
        maximizeWindow();
        goToLoginPage();
        loginFlow();
        assertSuccesfullLogin();
        goToHomePage();
    }
    @Test
    public void logOutSuccesFull(){
        logInSuccesFull();
        logoutFlow();
        assertSuccesfullLogout();
        goToHomePage();
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
    @Test
    public void modifyPersonalInfoTest(){
        logInSuccesFull();
        goToMyCustomerAccount();
        driver.findElement(By.className("icon-user")).click();
        String firstName = driver.findElement(By.id("firstname")).getAttribute("value");
        if(firstName.equals("Daniel"))
            firstName = "Danny";
        else
            firstName = "Daniel";
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("old_passwd")).clear();
        driver.findElement(By.id("old_passwd")).sendKeys(pwd);
        driver.findElement(By.name("submitIdentity")).click();

        String alertText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText();
        assertThat(alertText).contains("Your personal information has been successfully updated");
        goToHomePage();
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
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(pwd);
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
    public void goToMyCustomerAccount(){
        driver.findElement(By.xpath("//*[@title='View my customer account']")).click();
    }
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
}

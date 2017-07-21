package general;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 20/07/2017.
 */
public class TestShopScenario {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String email;
    protected String pwd;

    @BeforeMethod
    public void setUpChromeDriver(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        email = "daniel.dilien@polteq.com";
        pwd = "Test123";
        driver.get("https://techblog.polteq.com/testshop/index.php");
        maximizeWindow();
    }

    @AfterMethod
    public void killDriver() {
        //driver.quit();
    }

    public int checkNumberOfCartItems(){
        String number;

        if(driver.findElement(By.className("ajax_cart_quantity")).isDisplayed() == true)
            number = driver.findElement(By.className("ajax_cart_quantity")).getText();
        else
        {
            assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed()).isTrue();
            number = "0";
        }


        return Integer.parseInt(number);
    }
    public void goToHomePage(){
        driver.findElement(By.xpath("//*[@title='Home']")).click();
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
        String searchResult = driver.findElement(By.xpath(".//*[@id='center_column']/*")).getText();
        assertThat(searchResult).contains(tag.toUpperCase());
    }
    public void clickOnProductWithTitle(String title){
        driver.findElement(By.xpath("//*[@class='product-name' and contains(text(),'" + title + "')]")).click();
        String searchResult = driver.findElement(By.xpath("//*[@itemprop='name']")).getText();
        assertThat(searchResult).contains(title);
    }
    public void goToShoppingCart(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='View my shopping cart']"))).click();
    }
    public void goToMyCustomerAccount(){
        driver.findElement(By.xpath("//*[@title='View my customer account']")).click();
    }
    public void goToAppleSupplier(){
        driver.findElement(By.xpath("//*[@title='More about AppleStore']")).click();
    }
    public void modifyFirstNameOnCustomerPage(String firstName){
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("old_passwd")).clear();
        driver.findElement(By.id("old_passwd")).sendKeys(pwd);
        driver.findElement(By.name("submitIdentity")).click();
    }
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Daniel on 24/07/2017.
 */
public class MyAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@title='My wishlists']")
    private WebElement myWishListButton;

    public MyAccountPage(WebDriver driver , WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        //This call sets the Webelements
        PageFactory.initElements(driver, this);
    }
    public void goToMyWishList (){
        myWishListButton.click();
    }
}

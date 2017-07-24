package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Daniel on 24/07/2017.
 */
public class MyAccountPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@title='My wishlists']")
    private WebElement myWishListButton;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        //This call sets the Webelements
        PageFactory.initElements(driver, this);
    }

    public void goToMyWishList (){
        myWishListButton.click();
    }

}

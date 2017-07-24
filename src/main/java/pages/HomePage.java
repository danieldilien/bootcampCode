package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Daniel on 21/07/2017.
 */
public class HomePage {
    private WebDriver driver;

    @FindBy(className = "login")
    private WebElement login;
    @FindBy(xpath = "//*[@title='Contact us']")
    private WebElement contactUs;
    @FindBy(xpath = "//*[@title='Home']")
    private WebElement homePage;

    @FindBy(className="logout")
    private WebElement logoutText;
    @FindBy(className="login")
    private WebElement loginText;

    @FindBy(xpath = "//*[@title='View my customer account']")
    private WebElement myAccountLink;



    public HomePage(WebDriver driver){
        this.driver = driver;
        //This call sets the Webelements
        PageFactory.initElements(driver, this);
    }
    public void goToHomePage(){
        homePage.click();
    }
    public void goToLoginPage(){
        login.click();
    }
    public void goToContactUsPage(){
        contactUs.click();
    }
    public boolean  isUserLoggedIn(){
        boolean loggedIn=false;

        try {
            if(logoutText.isDisplayed())
                loggedIn = true;
        } catch (NoSuchElementException e) {
            if(loginText.isDisplayed())
                loggedIn = false;
        }
        return loggedIn;
    }
    public void logOut(){
        logoutText.click();
    }

    public void goToMyAccountPage(){
        myAccountLink.click();
    }

}

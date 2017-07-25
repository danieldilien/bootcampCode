package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Daniel on 21/07/2017.
 */
public class AuthenticationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id="email")
    private WebElement emailField;
    @FindBy(id="passwd")
    private WebElement pwdField;
    @FindBy(id="SubmitLogin")
    private WebElement signInButton;

    public AuthenticationPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        //This call sets the Webelements
        PageFactory.initElements(driver, this);
    }
    public void logInWithEmailAndPwd(String email, String pwd){
        emailField.sendKeys(email);
        pwdField.sendKeys(pwd);
        signInButton.click();
    }
}

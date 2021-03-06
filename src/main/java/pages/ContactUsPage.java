package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Daniel on 21/07/2017.
 */
public class ContactUsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "select#id_contact")
    private WebElement subjectOption;
    @FindBy(id="email")
    private WebElement emailTextField;
    @FindBy(id="id_order")
    private WebElement orderReferenceField;
    @FindBy(id="message")
    private WebElement messageField;
    @FindBy(id="submitMessage")
    private WebElement submitButton;
    @FindBy(xpath ="//*[@class='alert alert-success']")
    private WebElement alertMessage;
    @FindBy(css = "div.alert.alert-danger")
    private WebElement errorMessage;
    @FindBy(xpath ="//*[@class='form-group form-error']")
    private WebElement errorInText;

    public ContactUsPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        //This call sets the Webelements
        PageFactory.initElements(driver, this);
    }
    public void fillInContactForm(String subject, String email, String orderReference, String message){
        //select subject with value 1
        Select dropdown = new Select(subjectOption);
        dropdown.selectByVisibleText(subject);

        //Fill in email
        emailTextField.clear();
        emailTextField.sendKeys(email);

        //Fill in order reference
        orderReferenceField.clear();
        orderReferenceField.sendKeys(orderReference);

        //Fill in message
        messageField.clear();
        messageField.sendKeys(message);
    }
    public void saveForm(){
        submitButton.click();
    }
    public String getAlertMessage(){
        return alertMessage.getText();
    }
    public String getErrorMessage(){
        String error = wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
        return error;
    }
    public boolean errorOnPage(){
        boolean error;
        try{
            error = errorInText.isEnabled();
        }catch(Exception e){
            error = false;
        }
        return error;
    }
}

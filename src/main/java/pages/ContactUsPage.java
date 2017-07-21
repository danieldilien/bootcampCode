package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Daniel on 21/07/2017.
 */
public class ContactUsPage {
    private WebDriver driver;

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

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
        //This call sets the Webelements
        PageFactory.initElements(driver, this);
    }

    public void fillInContactForm(String orderReference, String email, String message){
        emailTextField.clear();
        emailTextField.sendKeys(email);
        orderReferenceField.clear();
        orderReferenceField.sendKeys(orderReference);
        messageField.clear();
        messageField.sendKeys(message);
        Select dropdown = new Select(subjectOption);
        dropdown.selectByValue("1");
        submitButton.click();
    }
}

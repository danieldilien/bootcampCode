package dataDriven;

import general.TestShopScenario;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 21/07/2017.
 */
public class ContactUsTestDataDriven extends TestShopScenarioDataDriven{

    @Parameters({"subject", "email", "orderID","message"})
    @Test
    public void contactUsTest(String subject, String email, String orderID, String message){
        ////Set all pages
        HomePage home = new HomePage(driver,wait);
        ContactUsPage contactPage = new ContactUsPage(driver,wait);

        //Go to the contact us-page
        home.goToContactUsPage();
        //Fill in the contact form and submit
        contactPage.fillInContactForm(subject,email,orderID,message);
        contactPage.saveForm();
        //Validate message was sent
        assertThat(contactPage.getAlertMessage()).contains("Your message has been successfully sent to our team.");

        //Leave test as before
        home.goToHomePage();

        System.out.println("Test successful: Contact Us");
    }
}

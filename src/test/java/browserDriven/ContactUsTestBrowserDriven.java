package browserDriven;

import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 21/07/2017.
 */
public class ContactUsTestBrowserDriven extends TestShopScenarioBrowserDriven{

    @Test
    public void contactUsTest(){
        ////Set all pages
        HomePage home = new HomePage(driver,wait);
        ContactUsPage contactPage = new ContactUsPage(driver,wait);

        //Go to the contact us-page
        home.goToContactUsPage();
        //Fill in the contact form and submit
        contactPage.fillInContactForm("Customer service", "bootcamper@feelthepain.com","4321234 ","Ipod defect while lifting, need new one");
        contactPage.saveForm();
        //Validate message was sent
        assertThat(contactPage.getAlertMessage()).contains("Your message has been successfully sent to our team.");

        //Leave test as before
        home.goToHomePage();

        System.out.println("Test successful: Contact Us");
    }
}

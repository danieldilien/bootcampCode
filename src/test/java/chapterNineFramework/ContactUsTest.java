package chapterNineFramework;

import general.TestShopScenario;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 21/07/2017.
 */
public class ContactUsTest extends TestShopScenario{

    @Test
    public void contactUsTest(){
        //Go to contactpage
        HomePage home = new HomePage(driver);
        home.goToContactUsPage();

        //Fill in fields and submit
        ContactUsPage contactPage = new ContactUsPage(driver);
        contactPage.fillInContactForm("Customer service", "bootcamper@feelthepain.com","4321234 ","Ipod defect while lifting, need new one");

        //Validate the alert message
        assertThat(contactPage.getAlertMessage()).contains("Your message has been successfully sent to our team.");
    }


}

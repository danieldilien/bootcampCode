package chapterNineFramework;

import general.TestShopScenario;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 27/07/2017.
 */
public class ContactUsWrongEmailTest_02 extends TestShopScenario{

    @Test
    public void contactUsWrongEmailTest(){
        ////Set all pages
        HomePage home = new HomePage(driver,wait);
        ContactUsPage contactPage = new ContactUsPage(driver,wait);

        //Go to the contact us-page
        home.goToContactUsPage();

        //Fill in the contact form and submit
        contactPage.fillInContactForm("Customer service", "nope","4321234 ","Ipod defect while lifting, need new one");
        //Validate error
        assertThat(contactPage.errorOnPage()).isTrue().as("Email error validation should be displayed ");

        //Fill in the contact form and submit
        contactPage.fillInContactForm("Customer service", "nope@correct.com","4321234 ","Ipod defect while lifting, need new one");
        //Validate error
        assertThat(contactPage.errorOnPage()).isFalse().as("Email error validation is not displayed ");

        //Leave test as before
        home.goToHomePage();

        System.out.println("Test successful: Contact Us with wrong email (inline error)");
    }
}

package chapterNineFramework;

import general.TestShopScenario;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 21/07/2017.
 */
public class ContactUsTest extends TestShopScenario{

    @Test
    public void contactUsTest(){
        //Go to contactpage
        driver.findElement(By.xpath("//*[@title='Contact us']")).click();

        //Fill in fields and submit
        ContactUsPage contactPage = new ContactUsPage(driver);
        contactPage.fillInContactForm("Orderreference test","blabla@test.com","Messagetext test");

        String alertText = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText();
        assertThat(alertText).contains("Your message has been successfully sent to our team.");
    }


}

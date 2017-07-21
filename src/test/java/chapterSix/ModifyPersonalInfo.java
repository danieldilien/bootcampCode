package chapterSix;

import general.TestShopScenario;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 21/07/2017.
 */
public class ModifyPersonalInfo extends TestShopScenario {

    @Test
    public void modifyPersonalInfoTest(){
        maximizeWindow();
        goToLoginPage();
        loginFlow();
        goToHomePage();
        goToMyCustomerAccount();
        driver.findElement(By.className("icon-user")).click();
        String firstName = driver.findElement(By.id("firstname")).getAttribute("value");
        if(firstName.equals("Daniel"))
            firstName = "Danny";
        else
            firstName = "Daniel";
        modifyFirstNameOnCustomerPage(firstName);

        String alertText = driver.findElement(By.xpath("//*[@id='center_column']/div/p")).getText();
        assertThat(alertText).contains("Your personal information has been successfully updated");

        goToHomePage();
    }
}

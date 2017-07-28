package chapterNineFramework;

import general.TestShopScenario;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 21/07/2017.
 */
public class LogInTest extends TestShopScenario{

    @Test
    public void signInTest(){
        //Set all pages
        HomePage home = new HomePage(driver,wait);
        AuthenticationPage authPage = new AuthenticationPage(driver,wait);

        //Make sure nobody is logged in
        if(home.isUserLoggedIn()==true)
            home.logOut();

        //Go to login-page
        home.goToLoginPage();

        //Login with e-mail and pwd
        authPage.logInWithEmailAndPwd("daniel.dilien@polteq.com","Test123");

        //Validate login was successful
        assertThat(home.isUserLoggedIn()).as("User is logged in").isTrue();

        //Leave test as before
        home.logOut();
        assertThat(home.isUserLoggedIn()).as("User is not logged in").isFalse();
        home.goToHomePage();

        System.out.println("Test successful: Login");
    }
}

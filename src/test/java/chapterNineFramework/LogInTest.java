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
        HomePage home = new HomePage(driver);
        home.goToLoginPage();
        AuthenticationPage authPage = new AuthenticationPage(driver);
        // authPage.logInWithEmailAndPwd("daniel.dilien@polteq.com","Test123");
        if(home.isUserLoggedIn()==true)
        {
            home.logOut();
        }
        authPage.logInWithEmailAndPwd("daniel.dilien@polteq.com","Test123");
        home.goToHomePage();
        assertThat(home.isUserLoggedIn()).as("User is ingelogd").isTrue();
    }
}

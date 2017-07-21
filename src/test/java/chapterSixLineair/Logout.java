package chapterSixLineair;

import general.TestShopScenario;
import org.testng.annotations.Test;

/**
 * Created by Daniel on 21/07/2017.
 */
public class Logout extends TestShopScenario {

    @Test
    public void logOutSuccesFull(){
        maximizeWindow();
        goToLoginPage();
        loginFlow();
        goToHomePage();
        logoutFlow();
        assertSuccesfullLogout();
        goToHomePage();
    }
}

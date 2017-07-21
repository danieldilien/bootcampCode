package chapterSix;

import general.TestShopScenario;
import org.testng.annotations.Test;

/**
 * Created by Daniel on 21/07/2017.
 */
public class Login extends TestShopScenario{
    @Test
    public void logInSuccesFull(){
        maximizeWindow();
        goToLoginPage();
        loginFlow();
        assertSuccesfullLogin();
        goToHomePage();
    }
}

package chapterNineFramework;

import general.ExelUtils;
import general.TestShopScenario;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 27/07/2017.
 */
public class LoginInWithTestDataTest extends TestShopScenario{
    public static final String Path_TestData = "C://Users//Daniel//Documents//Summer Automation Bootcamp//Test Data//";
    public static final String File_TestData = "TestData.xlsx";
    public static final String Sheet_TestData ="LogInData";
    @Test
    public void signInTest() throws Exception{
        String[][] array = ExelUtils.getTableArray(Path_TestData+File_TestData, Sheet_TestData);


        //Set all pages
        HomePage home = new HomePage(driver,wait);
        AuthenticationPage authPage = new AuthenticationPage(driver,wait);

        //Make sure nobody is logged in
        if(home.isUserLoggedIn()==true)
            home.logOut();


         for (int i=0; i<ExelUtils.totalRows;i++)
        {
            //Go to login-page
            home.goToLoginPage();
            //Login with e-mail and pwd
            authPage.logInWithEmailAndPwd(array[i][0],array[i][1]);
            //Validate login was successful
            assertThat(home.isUserLoggedIn()).as("User is logged in").isTrue();
            System.out.println("#"+ (i+1)+" Test successful: Login with username '"+ array[i][0] + "' and pwd '" + array[i][1] +"'" );
            home.logOut();
        }

        //Leave test as before
        assertThat(home.isUserLoggedIn()).as("User is not logged in").isFalse();
        home.goToHomePage();
    }


}

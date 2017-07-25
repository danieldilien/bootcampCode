package chapterNineFramework;

import general.TestShopScenario;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.MyWishListPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 24/07/2017.
 */
public class DeleteWishListTest extends TestShopScenario{

    @Test
    public void deleteWishListTest(){
        //Set all pages + wishlist to delete
        HomePage home = new HomePage(driver,wait);
        AuthenticationPage authPage = new AuthenticationPage(driver,wait);
        MyAccountPage myAccountPage = new MyAccountPage(driver,wait);
        MyWishListPage wishListPage = new MyWishListPage(driver,wait);
        String wishListToDelete = "Feel the pain";

        //Make sure nobody is logged in
        if(home.isUserLoggedIn()==true)
        {
            home.logOut();
        }

        //Go to login-page and login
        home.goToLoginPage();
        authPage.logInWithEmailAndPwd("daniel@dilien.com","1qazxsw2");

        //Go to my wishlist-page
        myAccountPage.goToMyWishList();

        //Delete wishlist and validate
        wishListPage.deleteWishListWithName(wishListToDelete);
        wishListPage.waitForWishlistToReload();
        assertThat(wishListPage.isWishListPresent(wishListToDelete)).as("Wishlist is present").isFalse();

        //Leave test as before
        wishListPage.addNewWishlist(wishListToDelete);
        wishListPage.waitForWishlistToReload();
        assertThat(wishListPage.isWishListPresent(wishListToDelete)).as("Wishlist is present").isTrue();
        home.logOut();
        home.goToHomePage();

        System.out.println("Test successful: Delete wishlist");
    }
}

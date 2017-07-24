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
        HomePage home = new HomePage(driver);
        AuthenticationPage authPage = new AuthenticationPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage wishListPage = new MyWishListPage(driver,wait);
        String wishListToDelete = "Feel the pain";

        //Make sure nobody is logged in
        if(home.isUserLoggedIn()==true)
        {
            home.logOut();
        }

        //Go to loginpage and login
        home.goToLoginPage();
        authPage.logInWithEmailAndPwd("daniel@dilien.com","1qazxsw2");

        //Go to my wishlist page
        myAccountPage.goToMyWishList();

        //Add wishlist if it's not present
        if(wishListPage.isWishListPresentWithName(wishListToDelete) == false){
            wishListPage.addNewWishlist(wishListToDelete);
            wishListPage.waitForWishlistToReload();
            assertThat(wishListPage.isWishListPresentWithName(wishListToDelete)).as("Wishlist is present").isTrue();
        }

        //Delete wishlist and validate
        wishListPage.deleteWishListWithName(wishListToDelete);
        wishListPage.waitForWishlistToReload();
        assertThat(wishListPage.isWishListPresentWithName(wishListToDelete)).as("Wishlist is present").isFalse();
        System.out.println("Delete successful");

        //Add again the wishlist to leave the test as before
        wishListPage.addNewWishlist(wishListToDelete);
        wishListPage.waitForWishlistToReload();
        assertThat(wishListPage.isWishListPresentWithName(wishListToDelete)).as("Wishlist is present").isTrue();
        home.logOut();
        home.goToHomePage();
    }
}

package chapterSixLineair;

import general.TestShopScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 21/07/2017.
 */
public class EmptyCart extends TestShopScenario{
    @Test
    public void emptyCartTest(){
        maximizeWindow();
        clickOnTag("ipod");
        clickOnProductWithTitle("iPod shuffle");
        driver.findElement(By.id("add_to_cart")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Continue shopping']"))).click();
        goToShoppingCart();
        driver.findElement(By.className("icon-trash")).click();
        goToHomePage();
        assertThat(checkNumberOfCartItems()).isEqualTo(0);
    }
}

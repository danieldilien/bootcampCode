package chapterSix;

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
        goToHomePage();
        maximizeWindow();
        clickOnTag("ipod");
        clickOnProductWithTitle("iPod shuffle");
        driver.findElement(By.id("add_to_cart")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span"))).click();
        goToShoppingCart();
        driver.findElement(By.className("icon-trash")).click();
        goToHomePage();
        assertThat(checkNumberOfCartItems()).isEqualTo(0);
    }
}

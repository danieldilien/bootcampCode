package chapterSix;

import general.TestShopScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Daniel on 21/07/2017.
 */
public class ValidateSupplierProduct extends TestShopScenario {
    @Test
    public void validateSupplierProductTest(){
        goToHomePage();
        maximizeWindow();
        goToAppleSupplier();
        List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='center_column']"));
        boolean macAir = false;
        for(WebElement e : elements) {
            if(e.getText().contains("MacBook Air"))
                macAir = true;
        }
        assertThat(macAir).isTrue();
    }
}

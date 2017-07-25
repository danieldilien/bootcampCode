package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Daniel on 24/07/2017.
 */
public class MyWishListPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "name")
    private WebElement wishListInputName;
    @FindBy(id = "submitWishlist")
    private WebElement saveButton;
    @FindBy(xpath = ".//*[@id='block-history']/table/tbody")
    private WebElement wishListTable;
    @FindBy(xpath = ".//*[@id='block-history']/table/thead/tr/th")
    private List<WebElement> wishListHeaderRow;
    private Alert alertWindow;
    private List<WebElement> rows;

    public MyWishListPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        //This call sets the Webelements
        PageFactory.initElements(driver, this);

    }
    public void addNewWishlist (String nameOfWishList){
        wishListInputName.clear();
        wishListInputName.sendKeys(nameOfWishList);
        saveButton.click();
    }
    public int getRowOfWishListWithName (String searchWishListName){
        rows = wishListTable.findElements(By.tagName("tr"));
        String wishListName;
        int rowOfWishListName=100;
        for(int rnum=0;rnum<rows.size();rnum++){
            wishListName = rows.get(rnum).findElement(By.xpath("td[1]/a")).getText();
            if(wishListName.contains(searchWishListName))
            {
                rowOfWishListName = rnum;
                break;
            }
        }
        return rowOfWishListName;
    }
    public boolean isWishListPresentWithName (String searchWishListName){
        int columnNumberOfName = getColumnNumberWithText("Name");
        rows = wishListTable.findElements(By.tagName("tr"));
        String wishListName;
        boolean wishListPresent=false;
        for(int rnum=0;rnum<rows.size();rnum++){
            wishListName = rows.get(rnum).findElement(By.xpath("td["+columnNumberOfName+"]/a")).getText();
            if(wishListName.contains(searchWishListName))
            {
                wishListPresent = true;
                break;
            }
        }
        return wishListPresent;
    }
    public void deleteWishListWithName(String searchWishListName){
        int columnNumberOfDelete = getColumnNumberWithText("Delete");
        int rowToDelete = getRowOfWishListWithName(searchWishListName);
        rows.get(rowToDelete).findElement(By.xpath("td["+columnNumberOfDelete+"]/a")).click();
        alertWindow = driver.switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
    public void waitForWishlistToReload(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }
    public int getColumnNumberWithText (String headerSearchText){

        int columnOfHeader=100;
        for(int columns = 0 ; columns<wishListHeaderRow.size();columns++) {
            String headerText = wishListHeaderRow.get(columns).getText();
            if(headerText.contains(headerSearchText))
            {
                columnOfHeader = columns + 1;
                break;
            }
        }
        return columnOfHeader;
    }
}

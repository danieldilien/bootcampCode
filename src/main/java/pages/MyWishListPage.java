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
    private WebElement wishListTableBody;
    @FindBy(xpath = ".//*[@id='block-history']/table/thead/tr/th")
    private List<WebElement> wishListTableHead;
    private Alert alertWindow;
    private List<WebElement> rows;
    private int wishListRow;

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
    public void deleteWishListWithName(String searchWishListName){
        int columnNumberOfDelete = getColumnNumberWithText("Delete");
        if(isWishListPresent(searchWishListName)) {
            rows.get(wishListRow).findElement(By.xpath("td[" + columnNumberOfDelete + "]/a")).click();
            alertWindow = driver.switchTo().alert();
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        }
        else{
            addNewWishlist(searchWishListName);
            deleteWishListWithName(searchWishListName);
        }
    }
    public boolean isWishListPresent (String searchWishListName) {
        int columnNumberOfName = getColumnNumberWithText("Name");
        rows = wishListTableBody.findElements(By.tagName("tr"));
        boolean wishListPresent = false;

        for (int rnum = 0; rnum < rows.size(); rnum++) {
            String wishListName = rows.get(rnum).findElement(By.xpath("td[" + columnNumberOfName + "]/a")).getText();
            if (wishListName.contains(searchWishListName)) {
                wishListPresent = true;
                this.wishListRow = rnum;
                break;
            }
        }

        return wishListPresent;
    }
    public int getColumnNumberWithText (String headerSearchText){
        int columnOfHeader = 0;
        for(int columns = 0 ; columns<wishListTableHead.size();columns++) {
            String headerText = wishListTableHead.get(columns).getText();
            if(headerText.contains(headerSearchText))
            {
                columnOfHeader = columns + 1;
                break;
            }
        }
        return columnOfHeader;
    }
    public void waitForWishlistToReload(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }
}

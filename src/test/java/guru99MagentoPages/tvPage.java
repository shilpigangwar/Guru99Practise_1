package guru99MagentoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anshul on 7/6/2017.
 */
public class tvPage {
    WebDriver driver;
    By addToWishListforLGLCG = By.xpath ( "html/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/ul/li[1]/a" );
    By shareWishlistbuttonforLGLCD = By.xpath ( "//button[@name='save_and_share']" );
    By shareWishlistEmailId = By.id ( "email_address" );
    By shareWishlistMessage = By.id ( "message" );
    By shareWishlistButton = By.xpath ( "(//button[@type='submit'])[2]" );
    By shareWishlistConfirmationMessage = By.xpath ( "//html[@id='top']/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span" );

    public tvPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddTowishlistForLGLCD() {
        driver.findElement ( addToWishListforLGLCG ).click ();
    }

    public void clickShareWishlistButtonforLGLCD() {
        driver.findElement ( shareWishlistbuttonforLGLCD ).click ();
    }

    public void enterEmailIdforWishlistSharing(String WEmailId) {
        driver.findElement ( shareWishlistEmailId ).sendKeys ( WEmailId );
    }

    public void enterMessageforWishlistSharing(String WMessage) {
        driver.findElement ( shareWishlistMessage ).sendKeys ( WMessage );
    }

    public void clickShareWishListButton() {
        driver.findElement ( shareWishlistButton ).click ();
    }

    public Boolean sharewishlistConfirmationMessageDisplayed() {
        return driver.findElement ( shareWishlistConfirmationMessage ).isDisplayed ();
    }

    public String sharewishlistConfirmationMessageText() {
        return driver.findElement ( shareWishlistConfirmationMessage ).getText ();
    }
}

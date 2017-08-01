package guru99MagentoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anshul on 6/20/2017.
 */
public class shoppingCartPage {
    WebDriver driver;
    By prodQTY = By.xpath ( "html/body/div[1]/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input" );
    By updateBTN = By.xpath ( "html/body/div[1]/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button" );
    By errorMsgOnUpdateBtn = By.cssSelector ( ".error-msg>ul>li" );
    By emptyCartbtn = By.id ( "empty_cart_button" );
    By emptyCartMsg = By.xpath ( "html/body/div/div/div[2]/div/div/div[1]/h1" );


    public shoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void updateProdQTY() {
        driver.findElement ( prodQTY ).isEnabled ();
        driver.findElement ( prodQTY ).clear ();
        driver.findElement ( prodQTY ).sendKeys ( String.valueOf ( 1000 ) );
        driver.findElement ( updateBTN ).submit ();
        //driver.findElement ( updateBTN ).click ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

    }

    public String ErrorMsgOnUpdateBtn() {
        if (driver.findElement ( errorMsgOnUpdateBtn ).isDisplayed ()) {
            String result = driver.findElement ( errorMsgOnUpdateBtn ).getText ();
            return result;
        } else {
            System.out.println ( "Error message not displayed" );

            return null;
        }
    }

    public void clickEmptyCartLink() {
        driver.findElement ( emptyCartbtn ).click ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public String emptyCartMsg() {
        System.out.println ( driver.findElements ( emptyCartMsg ).get ( 0 ).getText () );
        return driver.findElements ( emptyCartMsg ).get ( 0 ).getText ();
    }

}

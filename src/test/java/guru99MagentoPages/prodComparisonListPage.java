package guru99MagentoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Anshul on 6/21/2017.
 */
public class prodComparisonListPage {
    WebDriver driver;

    By prodComparisonListPageTitle = By.tagName ( "title" );
    By product1 = By.linkText ( "Sony Xperia" );
    By product2 = By.linkText ( "IPhone" );
    //By closeWindow = By.cssSelector ( "div.buttons-set > button.button" );
    By closeWindow = By.xpath ( "//button[@title='Close Window']" );

    public prodComparisonListPage(WebDriver driver) {
        this.driver = driver;
    }

    public String popUpWindowOpened() {

        // driver.findElement ( prodComparisonListPageTitle ).isEnabled ();
        return driver.findElement ( prodComparisonListPageTitle ).getText ();
    }


    public String product1Present() {
        driver.findElement ( product1 ).isDisplayed ();
        return driver.findElement ( product1 ).getText ();
    }

    public String product2Present() {
        driver.findElement ( product2 ).isDisplayed ();
        return driver.findElement ( product2 ).getText ();
    }

    public void closeWindow() {
        //driver.findElement (closeWindow ).isEnabled ();
        //driver.findElement (closeWindow ).click ();
        driver.close ();
    }


}




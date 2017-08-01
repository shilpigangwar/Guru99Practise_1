package guru99MagentoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anshul on 6/20/2017.
 */
public class MobileDetailPageSonyExperia {
    WebDriver driver;
    By priceSonyExpMobileDetailPage = By.id ( "product-price-1" );

    public MobileDetailPageSonyExperia(WebDriver driver) {
        this.driver = driver;
    }

    public String priceSonyExperiaOnMobileDetailPage() {

        System.out.println ( driver.findElement ( priceSonyExpMobileDetailPage ).getText () );
        return driver.findElement ( priceSonyExpMobileDetailPage ).getText ();
    }


}

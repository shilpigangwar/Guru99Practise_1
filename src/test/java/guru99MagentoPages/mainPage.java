package guru99MagentoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anshul on 6/15/2017.
 */
public class mainPage {
    WebDriver driver;
    By mainPageTitlename = By.tagName ( "title" );
    By mainPageText = By.tagName ( "h2" );
    By mainPageMobileLink = By.linkText ( "Mobile" );
    By mainPageAccountlink = By.linkText ( "Account" );
    By mainPageMyAccountLink = By.linkText ( "My Account" );
    By mainPageTvLink = By.linkText ( "TV" );
    By loginEmail = By.id ( "email" );
    By loginPassword = By.id ( "pass" );
    By loginButton = By.id ( "send2" );
    By userMyWishlist = By.xpath ( "html/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a" );
    By userAddToCartButton = By.xpath ( "html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/table/tbody/tr/td[5]/div/button" );
    By estimateLink = By.cssSelector ( "div.buttons-set:nth-child(3) > button:nth-child(1)" );
    By proceedToCheckOut = By.xpath ( "(//button[@type='button'])[5]" );
    By infoBillingCompany = By.id ( "billing:company" );
    By infoBillingAddress = By.id ( "billing:street1" );
    By estimateShippingState = By.id ( "region_id" );

    By estiimateShippingZip = By.id ( "postcode" );
    By flatRate = By.xpath ( "html/body/div/div/div[2]/div/div/div/div[2]/div/div/form[2]/dl/dd/ul/li/label" );
    By selectShippingcost = By.id ( "s_method_flatrate_flatrate" );
    By updateTotal = By.cssSelector ( "button[name=\"do\"]" );
    By shippingcostTextOnUpdate = By.xpath ( "html/body/div/div/div[2]/div/div/div/div[3]/div/table/tbody/tr[2]/td[1]" );
    By shippingCostIncluded = By.xpath ( "html/body/div/div/div[2]/div/div/div/div[3]/div/table/tbody/tr[2]/td[2]/span" );
    By infoCity = By.id ( "billing:city" );
    By infoState = By.id ( "billing:region_id" );
    By infoStateNY = By.cssSelector ( "option[title=\"New York\"]" );
    By infoBillingZipCode = By.id ( "billing:postcode" );
    By infoTelephone = By.id ( "billing:telephone" );
    By continueAddressPage = By.xpath ( "html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button" );
    By continueShiipingMethod = By.xpath ( "html/body/div/div/div[2]/div/div[1]/ol/li[3]/div[2]/form/div[3]/button" );
    By checkOrMoneyOrder = By.id ( "p_method_checkmo" );
    By continuePaymentMode = By.xpath ( "html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/div[2]/button" );
    By placeOrderButton = By.xpath ( "html/body/div/div/div[2]/div/div[1]/ol/li[5]/div[2]/div/div[2]/div/button/span" );
    By orderNumber = By.xpath ( "html/body/div/div/div[2]/div/div/p[1]/a" );
    By userMyOrders = By.xpath ( "html/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a" );
    By userViewOrder = By.linkText ( "View Order" );
    By recentOrder = By.xpath ( "html/body/div/div/div[2]/div/div[2]/div/div/div[3]/div/h2" );
    By recentOrderTable = By.xpath ( "html/body/div/div/div[2]/div/div[2]/div/div/div[3]" );
    By orderStatus = By.xpath ( "html/body/div/div/div[2]/div/div[2]/div/div/div[3]/table/tbody/tr/td[5]/em" );
    By printOrderLink = By.linkText ( "Print Order" );
    By ReorderLink = By.xpath ( "html/body/div/div/div[2]/div/div[2]/div/div/div[3]/table/tbody/tr/td[6]/span/a[2]" );
    By inputQnty = By.xpath ( "html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input" );
    By updateButton = By.xpath ( "html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button" );
    By grandtotal = By.xpath ( "html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span" );

    public mainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String mainPageTitleName() {
        return driver.findElement ( mainPageTitlename ).getText ();
    }

    public String mainPageText() {
        return driver.findElement ( mainPageText ).getText ();
    }

    public void clickMobileMenu() {
        driver.findElement ( mainPageMobileLink ).click ();
        try {
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.out.println ( driver.getCurrentUrl () );

    }

    public void clickAccountLink() {
        driver.findElement ( mainPageAccountlink ).click ();
    }

    public void clickMyAccountLink() {
        driver.findElement ( mainPageMyAccountLink ).click ();
    }

    public void clickTVMenu() {
        driver.findElement ( mainPageTvLink ).click ();
    }

    public void enterUserEmailid(String LEmail) {
        driver.findElement ( loginEmail ).sendKeys ( LEmail );
    }

    public void enterUserPassword(String LPassword) {
        driver.findElement ( loginPassword ).sendKeys ( LPassword );
    }

    public void clickLoginButton() {
        driver.findElement ( loginButton ).click ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        for (String handle : driver.getWindowHandles ()) {
            driver.switchTo ().window ( handle );
        }
    }

    public void clickUserMyWishlistLink() {
        driver.findElement ( userMyWishlist ).isEnabled ();
        driver.findElement ( userMyWishlist ).click ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public void clickUserAddToCartButton() {
        driver.findElement ( userAddToCartButton ).click ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

    }

    public void selectestimateshippingStateAndZip() {
        driver.findElement ( estimateShippingState ).click ();
        try {
            Thread.sleep ( 5000 );
            driver.findElement ( estimateShippingState ).sendKeys ( "NEW YORK" );
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        driver.findElement ( estiimateShippingZip ).sendKeys ( "542896" );
    }

    public void clickEstimatelink() {
        driver.findElement ( estimateLink ).click ();
        try {
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public String shippingcostgenerated() {
        return driver.findElement ( flatRate ).getText ();
    }

    public void selectShippingcost() {
        driver.findElement ( selectShippingcost ).click ();
    }

    public void clickUpdateTotal() {
        driver.findElement ( updateTotal ).click ();
    }

    public boolean shippingcostTextUpdated() {
        return driver.findElement ( shippingcostTextOnUpdate ).isDisplayed ();
    }

    public String shippingCostIncluded() {
        return driver.findElement ( shippingCostIncluded ).getText ();
    }

    public void clickProceedToCheckOut() {
        driver.findElement ( proceedToCheckOut ).click ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public void enterBillingCompany(String BCompany) {
        driver.findElement ( infoBillingCompany ).clear ();
        driver.findElement ( infoBillingCompany ).sendKeys ( BCompany );
    }

    public void enterBillingaddress1(String AddL1) {
        driver.findElement ( infoBillingAddress ).isEnabled ();
        driver.findElement ( infoBillingAddress ).clear ();
        driver.findElement ( infoBillingAddress ).sendKeys ( AddL1 );
    }

    public void enterBillingCity(String BCity) {
        driver.findElement ( infoCity ).clear ();
        driver.findElement ( infoCity ).sendKeys ( BCity );
    }

    public void selectState() {
        driver.findElement ( infoState ).click ();
        try {
            Thread.sleep ( 5000 );
            driver.findElement ( infoState ).sendKeys ( "NEW YORK" );
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }


    }

    public void enterZipCode(String BZip) {
        driver.findElement ( infoBillingZipCode ).clear ();
        driver.findElement ( infoBillingZipCode ).sendKeys ( BZip );
    }

    public void enterTelephoneNumber(String BTele) {
        driver.findElement ( infoTelephone ).clear ();
        driver.findElement ( infoTelephone ).sendKeys ( BTele );
    }

    public void clickContinueButton() {
        driver.findElement ( continueAddressPage ).click ();
        try {
            Thread.sleep ( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public void clickContinueShippingMethod() {
        driver.findElement ( continueShiipingMethod ).click ();
        try {
            Thread.sleep ( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public void selectCheckOrMoneyOrder() {
        driver.findElement ( checkOrMoneyOrder ).click ();
    }

    public void clickContinuePaymentMode() {
        driver.findElement ( continuePaymentMode ).click ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public void clickPlaceOrderButton() {
        driver.findElement ( placeOrderButton ).click ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public boolean orderNumberGenerated() {
        return driver.findElement ( orderNumber ).isDisplayed ();
    }

    public String ordernumberStore() {
        return driver.findElement ( orderNumber ).getText ();
    }

    public void clickMyOrder() {
        driver.findElement ( userMyOrders ).click ();
        try {
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public void clickViewOrder() {
        driver.findElement ( userViewOrder ).click ();
        try {
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public boolean recentOrdersPresent() {
        System.out.println ( driver.findElement ( recentOrder ).getText () );
        return driver.findElement ( recentOrder ).isDisplayed ();
    }

    public void findOrderNoInRecntOrderTable(String OrderNo) {
        if (driver.findElement ( recentOrderTable ).getText ().contains ( OrderNo )) {
            System.out.println ( "The orderNumber " + OrderNo + " is present in Recent Orders." );
        } else {
            System.out.println ( "The orderNumber " + OrderNo + " is not present in Recent Orders." );
        }
    }

    public String checkorderStatus() {
        return driver.findElement ( orderStatus ).getText ();
    }

    public void clickPrintOrderLink() {
        driver.findElement ( printOrderLink ).click ();
    }

    public void clickReorderlink() {
        driver.findElement ( ReorderLink ).click ();
        try {
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public void updateProdQuantity() {
        driver.findElement ( inputQnty ).clear ();
        driver.findElement ( inputQnty ).sendKeys ( "10" );
    }

    public void clickUpdateButton() {
        driver.findElement ( updateButton ).click ();
        try {
            Thread.sleep ( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public String grandtotal() {
        return driver.findElement ( grandtotal ).getText ();
    }
}


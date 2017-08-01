package guru99MagentoTest;


import guru99MagentoPages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Created by Anshul on 6/15/2017.
 */
public class guruTest {
    WebDriver driver;
    mainPage objMainPage;
    mobilePage objMobilePage;
    MobileDetailPageSonyExperia objSonyExpDetailPage;
    shoppingCartPage objshoppingCartPage;
    prodComparisonListPage objprodCom;
    createNewCustomerAccountPage objCreateAccount;
    tvPage objtvPage;


    @BeforeTest
    public void setup() {
        System.setProperty ( "webdriver.gecko.driver", "C:\\Users\\Anshul\\Downloads\\geckodriver-v0.17.0-win32\\geckodriver.exe" );
        driver = new FirefoxDriver ();
        driver.get ( "http://live.guru99.com/index.php/" );
        objMainPage = new mainPage ( driver );
        objMobilePage = new mobilePage ( driver );
        objSonyExpDetailPage = new MobileDetailPageSonyExperia ( driver );
        objshoppingCartPage = new shoppingCartPage ( driver );
        objprodCom = new prodComparisonListPage ( driver );
        objCreateAccount = new createNewCustomerAccountPage ( driver );
        objtvPage = new tvPage ( driver );


    }


    @AfterTest
    public void tearDown() {
        driver.quit ();
        //Dummy test

    }

    @Test(priority = 0)
    public void mobileListPageSortedByName() {

        //Verify the title of the page
        Assert.assertTrue ( objMainPage.mainPageTitleName ().contentEquals ( "Home page" ) );
        //verify the text " This is demo site" is displayed on main page
        Assert.assertEquals ( "THIS IS DEMO SITE FOR   ", objMainPage.mainPageText () );
        System.out.println ( "Text 'This is demo site' is displayed on page." );
        objMainPage.clickMobileMenu ();
        Assert.assertTrue ( objMobilePage.mobilePageTitleName ().contentEquals ( "Mobile" ) );

        Assert.assertEquals ( true, objMobilePage.mobilePageSetSortByName () );
        Assert.assertTrue ( objMobilePage.sortedProductName () );


    }

    @Test(priority = 1)
    public void costOfProductOnListPage_DetailPage_equal() {

        //click on Mobile menu
        objMainPage.clickMobileMenu ();
        //Read the value of sony experia from Mobile list page
        System.out.println ( "Value on Mobile list page is " + objMobilePage.PriceSonyExperiaOnMobilListPage () );
        //click on Sony Experia
        objMobilePage.clickSonyExperiaNavigatingToNextPage ();
        //Read the value of sony Experia from detail page
        System.out.println ( "Value on Mobile Detail page is " + objSonyExpDetailPage.priceSonyExperiaOnMobileDetailPage () );
        //compare the values of sony experia on both the pages
        Assert.assertEquals ( "Values is not equal", objSonyExpDetailPage.priceSonyExperiaOnMobileDetailPage (), objMobilePage.PriceSonyExperiaOnMobilListPage () );

    }

    @Test(priority = 2)
    public void cannotAddMoreProdInCartThanAvailableInStore() {

        //click on Mobile menu
        objMainPage.clickMobileMenu ();
        //Click on Add to cart for Sony Experia
        objMobilePage.clickAddtoCartButtonSonyExperia ();
        //update QTY to 1000
        objshoppingCartPage.updateProdQTY ();
        //Verify the error message shown for requested quantity
        Assert.assertTrue ( objshoppingCartPage.ErrorMsgOnUpdateBtn ().equalsIgnoreCase ( "Some of the products cannot be ordered in requested quantity." ) );
        //Click the Empty cart link
        objshoppingCartPage.clickEmptyCartLink ();
        //Verify that cart id empty
        Assert.assertTrue ( objshoppingCartPage.emptyCartMsg ().equalsIgnoreCase ( "Shopping Cart is Empty" ) );
    }

    @Test(priority = 3)
    public void compareTwoProducts() throws InterruptedException {

        //Click on Mobile menu
        objMainPage.clickMobileMenu ();
        //Click add to compare for two mobiles p1- sony experia & p2- Iphone
        objMobilePage.addToCompareTwoProducts ();
        //click on compare button
        objMobilePage.clickCompareButton ();
        String mainWindow = driver.getWindowHandle ();
        for (String handle : driver.getWindowHandles ()) {
            driver.switchTo ().window ( handle );
        }
        //Verify Popup window and check that the products are reflected in it
        Assert.assertTrue ( objprodCom.popUpWindowOpened ().equalsIgnoreCase ( "Products Comparison List - Magento Commerce" ) );
        Assert.assertTrue ( objprodCom.product1Present ().equalsIgnoreCase ( "Sony Xperia" ) );
        Assert.assertTrue ( objprodCom.product2Present ().equalsIgnoreCase ( "IPhone" ) );
        //close the pop up window
        objprodCom.closeWindow ();
        driver.switchTo ().window ( mainWindow );
        //driver.close();
    }

    @Test(priority = 4)
    public void createAccountShareWishList() throws InterruptedException {

        //click on my Account link
        objMainPage.clickAccountLink ();
        objMainPage.clickMyAccountLink ();
        //Click Create Account Link and Fill New user information except Email Id
        objCreateAccount.clickCreateAccountButton ();
        objCreateAccount.enterFirstName ();
        objCreateAccount.enterLastName ();
        objCreateAccount.enterRegisterEmailId ();
        objCreateAccount.enterPassword ();
        objCreateAccount.enterConfirmationpassword ();
        //Click register
        objCreateAccount.clickRegisterButton ();
        //Verify registration is done
        Assert.assertTrue ( objCreateAccount.registrationMessageDispalyed () );
        System.out.println ( "Message Displayed" + objCreateAccount.registrationMessageText () );
        //Go To TV menu and Add product in your wishlist
        objMainPage.clickTVMenu ();
        objtvPage.clickAddTowishlistForLGLCD ();
        //Click Share Wishlist
        objtvPage.clickShareWishlistButtonforLGLCD ();
        //Next page enter email id and a message and click SHARE WISHLIST
        objtvPage.enterEmailIdforWishlistSharing ( "raju999888@gmail.com" );
        objtvPage.enterMessageforWishlistSharing ( "Happy Shopping!!! Enjoy It !!!" );
        objtvPage.clickShareWishListButton ();
        //Check wishList is shared
        Assert.assertTrue ( objtvPage.sharewishlistConfirmationMessageDisplayed () );
        System.out.println ( "Message displayed:" + objtvPage.sharewishlistConfirmationMessageText () );
    }

    @Test(priority = 5)
    public void userPurchaseProductWithRegisteredEmailId() {

        //click on my Account link
        objMainPage.clickAccountLink ();
        objMainPage.clickMyAccountLink ();
        //Login application using created credentials
        objMainPage.enterUserEmailid ( "nshul123@gmail.com" );
        objMainPage.enterUserPassword ( "qaz123" );
        objMainPage.clickLoginButton ();
        //Click on My Wish list Link
        objMainPage.clickUserMyWishlistLink ();
        //Next page click add to cart link
        objMainPage.clickUserAddToCartButton ();
        objMainPage.selectestimateshippingStateAndZip ();
        //click Estimate
        objMainPage.clickEstimatelink ();
        //Verify shipping cost generated
        System.out.println ( objMainPage.shippingcostgenerated () );
        Assert.assertTrue ( objMainPage.shippingcostgenerated ().equalsIgnoreCase ( "Fixed - $5.00" ) );
        //Select shipping cost and update total
        objMainPage.selectShippingcost ();
        objMainPage.clickUpdateTotal ();
        //verify shipping cost is added to total

        Assert.assertTrue ( objMainPage.shippingcostTextUpdated () == true );
        System.out.println ( objMainPage.shippingCostIncluded () );
        Assert.assertTrue ( objMainPage.shippingCostIncluded ().equalsIgnoreCase ( "$5.00" ) );
        //click proceed to checkout
        objMainPage.clickProceedToCheckOut ();
        //Enter shipping information
        objMainPage.enterBillingaddress1 ( "10223 st14" );
        objMainPage.enterBillingCompany ( "tech" );
        objMainPage.enterBillingCity ( "New York" );
        objMainPage.selectState ();
        objMainPage.enterZipCode ( "542896" );
        objMainPage.enterTelephoneNumber ( "12345678" );
        //in Shipping method click continue
        objMainPage.clickContinueButton ();
        objMainPage.clickContinueShippingMethod ();
        //In payment information select 'check /Money order radio button. click continue
        objMainPage.selectCheckOrMoneyOrder ();
        objMainPage.clickContinuePaymentMode ();
        //Click Place order button
        objMainPage.clickPlaceOrderButton ();
        //verify order is generated and note the order number
        Assert.assertTrue ( objMainPage.orderNumberGenerated () == true );
        System.out.println ( "Your order # is:" + objMainPage.ordernumberStore () );

    }

    @Test(priority = 6)
    public void savePreviousOrderAsPDF() {

        //click on my Account Link
        objMainPage.clickAccountLink ();
        objMainPage.clickMyAccountLink ();
        //Login to application using previously created credentials
        objMainPage.enterUserEmailid ( "nshul123@gmail.com" );
        objMainPage.enterUserPassword ( "qaz123" );
        objMainPage.clickLoginButton ();
        //verify previously created order is displayed in recent Orders table and Status is Pending
        Assert.assertTrue ( objMainPage.recentOrdersPresent () == true );
        objMainPage.findOrderNoInRecntOrderTable ( "100004758" );
        Assert.assertEquals ( "Pending", (objMainPage.checkorderStatus ()) );
        //Click on My Orders
        objMainPage.clickMyOrder ();
        //Click on view Orders
        objMainPage.clickViewOrder ();
        //Click on Print Order link
        objMainPage.clickPrintOrderLink ();
        //Verify Order is saved as PDF
    }

    @Test(priority = 7)
    public void changeOrReorderProduct() {

        //click on my Account Link
        objMainPage.clickAccountLink ();
        objMainPage.clickMyAccountLink ();
        //Login to application using previously created credentials
        objMainPage.enterUserEmailid ( "nshul123@gmail.com" );
        objMainPage.enterUserPassword ( "qaz123" );
        objMainPage.clickLoginButton ();
        //click on Reorder and change the quantity and click update
        objMainPage.clickReorderlink ();
        String GTBefore = objMainPage.grandtotal ();
        System.out.println ( "The grand total before updating is " + objMainPage.grandtotal () );
        objMainPage.updateProdQuantity ();
        objMainPage.clickUpdateButton ();
        //Verify that grand total is changed
        String GTAfter = objMainPage.grandtotal ();
        System.out.println ( "Now the grand total has been changed to " + objMainPage.grandtotal () );
        Assert.assertFalse ( GTBefore.matches ( GTAfter ) );
        objMainPage.selectestimateshippingStateAndZip ();
        objMainPage.clickEstimatelink ();
        objMainPage.selectShippingcost ();
        objMainPage.clickUpdateTotal ();

        objMainPage.clickProceedToCheckOut ();
        //Enter shipping information
        objMainPage.clickContinueButton ();
        objMainPage.clickContinueShippingMethod ();
        //In payment information select 'check /Money order radio button. click continue
        objMainPage.selectCheckOrMoneyOrder ();
        objMainPage.clickContinuePaymentMode ();
        //Click Place order button
        objMainPage.clickPlaceOrderButton ();
        Assert.assertTrue ( objMainPage.orderNumberGenerated () == true );
        System.out.println ( "Your order # is:" + objMainPage.ordernumberStore () );

    }


}


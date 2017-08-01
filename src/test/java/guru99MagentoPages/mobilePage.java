package guru99MagentoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Anshul on 6/15/2017.
 */
public class mobilePage {
    WebDriver driver;
    By mobilePageTitlename = By.tagName ( "title" );
    By mobilePageSortBy = By.cssSelector ( "select[title=\"Sort By\"]" );
    By mobilePageSortOption = By.cssSelector ( "option[value=\"http://live.guru99.com/index.php/mobile.html?dir=asc&order=name\"]" );
    By priceSonyExpMobileListPage = By.cssSelector ( "#product-price-1 > span.price" );
    By css = By.cssSelector ( "h2.product-name > a[title]" );
    By sonyExperiaDetailLink = By.linkText ( "Sony Xperia" );
    By sonyExperiaAddToCartlink = By.xpath ( "(//button[@type='button'])[3]" );
    By addToCompareForSonyXperia = By.xpath ( ".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a" );
    By addToCompareForIphone = By.xpath ( ".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a" );
    By clickCompareButton = By.cssSelector ( "div.block-content > div.actions > button.button" );
    By addToCartIphone = By.xpath ( "html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button" );
    By discountCode = By.xpath ( "html/body/div/div/div[2]/div/div/div/div[2]/form/div/div/div/input" );
    By applyLink = By.xpath ( "html/body/div/div/div[2]/div/div/div/div[2]/form/div/div/div/div/button" );

    public mobilePage(WebDriver driver) {
        this.driver = driver;
    }
    //String ParentHandle = driver.getWindowHandle ();


    public String mobilePageTitleName() {
        System.out.println ( driver.getTitle () );
        return driver.findElement ( mobilePageTitlename ).getText ();
    }

    public boolean mobilePageSetSortByName() {
        driver.findElement ( mobilePageSortBy ).click ();
        driver.findElement ( mobilePageSortOption ).isEnabled ();
        driver.findElement ( mobilePageSortOption ).click ();
        try {
            Thread.sleep ( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        return driver.findElement ( mobilePageSortOption ).isSelected ();
    }


    public boolean sortedProductName() {

        List <WebElement> elements = driver.findElements ( css );
        List <String> nameList = new ArrayList <String> ();

        for (WebElement element : elements) {
            nameList.add ( element.getText () );
        }

        boolean isSorted = false;
        for (int i = 0; i < nameList.size () - 1; i++) {

            if (nameList.get ( i ).compareTo ( nameList.get ( i + 1 ) ) < 0) {
                isSorted = true;
            } else {
                isSorted = false;
                break;
            }
        }

        return isSorted;
    }


    public String PriceSonyExperiaOnMobilListPage() {
        return driver.findElement ( priceSonyExpMobileListPage ).getText ();
    }

    public void clickSonyExperiaNavigatingToNextPage() {
        driver.findElement ( sonyExperiaDetailLink ).click ();
        try {
            Thread.sleep ( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.out.println ( driver.getTitle () );
    }

    public void clickAddtoCartButtonSonyExperia() {
        driver.findElement ( sonyExperiaAddToCartlink ).click ();
        try {
            Thread.sleep ( 3000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public void addToCompareTwoProducts() {
        driver.findElement ( addToCompareForSonyXperia ).click ();
        driver.findElement ( addToCompareForIphone ).click ();
        try {
            Thread.sleep ( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public void clickCompareButton() throws InterruptedException {
        Thread.sleep ( 2000 );
        driver.findElement ( clickCompareButton ).click ();
        Thread.sleep ( 2000 );

        //WebDriverWait wait = new WebDriverWait ( driver,15 );
        // wait.until( ExpectedConditions.titleIs ("Products Comparison List - Magento Commerce"));

    }

    /*  public  void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
          String cHandle = driver.getWindowHandle();
          String newWindowHandle = null;
          Set<String> allWindowHandles = driver.getWindowHandles();

          //Wait for 20 seconds for the new window and throw exception if not found
          for (int i = 0; i < 20; i++) {
              if (allWindowHandles.size() > 1) {
                  for (String allHandlers : allWindowHandles) {
                      if (!allHandlers.equals(cHandle))
                          newWindowHandle = allHandlers;
                  }
                  driver.switchTo().window(newWindowHandle);
                  break;
              } else {
                  Thread.sleep(1000);
              }
          }
          if (cHandle == newWindowHandle) {
              throw new RuntimeException(
                      "Time out - No window found");
          }*/
    public void waitForNewWindowAndSwitchToIt() {
        for (String handle : driver.getWindowHandles ()) {
            driver.switchTo ().window ( handle );
        }
    }

    public void switchBackToParent() {
        String mainWindow;
        mainWindow = driver.getWindowHandle ();
        driver.switchTo ().window ( mainWindow );
    }

    public void setAddToCartIphone() {
        driver.findElement ( addToCartIphone ).click ();
    }

    public void enterDiscountCode() {
        driver.findElement ( discountCode ).isEnabled ();
        driver.findElement ( discountCode ).sendKeys ( "GURU50" );
        driver.findElement ( applyLink ).click ();
    }

}





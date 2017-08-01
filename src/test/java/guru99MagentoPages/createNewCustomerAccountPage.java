package guru99MagentoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Anshul on 7/6/2017.
 */
public class createNewCustomerAccountPage {
    WebDriver driver;
    By createAccountButton = By.linkText ( "Create an Account" );
    By fieldFirstName = By.id ( "firstname" );
    By fieldLastName = By.id ( "lastname" );
    By registerEmailId = By.id ( "email_address" );
    By password1 = By.id ( "password" );
    By confirmationPassword = By.id ( "confirmation" );
    By registerButton = By.xpath ( "html/body/div/div/div[2]/div/div/div/form/div[2]/button" );
    By registrationmessage = By.xpath ( "html/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span" );

    public createNewCustomerAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateAccountButton() throws InterruptedException {
        driver.findElement ( createAccountButton ).click ();
        WebDriverWait wait = new WebDriverWait ( driver, 300 );
        wait.until ( ExpectedConditions.visibilityOf ( driver.findElement ( fieldFirstName ) ) );
    }

    public void enterFirstName() {
        String Fname = "Anshul";
        //driver.findElement ( fieldFirstName ).isEnabled ();
        driver.findElement ( fieldFirstName ).sendKeys ( Fname );
    }


    public void enterLastName() {
        driver.findElement ( fieldLastName ).isEnabled ();
        driver.findElement ( fieldLastName ).sendKeys ( "Sachan" );
    }

    public void enterRegisterEmailId() {
        driver.findElement ( registerEmailId ).isEnabled ();
        driver.findElement ( registerEmailId ).sendKeys ( "nshul123@gmail.com" );
    }

    public void enterPassword() {
        driver.findElement ( password1 ).isEnabled ();
        driver.findElement ( password1 ).sendKeys ( "qaz123" );
    }

    public void enterConfirmationpassword() {
        driver.findElement ( confirmationPassword ).isEnabled ();
        driver.findElement ( confirmationPassword ).sendKeys ( "qaz123" );
    }

    public void clickRegisterButton() {
        driver.findElement ( registerButton ).click ();

    }

    public Boolean registrationMessageDispalyed() {
        return driver.findElement ( registrationmessage ).isDisplayed ();
    }

    public String registrationMessageText() {
        return driver.findElement ( registrationmessage ).getText ();
    }
}

package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/*Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
 1. LoginTest
 */
public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }

    @Test
    /*3. Write down the following test into ‘LoginTest’ class
      1. userSholdLoginSuccessfullyWithValidCredentials
     * Enter “tomsmith” username * Enter “SuperSecretPassword!” password
     * Click on ‘LOGIN’ button * Verify the text “Secure Area” is not working so did on
     "Welcome to the Secure Area. When you are done click logout below."
     */
    public void userShouldLoginSuccessfullyWithValidCredentials (){
        sendKeysToElement(By.xpath("//input[@id='username']"), "tomsmith");
        sendKeysToElement(By.xpath("//input[@id='password']"), "SuperSecretPassword!");
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        String actualmes = getTextFromElement(By.xpath("//h4[@class='subheader']"));
        System.out.println(actualmes);
        String expectedmes = "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(expectedmes,actualmes);
    }
    @Test
    /*2. verifyTheUsernameErrorMessage
     * * Enter “tomsmith1” username * Enter “SuperSecretPassword!” password
     * * Click on ‘LOGIN’ button * Verify the error message “Your username is invalid!” i can't get the mes so did with Login
     */
    public void verifyTheUsernameErrorMessage () {
        sendKeysToElement(By.xpath("//input[@id='username']"), "tomsmith1");
        sendKeysToElement(By.xpath("//input[@id='password']"), "SuperSecretPassword!");
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        String actualmes = getTextFromElement(By.xpath("//div[@id='flash']"));
        System.out.println(actualmes);
        String expectedmes = "Your username is invalid!\n×";
        Assert.assertEquals(expectedmes, actualmes);
    }
    @Test
    /*3. verifyThePasswordErrorMessage
     * Enter “tomsmith” username * Enter “SuperSecretPassword” password
     * Click on ‘LOGIN’ button
     * Verify the error message “Your password is invalid!”
     */
    public void verifyThePasswordErrorMessage () {
        sendKeysToElement(By.xpath("//input[@id='username']"), "tomsmith");
        sendKeysToElement(By.xpath("//input[@id='password']"), "SuperSecretPassword");
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        String actualmes = getTextFromElement(By.xpath("//div[@id='flash']"));
        System.out.println(actualmes);
        String expectedmes = "Your password is invalid!\n×";
        Assert.assertEquals(expectedmes, actualmes);
    }

    @After
    public void teardown (){
        //closebrowser();
    }
}

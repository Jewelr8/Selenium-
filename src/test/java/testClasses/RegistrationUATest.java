package testClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageElements.RegistrationUAPage;
import utility.BaseClasss;

import java.io.FileNotFoundException;

public class RegistrationUATest extends BaseClasss {

RegistrationUAPage registrationUAPage;
@Test
public void clickOnRegistration() {

    registrationUAPage = new RegistrationUAPage(driver);
    registrationUAPage.clickOnRegistration();
}

@Test
    public void validateRegistrationPage(){

        if (registrationUAPage.getRegistrationText().equalsIgnoreCase("Registration")
        ) {
            System.out.println("I am on the right page");
        }
        else {
            System.out.println("I am on the wrong page");
        }
    }





    //public RegistrationUATest() throws FileNotFoundException {
    //}




    /*
    TestCase 101--Verify that registration page displays all the required fields.
    TestCase 102--Verify that user should be able to register into the application.


    TestCase 102:

    Step-1: Enter the First Name.
    Step-2: Enter the Last Name.
    Step-3: Enter the Username.
    Step-4: Enter the Password.
    Step-5: Confirm Password.
    Step-6: Birth Day
    Step-7: Phone
    Step-8: Address
    Step-9: City
    Step-10: Zip
    Step-11: Country
    Step-12: Open Account


    There are some attribute/Locator that Selenium likes:

    i.  ID
    ii. Name
    iii.CLass
    iv. LinkText
    v.  Partial linkText
    vi. Xpath
    Vii.CSS Selector
     */

   // @Test // This method is identified as main annotation.

//    public void enterFirstName() throws InterruptedException {
//
//        driver.findElement(By.name("inputfname")).sendKeys("Jewel");
//
//        Thread.sleep(5000);
//
//    }
/*
When there are multiple test, the test executes alphabetically.
We can use the priority to control the execution flow.
 */

    //@Test (priority = 2)
    public void enterLastName() throws InterruptedException {
        driver.findElement(By.id("inputlname")).sendKeys("Hossain");

    }

    @Test
    public void enterFirstName() throws InterruptedException {
        WebElement FirstName = driver.findElement(By.name("inputfname"));
       FirstName.sendKeys("Jewel");

        // driver.findElement(By.name("inputfname")).sendKeys("Jewel");

    }

    @Test
    public void enterUsername() throws InterruptedException {
        driver.findElement(By.id("inputusername")).sendKeys("Jewel.Hossain");
        //Assert.assertFalse(true); // Forcefully making it fail

    }

    @Test (priority = 4,dependsOnMethods = "enterUsername")
    public void enterPassword() throws InterruptedException {
        driver.findElement(By.id("inputPassword4")).sendKeys("Learn@3");

    }

    @Test
    public void enterConfirmPassword() throws InterruptedException {
        driver.findElement(By.id("inputRePassword4")).sendKeys("Learn@3");

    }


    @Test
    public void enterBirthDay() throws InterruptedException {
        driver.findElement(By.id("inputbirth")).sendKeys("06-12-1982");
    }



     @Test
    public void enterPhoneNumber() throws InterruptedException {
        driver.findElement(By.id("inputphone")).sendKeys("3523393595");

    }

    @Test (priority = 8)
    public void enterAddress() throws InterruptedException {
        driver.findElement(By.name("inputaddress")).sendKeys("4906 Carolina Circle");

    }

    @Test (priority = 9)
    public void enterCity() throws InterruptedException {
        driver.findElement(By.id("inputCity")).sendKeys("Mckinney");

    }

    @Test (priority = 10)
    public void enterZipCode() throws InterruptedException {
        driver.findElement(By.id("inputZip")).sendKeys("75225");

    }


    @Test (groups = {"Regression"})
    public void enterCountry() throws InterruptedException {
        driver.findElement(By.id("inputcountry")).sendKeys("USA");

    }

//    @Test (priority = 12)
//    public void enterClick() throws InterruptedException {
//        driver.findElement(By.name("inputsubmit")).click();
//
//    }

//@Test
    public void submitButton() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy (0, 100)");
        Thread.sleep(3000);
        WebElement submit = driver.findElement(By.name("input submit"));
        submit.click();
        //CaptureScreenShotOnFailure(ITestResult result);
    }
@AfterMethod
    public void CaptureScreenShotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                screenshot(result.getName()+".png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

/*
TestNg is a testing framework. We can organize our test. There are some annotations against each method.
@Before Class
@Before Method
@Before Test
@Test ------   Main Annotation. Without @Test annotation, no other annotation will work.
               The class that holds the @Test annotation is the test class. Also, the Test Class is an alternative to the main method.so we do not need a main method.
@After Test
@After Method
@After Class


When priority is used, if one of teh methods does not use any priority that method would consider as priority 0, and will run first.
 */

    } }
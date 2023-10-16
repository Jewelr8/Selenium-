package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClasss extends CommonUtility {

    // System.setProperty("webDriver.chrome.driver", "/Users/jewel/Desktop/UprightTechSolutions/IntelliJ_SeleniumProject/Maven/SeleniumFramework/src/main/java/Drivers/chromedriver");


@Parameters ("browser")
@BeforeClass
    public void appInit(String browser) throws InterruptedException, IOException {

    // Step one---Open the browser

        //WebDriver driver = new FireFoxDriver();

        FileInputStream fs = new FileInputStream("/Users/jewel/Desktop/UprightTechSolutions/IntelliJ_SeleniumProject/Maven/SeleniumFramework/src/test/java/env.properties");

        Properties prop = new Properties();
        prop.load(fs); // It will load everything from the env.properties file. Whatever Active will execute.

          String myURL = prop.getProperty("url");



        if (browser.equalsIgnoreCase("chrome")) {
        // WebDriverManager will automatically check the browser version and adjust the necessary setting.
            // If used, No need to download manually.
            WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // This will open the browser
             }

        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        else {
            System.out.println("Check back your drivers");
        }



    //Step -2, Navigate to the URL
        /* There are two ways to navigate to the URL
        i. driver.navigate().to(url)
        ii.driver.get(url)
         */

        // Navigate is used like BACKSPACE and FORWARD. Switching between two pages back and forth.
        driver.navigate().to(myURL); // Client level request (java is my client here)we must use the protocol type as the request converts to json.
        // Above method is navigating to another URL.
        driver.manage().window().maximize(); // It will maximize the window.
            Thread.sleep(4000); // Hard coded wait time.
        driver.navigate().to("http://uprightforum.tech");
            Thread.sleep(4000);
        driver.navigate().back();
            Thread.sleep(4000);
        //driver.navigate().forward();
        //driver.get("https://uprightautomation.online/registration/");

                /* Difference between the two methods:
                driver.navigate().to()  does not wait to load the page. It will move forward to the next line.
                However, driver.get() will wait till the page is loaded before it move on to the next line.
                 */

        driver.navigate().refresh();

        //Below is the Validation/testing URL.

        //Validate the URL is "https://uprightautomation.online/registration/"

        String myUrl = driver.getCurrentUrl(); // This actual URL will be picked by Selenium itself.



        if (myUrl.equalsIgnoreCase("https://uprightautomation.online/registration/")){
            System.out.println("The URL is good");
            // Above we are validating "myURL"( picked up by Selenium) is the expected URL ( Expected URL provided my me on the right hand side) are matched or not.
        }
        else {
            System.out.println("Please check the URL");
        }

        /*
        How many ways you can validate any functionality?
        i. Above - using if else statement (Java)
        ii.Below - Using Assert utility (From TestNG or Junit)

        There are also two types of Assertions.
        i. Hard assert --
        ii. Soft assert -- it means (Verify).

             */

       SoftAssert obj = new SoftAssert();
        //importing another class (SoftAssert) from testNG- so we can continue the script weather an error found or not but provides the reports the error at the end.
        // We have to create an object of the Soft Assert as it is not a static method. Whereas we do not have to create an object of Assert class because Assert class is a static method.
        obj.assertEquals(myUrl,"https://uprightautomation.online/registrati/");


        //TestNg is a testing framework. There are classes which can be used to validate the test. Like Assert has many methods.
       // Assert.assertEquals(myUrl,"https://uprightautomation.online/registrati/");


        // Validate that the title is "Registration-Upright Automation"
        String myTitle  = driver.getTitle();
        //Assert.assertEquals(myTitle,"Registration-Upright Automation");
        obj.assertEquals(myTitle,"Registration-upright Automation");


        //driver.close(); // This method will only close the current browser opened by the selenium.
        //obj.assertAll(); // This method will show the errors in the console that script had encountered during execution.


       // driver.quit(); // This method will close all browsers opened by the selenium and also closes (End Task)the background processes.








        /* What are the waits you have used in selenium?

        i. Implicitly wait--It will wait a certain period (Like:10 sec) before throwing any exceptions.
            and applied to all the script where-ever this class is extended.

        ii.Explicitly wait--


         */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }


    @AfterClass
public void tearDown() {
   // driver.quit();
    }




}

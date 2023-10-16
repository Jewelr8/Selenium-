package testClasses;

import DataReader.ExcelLoginDataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageElements.LoginUAPage;
import utility.BaseClasss;

import java.util.List;

public class LoginUATest extends BaseClasss {

    LoginUAPage loginUAPage;



    /*
    Step 1---Click on Account
    Step 2 --Click on Login Link
     */


//@Test
//    public void clickOnAccount() throws IOException {
//    WebElement account = driver.findElement(By.linkText("Account")); // Select the correct parameter from the list.
//    account.click();
//
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Login"));
//
//
//    WebElement Login = driver.findElement(By.linkText("Login"));
//    Login.click();
//
//    screenshot("Login.png");
//
//    }



    @Test

    public void clickOnAccount(){
        loginUAPage = new LoginUAPage(driver); // open the page
        loginUAPage.clickOnAccount(); // Click on account
        loginUAPage.clickOnLogin(); // Click on login
        loginPage();
    }




    public void validateLoginPage() throws InterruptedException {
//        loginUAPage.clickOnAccount();
//        Thread.sleep(2000);
//        loginUAPage.clickOnLogin();
//        if (loginUAPage.getLoginText().equalsIgnoreCase("Login")
//        ) {
//            System.out.println("I am on the right page");
//        }
//        else {
//            System.out.println("I am not on the right page");
//        }
        Assert.assertEquals(loginUAPage.getLoginText(),"Login");
   }



    private void loginPage() {
    }

    /* Above calling the method from PAge element class
    ONly showing functionality, hiding the implementation in pageElements package class.
     */




    //Relative path ----

@Test(dataProvider = "Login Data from Excel", dataProviderClass = ExcelLoginDataReader.class)
    public void enterLoginData(String userName,String passWord, String email ) throws InterruptedException {



        /*
         Relative path formula below--
        tag-name[@attribute = 'value']
        */

//    WebElement userNamePath = driver.findElement(By.xpath(  "//input[@id = 'loginusername']"));
//        userNamePath.clear();
//       userNamePath.sendKeys("userName");
        Thread.sleep(3000);
    loginUAPage.enterUserName(userName);

//        WebElement passWordPath = driver.findElement(By.xpath("//input[@id ='loginPassword4]"));
//        userNamePath.clear();
//       userNamePath.sendKeys("passWord");
        Thread.sleep(3000);
    loginUAPage.enterPassWord(passWord);


//        WebElement emailPath = driver.findElement(By.xpath("//input[@class = 'form control']"));
//        List<WebElement> inputList = driver.findElements(By.id("//input[@class = 'form-control")); // Created a list as single variable can not hold multiple value.
//        userNamePath.clear(); // clearing the previous data from the field
//        userNamePath.sendKeys("email"); // sending new data into the field
      //  WebElement EmailPath = inputList.get(1); // selecting the 2nd elements from the xpath.
        Thread.sleep(3000); // inserting pause time in between page selections.lo
    loginUAPage.emailList(email);

//       WebElement loginButton = driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary')]"));
//      loginButton.click(); // clicking on login button.
    loginUAPage.loginButton();
    }



/*Calling the method from PAge element class
ONly showing functionality, hiding the implementation in pageElements package class.
 */



}



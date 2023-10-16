package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginUAPage {
    /*There are three parts in page class---
    i. Constructor
    ii. Page Elements
    iii. Methods according to actions
     */



//Page Factory format ----

    public  LoginUAPage(WebDriver driver) {
        PageFactory.initElements(driver,
                this);
    }



    //Page Elements---
    @FindBy(linkText = "Account")
    WebElement accountLocator;
    @FindBy(linkText = "Login")
    WebElement loginLocator;

    @FindBy(xpath = "//input[@id ='loginusername']")
    WebElement userNamePath;

    @FindBy(xpath ="//input[@id ='loginPassword4']")
    WebElement passwordPath;

    @FindBy(xpath = "//input[@class = 'form control']")
    List<WebElement> emaillist;

    @FindBy(xpath = "//button[contains(@class,'btn btn-primary')]")
    WebElement loginButtonPath;

    @FindBy(xpath = "/html/body/div/section[2]/h3")
    WebElement loginTextPath;






    // Method according to action
    public void clickOnAccount(){
        accountLocator.click();

    }

    public void clickOnLogin(){

        loginLocator.click();
    }


public String getLoginText(){

        String loginText = loginTextPath.getText();
    return loginText;
}


public void enterUserName(String user){
    userNamePath.clear();
    userNamePath.sendKeys(user);
}

public void enterPassWord(String pass){
    passwordPath.clear();
    passwordPath.sendKeys(pass);
}


public void emailList(String email){
 List<WebElement> list1 = emaillist;
 emaillist.get(1).clear();
 emaillist.get(1).sendKeys(email);
}

public void loginButton(){

        loginButtonPath.click();
}



    //public void setLoginButtonPath(WebElement loginButtonPath) {
      //  this.loginButtonPath = loginButtonPath;
   // }

//public void loginPage() throws InterruptedException {
           // WebElement account = driver.findElement(By.linkText("Account")); // Page Element.




           // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Login"));



        }




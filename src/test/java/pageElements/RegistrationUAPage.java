package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationUAPage {

     // Constructor
    // Page Elements
    // Method According to actions.

    public RegistrationUAPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Registration")
    WebElement registrationLocator;

@FindBy (xpath = "/html/body/div/section[1]/div[2]/div//div/div/div/h2")
    WebElement registrationTextPath;

@FindBy (xpath = "/html/body/div/section[2]/div/form/div/input")
    WebElement FirstName;

@FindBy (xpath = "/html/body/div/section[2]/div/form/div[2]/input")
    WebElement LastName;
@FindBy (xpath = "/html/body/div/section[2]/div/form/div[3]/input")
    WebElement UserName;
@FindBy (xpath = "/html/body/div/section[2]/div/form/div[4]/input")
    WebElement EmailAddress;
@FindBy (xpath = "/html/body/div/section[2]/div/form/div[5]/input")
    WebElement PassWord;
@FindBy (xpath = "/html/body/div/section[2]/div/form/div[6]/input")
    WebElement ConfirmPassword;
@FindBy (xpath = "/html/body/div/section[2]/div/form/div[7]/input ")
    WebElement BirthDay;
@FindBy (xpath = "/html/body/div/section[2]/div/form/div[8]/input")
    WebElement Phone;
@FindBy (xpath = "/html/body/div/section[2]/div/form/div[9]/input")
    WebElement Address;
@FindBy (xpath = "/html/body/div/section[2]/div/form/div[10]/input")
    WebElement City;
@FindBy (xpath = "/html/body/div/section[2]/div/form/div[11]/input")
    WebElement ZipCode;
@FindBy (xpath = "/html/body/div/section[2]/div/form/div[12]/input")
    WebElement Country;
@FindBy (xpath = "/html/body/div/section[2]/div/form/div[13]/button")
    WebElement OpenAccount;


public void clickOnRegistration(){
    registrationLocator.click();
}

    public String getRegistrationText(){
    String registrationText = registrationTextPath.getText();
    return registrationText;
    }














}

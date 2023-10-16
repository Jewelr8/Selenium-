package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class CommonUtility {

    public WebDriver driver;


public void screenshot(String fileName) throws IOException {

    TakesScreenshot ss = (TakesScreenshot) driver; // Type Casting---Forcing driver to TakeScreenShots. They comes from different channel.
        File memoryLocation = ss.getScreenshotAs(OutputType.FILE);
    FileHandler.copy(memoryLocation, new File("/Users/jewel/Desktop/UprightTechSolutions/IntelliJ_SeleniumProject/Maven/SeleniumFramework/src/test/ScreenShotFolder/"+fileName));

}

    public void submitButton() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy (0, 100)");
        Thread.sleep(3000);
        WebElement submit = driver.findElement(By.name("input submit"));
        submit.click();
        //CaptureScreenShotOnFailure(ITestResult result);
    }


    //This method will scroll all the way to the bottom of the page.
    public void JSExecutorScrollHeight(){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("Window.scrollBy(0,documents.body.scrollHeight)"); // js is a reference variable.
    }


    // With this method I can customize how far in the window to scroll.
    public void jsScrollByNumber(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy (0, 100)");
    }

    //BELOW IS THE JAVA METHOD TO SCROLL THE SCREEN UP TO CERTAIN ELEMENT
    public void scrollIntoView(WebElement element){
    JavascriptExecutor js = (JavascriptExecutor)  driver;
    js.executeScript("argument[0].scrollIntoView();",element);
    }







//public void CaptureScreenShotOnFailure(ITestResult result){
//    if (result.getStatus() == ITestResult.FAILURE){
//        try{
//            screenshot("fail.png");
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }


    }





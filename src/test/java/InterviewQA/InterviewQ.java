package InterviewQA;

public class InterviewQ {

    /*

    What is pageObject Model?
    -- pageObject Model is a pattern where page elements are separated from the test class.
    Advantage of pageObject model - Reusability,Reduces code duplication.

    How did you implement Oops Concepts in Selenium ?
    -- There are few oops principles.
        i. Inheritance - We used extend between classes. Such as Base class,Common Utility class and test class.
        ii. Polymorphism - Overloading and overriding.
            We use overloading when we used Assert.assertEquals.

        iii. Abstraction - PageClass and TestClass
        iv. Interface - WebDriver is an Interface. Also we worked with TakeScreenShots, ITestResult
        v. Encapsulation -


    How to get ScreenShots is failed?
    -- We use captureScreenShotsOnFailure method from selenium and we use the parameter ITestResult (Interface),  from TestNG.
    If the ITestResult == Failure then we call the screenShot Method. This will only take screenShot of the failed test.

    Why do we use xPaths?
    -- xpaths can be use when we do not have the locators, like id, Name, etc. Also in general companies prefer to use xpaths. We follow the company policy.

    How many types of xpath's are there in selenium?
    -- There are two types of xpath's
        i. Absolute ---starts from the root node and with a single slash (/).
        ii. Relative --- Can starts from anywhere in the document and uses double slash (//)
            Relative path formula is //tagname[@attribute = 'value']


    Why not to use absolute x-paths?
    -- Any changes made to the path will impact the script.









     */




}

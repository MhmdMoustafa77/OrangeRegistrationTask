package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class RegisterPage extends Base {

    // Constructor for the RegisterPage class. Initializes the PageFactory to initialize the web elements.
    public RegisterPage(){
        PageFactory.initElements(driver , this); // Initializes the WebElements using PageFactory and the current driver instance.
    }

    // WebElement definitions for the registration form fields
    @FindBy (name = "name")
    WebElement firstName;

    // Finds the email input field by its id attribute
    @FindBy (id = "email")
    WebElement email ;

    // Finds the gender selection element by its XPath
    @FindBy (xpath = "//*[@id='gender']")
    WebElement gender ;

    // Finds the mobile number input field by its XPath
    @FindBy (xpath = "//*[@id='mobile']")
    WebElement mobile;

    // Finds the date of birth input field by its XPath
    @FindBy (xpath = "//*[@id='dob']")
    WebElement dob ;

    // Finds the subjects input field by its name attribute
    @FindBy (xpath = "//*[@name='subjects']")
    WebElement subjects ;

    // Finds the hobbies selection element by its XPath
    @FindBy (xpath = "//*[@id='hobbies']")
    WebElement hobbies ;

    // Finds the file upload input by its XPath
    @FindBy (xpath = "/html/body/main/div/div/div[2]/form/div[8]/div/div/input")
    WebElement uploadFile;

    // Finds the address input area by its XPath
    @FindBy (xpath = "/html/body/main/div/div/div[2]/form/div[9]/div/textarea")
    WebElement address;

    // Finds the state dropdown by its name attribute
    @FindBy (name = "state")
    WebElement statedropDown;

    // Finds the city dropdown by its name attribute
    @FindBy (name = "city")
    WebElement citydropDown;

    // Finds the submit button by its type attribute
    @FindBy (xpath = "//*[@type='submit']")
    WebElement login ;

    // Method to perform user registration by filling out the registration form
    public void performRegister(){

        // Fill in the registration form fields using properties loaded from a configuration file
        firstName.sendKeys(props.getProperty("firstname")); // Enter the first name
        email.sendKeys(props.getProperty("email")); // Enter the email address
        gender.click(); // Click on the gender selection
        mobile.sendKeys(props.getProperty("mobile")); // Enter the mobile number
        dob.sendKeys(props.getProperty("dob")); // Enter the date of birth
        subjects.sendKeys(props.getProperty("subjects")); // Enter the subjects
        hobbies.click(); // Click to select hobbies

        // Path to the file that will be uploaded
        String filePath = "C:\\Users\\DELL\\Desktop\\صوره-شخصيه1.png" ; // File path for the image upload
        uploadFile.sendKeys(filePath); // Upload the file using the input element
        address.sendKeys(props.getProperty("address")); // Enter the address

        // Select the state from the dropdown
        Select statedropdown = new Select(statedropDown); // Create a Select object for the state dropdown
        statedropdown.selectByVisibleText("NCR"); // Select the state by visible text

        // Select the city from the dropdown
        Select citydropdown = new Select(citydropDown); // Create a Select object for the city dropdown
        citydropdown.selectByIndex(1); // Select the city by index

        // Click the submit button to register the user
        login.click();

        // Assert to verify if the registration was successful by checking if the first name field is displayed
        Assert.assertFalse(firstName.isDisplayed(),"login wasn't successful and this is failure test case");









    }











}

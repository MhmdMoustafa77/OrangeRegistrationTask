package Tests;
import Base.Base;
import Pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.IOException;

@Epic("User Registration") // Defines the epic that this test belongs to, which is related to user registration.
@Feature("Register User") // Specifies the feature under the epic that is being tested - user registration functionality.
public class RegisterTest extends Base { // The RegisterTest class extends the Base class, inheriting common setup and other methods.

    @Test // test case in the test suite.
    @Story("Valid Register Test") // Describes the specific user story being tested - a valid registration scenario.
    @Description("Verify that a user can register successfully with valid data") // a detailed description of what the test case validates.
    public void testValidRegister() throws IOException, InterruptedException {
        // Launch the browser and navigate to the registration page
        lanchBrowser(); // Method call to initialize the browser and open the URL from properties.


        // Create an instance of the RegisterPage to access registration methods
        RegisterPage registerPage = new RegisterPage();

        // Execute the registration process using valid data inputs
        registerPage.performRegister();

    }

    @AfterTest // Annotation to indicate that this method should run after all tests in the class.
    public void closingBrowser() {
        // Ensure the WebDriver instance is not null before attempting to quit
       if (driver != null) {
            driver.quit(); // Close the browser and end the WebDriver session to free resources.

        }
    }

}
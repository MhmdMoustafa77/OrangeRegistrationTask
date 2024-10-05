package Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {

    // Declare a WebDriver instance that will be used for interacting with the browser
    public static WebDriver driver ;

    // Declare a Properties object to load configuration settings from a properties file
    public static Properties props = new Properties();


    @Step("Setting up the browser and navigating to the register page")
    public static void lanchBrowser() throws IOException, InterruptedException {
            // Specify the properties file path
        File file = new File("src/main/java/properities/config.properities");
        FileInputStream fis = new FileInputStream(file);
        props.load(fis);

            // Check if the configured browser is Chrome
        if(props.getProperty("browser").equalsIgnoreCase("chrome")){
            // Setup WebDriverManager to manage the ChromeDriver version automatically
            WebDriverManager.chromedriver().setup();
            // Instantiate a new ChromeDriver object to launch the browser
            driver  = new ChromeDriver() ;
        }


        // Check if the configured browser is Firefox
        if(props.getProperty("browser").equalsIgnoreCase("firefox")){
            // Setup WebDriverManager to manage the FirefoxDriver version automatically
            WebDriverManager.firefoxdriver().setup();
            // Instantiate a new FirefoxDriver object to launch the browser
            driver  = new FirefoxDriver() ;


        }

        // Check if the configured browser is Edge
        if(props.getProperty("browser").equalsIgnoreCase("edge")){
            // Setup WebDriverManager to manage the EdgeDriver version automatically
            WebDriverManager.edgedriver().setup();
            // Instantiate a new EdgeDriver object to launch the browser
            driver  = new EdgeDriver() ;
        }


        // Navigate to the URL of the registration page and pause the execution for 8 seconds to allow the page to load completely
        driver.get(props.getProperty("url"));
        // Maximize the browser window to ensure all elements are visible and interactable
        driver.manage().window().maximize();
        // Pause execution for 8 seconds to allow the page to load completely
        Thread.sleep(8000);
        // Set an implicit wait of 60 seconds for the driver to wait for elements to be present in the DOM
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }


    }





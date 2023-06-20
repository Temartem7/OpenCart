package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

//@BeforeSuite: The annotated method will be run only once before all tests in this suite have run.

//@AfterSuite: The annotated method will be run only once after all tests in this suite have run.

//@BeforeTest: The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.

//@AfterTest: The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run.

//@BeforeClass: The annotated method will be run only once before the first test method in the current class is invoked.

//@AfterClass: The annotated method will be run only once after all the test methods in the current class have run.

//@BeforeMethod: The annotated method will be run before each test method.

//@AfterMethod: The annotated method will be run after each test method.

//@BeforeGroups - The @BeforeGroups annotated method run only once for a group before the execution of all test cases belonging to that group.

//@AfterGroups - The @AfterGroups annotated method run only once for a group after the execution of all test cases belonging to that group.

//BeforeSuite->BeforeTest->BeforeClass->BeforeMethod->Test<-AfterMethod<-AfterClass<-AfterTest<-AfterSuite

public class Base {

    public static Properties prop; // object to manage configuration settings
    public static WebDriver driver;

    @BeforeSuite
    // method loads configuration values from a properties file located at a specific path and assigns them to the prop object
    // handling FileNotFoundException and IOException exceptions if they occur.
    public void loadConfig(){
        try{ // using try catch block to handle 2 types of exceptions that could occur
            prop = new Properties(); // creating an instance(object) of Properties class and assigns it to prop variable

            // FileInputStream() object that reads the file located at the specified path
            // System.getProperty("user.dir") represents the current directory and appending \Config\config.properties
            FileInputStream inputStr = new FileInputStream(System.getProperty("user.dir")+"\\Config\\config.properties");
            prop.load(inputStr); // loads the properties from the input stream into the prop object to allow reading the configuration values from the "config.properties"

        }catch(FileNotFoundException e){ // occurs while trying to read config file

            e.printStackTrace(); // 1.provides information about the exception type
                                 // 2.provides method calls that led to the exception
                                 // 3.provides the line numbers where the exception occurred.

        }catch (IOException e){ // occurs during loading of properties
            e.printStackTrace();
        }
    }

    public void manageAppLaunch(){
        String browserType = prop.getProperty("browser"); // retrieves the value of the browser property

        if(browserType.equalsIgnoreCase("Chrome")){ // Checks if the value of browserType is equal to "Chrome"
            driver = new ChromeDriver(); // creates a new instance(object) of ChromeDriver class and assigns it to driver variable
        }else if (browserType.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else if(browserType.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize(); // maximizes the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // driver will wait for a certain amount of time trying to find an element, before throwing an exception

        // manage the timeout duration for web pages that may take longer to load due to various factors such as network latency, heavy page content, or slow server response
        // This means that if a web page takes more than 30 seconds to load, a TimeoutException will be thrown by the WebDriver.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get(prop.getProperty("url")); // navigates the driver to url provided in the config.properties file
    }

    @BeforeMethod
    public void setup(){
        manageAppLaunch();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

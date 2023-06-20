package pageobjects;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends Base {

    @FindBy(xpath = "//span[@class='d-none d-md-inline'][.='My Account']")
    private WebElement myAccount;

    @FindBy(xpath = "//a[@class='dropdown-item'][.='Login']")
    private WebElement login;

    @FindBy(xpath="//a[.='Register']")
    private WebElement register;

    public IndexPage(){
        // PageFactory is a utility class in Selenium WebDriver that provides an easy way to initialize web elements in a page object model (POM) pattern
        // The driver parameter is the instance of the WebDriver that is used to interact with the web page.
        // The "this" keyword refers to the current instance(creation) of the page object class where the method is called. In this case, it refers to the instance of the RegisterPage class.
        // initElements() method initializes the web element field by assigning the located web element to the instance variable.
        // This allows the page object to directly interact with the web element through the instance variable.
        // instance variable - variable that is defined at the class level and belongs to each instance (object) of that class
        PageFactory.initElements(driver,this);
    }
    public void clickMyAccount(){
        myAccount.click();
    }
    public LoginPage clickLogin(){
        login.click();
        return new LoginPage();
    }
    public RegisterPage clickRegister(){
        register.click();
        return new RegisterPage();
    }

}

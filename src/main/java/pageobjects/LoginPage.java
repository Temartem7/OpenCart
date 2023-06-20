package pageobjects;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {

    @FindBy(name="email")
    private WebElement email;
    @FindBy(name="password")
    private WebElement password;
    @FindBy(xpath="//button[@type='submit']")
    private WebElement loginBtn;
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void enterEmail(){
        email.sendKeys("art@gmail.com");
    }

    public void enterPassword(){
        password.sendKeys("art123");
    }
    public AccountPage clickLogin(){
        loginBtn.click();
        return new AccountPage();
    }

}

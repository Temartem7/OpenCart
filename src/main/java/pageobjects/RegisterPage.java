package pageobjects;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Base {

    @FindBy(id = "input-firstname")
    private WebElement firstName;
    @FindBy(id = "input-lastname")
    private WebElement lastName;
    @FindBy(id = "input-email")
    private WebElement email;
    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(id = "input-newsletter-yes")
    private WebElement yesRadioBtn;
    @FindBy(id = "input-newsletter-no")
    private WebElement noRadioBtn;
    @FindBy(name = "agree")
    private WebElement agreementCheckBox;
    @FindBy(id = "//button[@type='submit']")
    private WebElement continueBtn;

    public RegisterPage(){
        PageFactory.initElements(driver,this);
    }

    public void enterFirstName(){
        firstName.sendKeys();
    }
    public void enterLastName(){
        lastName.sendKeys();
    }
    public void enterEmail(){
        email.sendKeys();
    }
    public void enterPassword(){
        password.sendKeys();
    }
    public void clickYes(){
        yesRadioBtn.click();
    }
    public void clickNo(){
        noRadioBtn.click();
    }
    public void clickAgree(){
        agreementCheckBox.click();
    }
    public AccountCreationPage clickContinue(){
        continueBtn.click();
        return new AccountCreationPage();
    }

}

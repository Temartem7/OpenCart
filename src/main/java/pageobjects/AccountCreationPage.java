package pageobjects;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends Base {

    @FindBy(xpath="//a[.='Your Account Has Been Created!']")
    private WebElement accountCreationBreadcrumb;
    public AccountCreationPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyAccountCreationPage(){
        return accountCreationBreadcrumb.isDisplayed();
    }
}

package pageobjects;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Base {

    @FindBy(xpath = "//a[.='Account']")
    private WebElement accountBreadcrumb;

    @FindBy(xpath="//a[@class='nav-link'][.='Cameras']")
    private WebElement cameras;
    public AccountPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyAccountPage(){
        return accountBreadcrumb.isDisplayed();
    }

    public CameraPage navigateToCameraPage(){
        cameras.click();
        return new CameraPage();
    }
}

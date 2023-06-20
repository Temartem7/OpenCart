package pageobjects;

import base.Base;
import executor.Exec;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CameraPage extends Base {

    Exec exec = new Exec();
    @FindBy(xpath="//li[@class='breadcrumb-item']//a[contains(text(),'Cameras')]")
    private WebElement cameraBreadcrumb;

    @FindBy(xpath = "//img[@alt='Nikon D300'][@title='Nikon D300']")
    private WebElement nikonD300;

    public CameraPage(){
        PageFactory.initElements(driver,this);
    }
    public boolean verifyCameraPage(){
        return cameraBreadcrumb.isDisplayed();
    }
    public NikonPage clickNikonD300(){
        exec.getWait5().until(ExpectedConditions.elementToBeClickable(nikonD300)).click();
        return new NikonPage();
    }
}

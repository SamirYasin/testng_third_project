package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class CarvanaBasePage {
    public CarvanaBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "div[class^=\"Logo\"]")
    public WebElement logo;

    @FindBy(css = ".Navigationstyles__NavigationWrapper-pqwx2h-0.ggtgcl a[role=\"button\"]")
    public List<WebElement> mainNavItems;

    @FindBy(css = "[title=\"AudioEye Persistent Cookies Iframe\"]")
    public WebElement iFrame;

    @FindBy(css = ".SignInLink__DesktopWrapper-k2q06e-2.dnjyaj a")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(css = ".button_btn__d4d6f")
    public WebElement continueButton;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "error-banner")
    public WebElement errorMessage;

}

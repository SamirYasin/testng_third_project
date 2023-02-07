package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarvanaSearchPage extends CarvanaBasePage{
    public CarvanaSearchPage(){
        super();
    }
    @FindBy(css = "a[href='/cars']")
    public WebElement searchCarsButton;
    @FindBy(css = "#header-facets-wrapper button")
    public List<WebElement> searchFilterOptions;
    @FindBy(css = "#search-bar-container-wrapper input")
    public WebElement searchBox;
    @FindBy(css = "#search-bar-container-wrapper button")
    public WebElement goButton;
    @FindBy(xpath = "//div[@class=\"result-tile\"]//picture")
    public List<WebElement> carImages;
    @FindBy(xpath = "//div[@class=\"favorite-vehicle\"]")
    public List<WebElement> favButton;
    @FindBy(xpath = "//div[@data-test=\"InventoryTypeExperiment\"]")
    public List<WebElement> inventoryType;
    @FindBy(css = "div.make-model")
    public List<WebElement> yearMakeAndModel;
    @FindBy(css = "div.trim-mileage")
    public List<WebElement> trimMileageInfo;
    @FindBy(xpath = "//div[@data-testid=\"price\"]")
    public List<WebElement> price;
    @FindBy(css = ".monthly-payment")
    public List<WebElement> monthlyPayment;
    @FindBy(css = ".down-payment")
    public List<WebElement> downPayment;
    @FindBy(xpath = "//div[@data-qa=\"days-to-delivery-tag\"]")
    public List<WebElement> deliveryChip;


}

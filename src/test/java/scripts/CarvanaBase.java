package scripts;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CarvanaBasePage;
import pages.CarvanaSearchPage;
import utils.ConfigReader;
import utils.Driver;

public class CarvanaBase {
    public WebDriver driver;

    CarvanaBasePage carvanaBasePage;
    CarvanaSearchPage carvanaSearchPage;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        carvanaBasePage = new CarvanaBasePage();
        carvanaSearchPage = new CarvanaSearchPage();
        driver.get(ConfigReader.getProperty("appURL"));
    }

    @AfterMethod
    public void teardown() {
        Driver.quitDriver();
    }
}
package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaBasePage;
import utils.Waiter;

import java.util.stream.IntStream;

public class CarvanaTest extends CarvanaBase {
@BeforeMethod
    public void setPage(){
    carvanaBasePage = new CarvanaBasePage();
}
    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateHomePageAndURL(){
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validateLogo(){
    Assert.assertTrue(carvanaBasePage.logo.isDisplayed());
    }

    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateMainNavSectionItems(){
    String[] items = {"HOW IT WORKS", "ABOUT CARVANA","SUPPORT & CONTACT"};
        IntStream.range(0, carvanaBasePage.mainNavItems.size()).forEach(i -> Assert.assertEquals(items[i], carvanaBasePage.mainNavItems.get(i).getText()));
    }

    @Test(priority = 4, description = "Validate the sign in error message")
    public void validateSignInErrorMessage(){
    carvanaBasePage.signInButton.click();
    carvanaBasePage.emailBox.sendKeys("johndoe@gmail.com");
    carvanaBasePage.continueButton.click();
    carvanaBasePage.passwordBox.sendKeys("abcd1234");
    carvanaBasePage.continueButton.click();
        Waiter.pause(2);
    Assert.assertEquals(carvanaBasePage.errorMessage.getText(),"Email address and/or password combination is incorrect.");
    }

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void validateSearchFillerAndButton(){
    carvanaSearchPage.searchCarsButton.click();
    String[] filters = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
    IntStream.range(0, carvanaSearchPage.searchFilterOptions.size())
            .forEach(i -> Assert.assertEquals(carvanaSearchPage.searchFilterOptions.get(i).getText(), filters[i]));
    }

    @Test(priority = 6,description = "Validate the search result tiles")
    public void validateSearchResultTiles(){
    carvanaSearchPage.searchCarsButton.click();
    carvanaSearchPage.searchBox.sendKeys("mercedes-benz");
    carvanaSearchPage.goButton.click();
    Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));
        for (int i = 0; i < 20; i++) {
            Assert.assertTrue(carvanaSearchPage.carImages.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchPage.favButton.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchPage.inventoryType.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchPage.inventoryType.get(i));
            Assert.assertTrue(carvanaSearchPage.yearMakeAndModel.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchPage.yearMakeAndModel.get(i));
            Assert.assertTrue(carvanaSearchPage.trimMileageInfo.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchPage.trimMileageInfo.get(i));
            Assert.assertTrue(Integer.parseInt(carvanaSearchPage.price.get(i).getText().substring(1).replace(",", "")) >= 0);
            Assert.assertTrue(carvanaSearchPage.monthlyPayment.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchPage.monthlyPayment.get(i));
            Assert.assertTrue(carvanaSearchPage.deliveryChip.get(i).isDisplayed());
            Assert.assertNotNull(carvanaSearchPage.deliveryChip.get(i));


    }
    }

}

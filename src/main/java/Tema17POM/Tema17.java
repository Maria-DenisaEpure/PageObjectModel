package Tema17POM;

import org.testng.annotations.Test;
import pages.MenuPage;
import pages.SingleAuthorPage;
import utils.BaseTest;

import static org.testng.Assert.assertTrue;

public class Tema17 extends BaseTest {
    @Test
    public void checkSkills () throws InterruptedException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateTo(menuPage.singleAuthorLink);
        SingleAuthorPage singleAuthorPage = new SingleAuthorPage(driver);
        singleAuthorPage.createMap();
        assertTrue(singleAuthorPage.checkPercentageValue("Drama", "95%"));
        assertTrue(singleAuthorPage.checkPercentageValue("Biography", "75%"));
        assertTrue(singleAuthorPage.checkPercentageValue("Cookbooks", "82%"));
    }
}

package Tema18POM;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ShippingAddressPage;
import utils.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Tema18 extends BaseTest {
    @Test
    public void shipping () {
        MenuPage menu = new MenuPage(driver);
        menu.navigateTo(menu.loginLink);
        LoginPage login =  new LoginPage(driver);
        login.loginInApp("TestUser", "12345@67890");
        assertTrue(login.checkLoginMessageIsDiplayed(login.sucessLoginPopup));
        driver.get("https://keybooks.ro/account/edit-address/shipping/");
        ShippingAddressPage shippingAddressPage = new ShippingAddressPage(driver);
        shippingAddressPage.selectByIndex(41);
        assertEquals(shippingAddressPage.getSelectedOption(shippingAddressPage.country), "Canada");
        // byVisibleText pentru ca nu exista value
        shippingAddressPage.selectByVisibleText("Newfoundland and Labrador");
        assertEquals(shippingAddressPage.getSelectedOption(shippingAddressPage.province), "Newfoundland and Labrador");
    }
}

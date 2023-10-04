package Tema22POM;

import org.testng.annotations.Test;
import pages.MenuPage;
import utils.BaseTest;

import static org.testng.Assert.assertEquals;

public class Tema22 extends BaseTest {
    @Test
    public void  navigateToPages() throws InterruptedException {
        MenuPage menuPage = new MenuPage(driver);
        String keybooks = driver.getWindowHandle();
        menuPage.changeCurrentTab(menuPage.fb);
        assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/keytraining.ro");
        driver.close();

        driver.switchTo().window(keybooks);
        menuPage.changeCurrentTab(menuPage.twitter);
        assertEquals(driver.getCurrentUrl(),"https://twitter.com/");
        driver.close();

        driver.switchTo().window(keybooks);
        menuPage.changeCurrentTab(menuPage.instagram);
        assertEquals(driver.getCurrentUrl(),"https://www.instagram.com/");
        driver.close();
        driver.switchTo().window(keybooks);
    }
}

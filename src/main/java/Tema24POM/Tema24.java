package Tema24POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPage;
import utils.BaseTest;
import utils.DataProviderClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Tema24 extends BaseTest {
    @Test(dataProviderClass = DataProviderClass.class , dataProvider = "bookUrlDataProvider")
    public void testBookPictures(String book, String bookUrl) throws InterruptedException {
        WebElement bookElement = driver.findElement(By.cssSelector(book));
        bookElement.click();
        Thread.sleep(2000);
        assertEquals(driver.getCurrentUrl(),bookUrl);
    }
}

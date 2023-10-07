package Tema25POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.MenuPage;
import utils.BaseTest;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Tema25 extends BaseTest {
    @Test
    public void searchBookByPopup() {
        MenuPage menuPage = new MenuPage(driver);
        WebElement searchIcon = driver.findElement(menuPage.searchIcon);
        WebElement searchInput = driver.findElement(menuPage.searchInput);
        searchIcon.click();
        searchInput.sendKeys("king");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article[class*='post_item with_thumb'] a[href*='the-wicked-king']")));
        WebElement book = driver.findElement(By.cssSelector("article[class*='post_item with_thumb'] a[href*='the-wicked-king']"));
        book.click();
        WebElement category = driver.findElement(By.cssSelector("span[class='posted_in']>a[href*='new-releases']"));
        assertTrue(category.isDisplayed());
        WebElement productId = driver.findElement(By.cssSelector("span[class='product_id']>span"));
        assertEquals(productId.getText(),"1709");
        WebElement photo1 = driver.findElement(By.cssSelector("img[src*='TheWickedKing1-100']"));
        WebElement photo2 = driver.findElement(By.cssSelector("img[src*='TheWickedKing2-100']"));
        WebElement photo3 = driver.findElement(By.cssSelector("img[src*='TheWickedKing3-100']"));
        WebElement photo4 = driver.findElement(By.cssSelector("img[src*='TheWickedKing4-100']"));
        assertTrue(photo1.isDisplayed());
        assertTrue(photo2.isDisplayed());
        assertTrue(photo3.isDisplayed());
        assertTrue(photo4.isDisplayed());
    }
}

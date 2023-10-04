package Tema21POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ClassicBlogsPage;
import pages.MenuPage;
import pages.ShopPage;
import utils.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Tema21 extends BaseTest {
    @Test(priority = 1)
    public void checkCategories () {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateTo(menuPage.blogLink);
        menuPage.navigateTo(menuPage.classics);
        ClassicBlogsPage classicBlogsPage = new ClassicBlogsPage(driver);
        WebElement searchField = driver.findElement(classicBlogsPage.searchField);
        searchField.sendKeys("why");
        searchField.sendKeys(Keys.ENTER);
        WebElement blog = driver.findElement(By.cssSelector("a[href*='why-i-wont-stop-buying-books']"));
        blog.click();
        classicBlogsPage.createList();
        assertTrue(classicBlogsPage.categories.contains("Classic"));
        assertTrue(classicBlogsPage.categories.contains("News"));
        assertTrue(classicBlogsPage.categories.contains("Recommend"));
    }

    @Test(priority = 2)
    public void checkSale () {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateTo(menuPage.blogLink);
        menuPage.navigateTo(menuPage.shopLink);
        ShopPage shopPage = new ShopPage(driver);
        WebElement cookbooks = driver.findElement(shopPage.cookbooks);
        cookbooks.click();
        shopPage.getSaleBooks();
        shopPage.getBooks();
        assertEquals(shopPage.books.size(),shopPage.saleBooks.size());
    }
}

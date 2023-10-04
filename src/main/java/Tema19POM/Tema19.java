package Tema19POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.ShopPage;
import utils.BaseTest;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Tema19 extends BaseTest {
    @Test
    public void verifyElements () {
        MenuPage menuPage = new MenuPage(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        menuPage.navigateTo(menuPage.shopLink);
        WebElement book = driver.findElement(By.xpath("//a[contains(@href, 'galaxy' ) and @class='hover_icon hover_icon_link']"));
        book.click();
        WebElement magGlass = driver.findElement(By.xpath("//a[@class='woocommerce-product-gallery__trigger']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='woocommerce-product-gallery__trigger']")));
        jse.executeScript
                ("arguments[0].setAttribute('style', 'border:4px solid blue')", magGlass);
        assertTrue(magGlass.isDisplayed());
        WebElement title = driver.findElement(By.xpath("//h1[@class='product_title entry-title']"));
        jse.executeScript
                ("arguments[0].setAttribute('style', 'border:4px solid blue')", title);
        assertTrue(title.isDisplayed());
        WebElement rating = driver.findElement(By.xpath("//div[@class='star-rating']/parent::div[@class='woocommerce-product-rating']"));
        jse.executeScript
                ("arguments[0].setAttribute('style', 'border:4px solid blue')", rating);
        assertTrue(rating.isDisplayed());
        WebElement price = driver.findElement(By.xpath("//div[@class='summary entry-summary']/descendant::span[@class='woocommerce-Price-amount amount']"));
        jse.executeScript
                ("arguments[0].setAttribute('style', 'border:4px solid blue')", price);
        assertTrue(price.isDisplayed());
        WebElement description = driver.findElement(By.xpath("//div[@class='woocommerce-product-details__short-description']"));
        jse.executeScript
                ("arguments[0].setAttribute('style', 'border:4px solid blue')", description);
        assertTrue(description.isDisplayed());
        WebElement quantity = driver.findElement(By.xpath("//input[@class='input-text qty text']"));
        jse.executeScript
                ("arguments[0].setAttribute('style', 'border:4px solid blue')", quantity);
        assertTrue(quantity.isDisplayed());
        WebElement button = driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']"));
        jse.executeScript
                ("arguments[0].setAttribute('style', 'border:4px solid blue')", button);
        assertTrue(button.isDisplayed());
        WebElement category = driver.findElement(By.xpath("//span[@class='posted_in']"));
        jse.executeScript
                ("arguments[0].setAttribute('style', 'border:4px solid blue')", category);
        assertTrue(category.isDisplayed());
    }
}

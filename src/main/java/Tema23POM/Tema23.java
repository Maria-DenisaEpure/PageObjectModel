package Tema23POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.MenuPage;
import utils.BaseTest;

import java.time.Duration;

public class Tema23 extends BaseTest {
    @Test
    public void galleryPageJSE() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        MenuPage menuPage = new MenuPage(driver);
        Thread.sleep(2000);
        WebElement blog = driver.findElement(menuPage.blogLink);
        Thread.sleep(2000);
        blog.click();
        // click folosind JSE nu a mers, nu inteleg din ce motiv
//        jse.executeScript("document.getElementsByClassName('sf-with-ul')[0].click()");
//        jse.executeScript("arguments[0].click()", blog);
        WebElement postFormats = driver.findElement(menuPage.postFormats);
        jse.executeScript("arguments[0].click()", postFormats);
        WebElement galleryFormat = driver.findElement(By.cssSelector("a[href*='gallery-format']"));
        jse.executeScript("arguments[0].scrollIntoView()", galleryFormat);
        jse.executeScript("arguments[0].click()", galleryFormat);
        WebElement comment = driver.findElement(By.id("comment"));
        jse.executeScript("arguments[0].scrollIntoView()", comment);
        jse.executeScript("arguments[0].value='comentariu'", comment);
        WebElement name = driver.findElement(By.id("author"));
        jse.executeScript("arguments[0].value='nume'", name);
        WebElement email = driver.findElement(By.id("email"));
        jse.executeScript("arguments[0].value='email@yahoo.com'", email);
        WebElement url = driver.findElement(By.id("url"));
        jse.executeScript("arguments[0].value='http://url'", url);
        WebElement sendComm = driver.findElement(By.id("send_comment"));
        jse.executeScript("arguments[0].click()", sendComm);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("comment_not_approved")));
    }
}

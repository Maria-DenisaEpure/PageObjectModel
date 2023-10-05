package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuPage {

    public WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    //locatori sau webelements
    //WebElement buton =  driver.findElement(By.ceva(""))
    public By homeLink = By.linkText("HOME");
    public By contactLink = By.linkText("CONTACTS");
    public By loginLink = By.linkText("Login");
    public By shopLink = By.linkText("BOOKS");
    public By singleAuthorLink = By.linkText("SINGLE AUTHOR");
    public By blogLink = By.linkText("BLOG");
    public By aboutLink = By.linkText("ABOUT");
    public By eventsLink = By.linkText("EVENTS");
    public By postFormats = By.linkText("Post Formats");
    public By classics = By.linkText("Classic");
    public By fb = By.cssSelector("span[class='icon-facebook']");
    public By twitter = By.cssSelector("span[class='icon-twitter']");
    public By instagram = By.cssSelector("span[class='icon-instagramm']");

    public By searchIcon = By.cssSelector("button[class*='search_submit']");
    public By searchInput = By.cssSelector("input[class='search_field']");

    //metode specifice cu locatori sau elementele de mai sus
    //metode specifice inseamna functionalitate a paginii in care ma aflu
    public void navigateTo(By locator) {
        driver.findElement(locator).click();
    }

    public void hoverElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions action =  new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void changeCurrentTab(By locator) throws InterruptedException {
        WebElement element = driver.findElement(locator);
        element.click();
        Thread.sleep(2000);
        String keybooks = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!keybooks.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
        Thread.sleep(2000);
    }
}
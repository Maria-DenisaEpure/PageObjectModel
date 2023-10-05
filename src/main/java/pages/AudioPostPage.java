package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AudioPostPage {
    public WebDriver driver;

    public AudioPostPage (WebDriver driver) {
        this.driver = driver;	}

    public By playerSlider = By.cssSelector("span[class='mejs-time-handle']");
    public By playButton = By.cssSelector("div[class*='mejs-play']");
    public By volumeSlider = By.cssSelector("div[class*='volume-current']");

    public void dragAndDropSlider(By locator, int x, int y) {
        WebElement element = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).clickAndHold(element).moveByOffset(x,y).release().perform();
    }
}

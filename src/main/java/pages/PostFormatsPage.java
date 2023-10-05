package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostFormatsPage {
    public WebDriver driver;

    public PostFormatsPage(WebDriver driver) {
        this.driver = driver;	}

    public By audioPost = By.linkText("Audio post");

    public void selectFormat(By format) {
        driver.findElement(format).click();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ClassicBlogsPage {
    public WebDriver driver;

    public ClassicBlogsPage (WebDriver driver) {
        this.driver = driver;	}

    public By searchField = By.cssSelector("input[title='Search for:']");
    public List<String> categories;

    public void createList() {
        categories = new ArrayList<>();
        List<WebElement> categoryElements = driver.findElements(By.cssSelector("a[class='category_link']"));
        for (int i = 0; i < categoryElements.size(); i++) {
            categories.add(categoryElements.get(i).getText());
            System.out.println(categories.get(i));
        }
    }

}

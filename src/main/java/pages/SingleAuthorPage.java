package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleAuthorPage {
    public WebDriver driver;
    public List<WebElement> labels;
    public List<WebElement> percentages;
    public Map<String,String> map = new HashMap<>();

    public SingleAuthorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createMap() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[style*='overflow']")));
        labels = driver.findElements(By.cssSelector("div[class*='sc_skills_label']"));
        percentages = driver.findElements(By.cssSelector("div[class*='sc_skills_total']"));
        for (int i = 0; i < labels.size(); i++) {
            map.put(labels.get(i).getText(),percentages.get(i).getText());
        }
    }

    public boolean checkPercentageValue(String skill, String percentage) {
        return map.get(skill).equals(percentage);
    }
}

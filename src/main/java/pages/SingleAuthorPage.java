package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage {
    public WebDriver driver;
    public By country = By.id("shipping_country");
    public By province = By.id("shipping_state");

    public ShippingAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectByIndex(int index) {
        WebElement dropdown =  driver.findElement(country);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    public void selectByVisibleText(String text) {
        WebElement dropdown =  driver.findElement(province);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    public String getSelectedOption(By element) {
        WebElement dropdown =  driver.findElement(element);
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }
}

package Tema20POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AudioPostPage;
import pages.MenuPage;
import pages.PostFormatsPage;
import utils.BaseTest;
import java.time.Duration;

public class Tema20 extends BaseTest {
    @Test
    public void slidersDragAndDrop() throws InterruptedException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateTo(menuPage.blogLink);
        menuPage.navigateTo(menuPage.postFormats);
        PostFormatsPage postFormatsPage = new PostFormatsPage(driver);
        postFormatsPage.selectFormat(postFormatsPage.audioPost);
        AudioPostPage audioPage = new AudioPostPage(driver);
        WebElement playBtn = driver.findElement(audioPage.playButton);
        playBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(audioPage.playerSlider));
        playBtn.click();
        // butonul de player nu functioneaza bine?
        audioPage.dragAndDropSlider(audioPage.playerSlider,200,0);
        audioPage.dragAndDropSlider(audioPage.volumeSlider,50,0);
    }
}

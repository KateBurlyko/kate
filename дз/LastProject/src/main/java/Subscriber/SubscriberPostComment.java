package Subscriber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Adds comment by subscriber
 */
public class SubscriberPostComment {
    private WebDriver driver;

    /**
     * Constructor
     *
     * @param driver - chrome driver
     */
    public SubscriberPostComment(ChromeDriver driver) {
        this.driver = driver;
    }

    /**
     * go to test
     */
    public void goToTest() {
        driver.findElement(By.linkText("Dashboard")).click();
    }

    /**
     * go to post
     */
    public void goToPost() {
        driver.findElement(By.linkText("Hello world!")).click();
    }

    /**
     * add comment
     *
     * @param comment - added comment
     */
    public void addComment(String comment) {
        // driver.findElement(By.xpath("id('comment')")).click();
        driver.findElement(By.id("comment")).sendKeys(comment);
    }

    /**
     * find word "Replay" after added comment
     *
     * @return "Reply"
     */
    public String getPostCommentPageUrl() {
        return driver.findElement(By.className("reply")).getText();
    }
}

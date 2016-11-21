import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * run the input commands
 */
public class SiteTest {
    int error = 0;
    static WebDriver driver = new ChromeDriver();
    Log log = new Log();

    /**
     * run the command open
     *
     * @param url     link which opend
     * @param timeout - time for which link should open
     */
    public void testURL(String url, String timeout) {
        String total = "+";
        double stOpen = System.currentTimeMillis();
        String command = " [open " + '"' + url + '"' + " " + '"' + timeout + '"' + "]";
        try {
            long time = Long.parseLong(timeout);
            driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
            driver.get(url);
        } catch (Exception e) {
            error++;
            total = "!";
        }
        double fiOpen = System.currentTimeMillis();
        log.getCommandTime(total, command, stOpen, fiOpen);
    }

    /**
     * run the command checkPageTitle
     *
     * @param title - title which should de on the page
     */
    public void pageTitle(String title) {
        String total = "+";
        String command = " [checkPageTitle " + '"' + title + '"' + "]";
        driver.get(driver.getCurrentUrl());
        double startTitle = System.currentTimeMillis();
        if (!driver.getTitle().equals(title)) {
            error++;
            total = "!";
        }
        double finishTitle = System.currentTimeMillis();
        log.getCommandTime(total, command, startTitle, finishTitle);
    }

    /**
     * run the command checkPageContains
     * and close ChromeDriver
     *
     * @param text - text which page should contain
     */
    public void containPage(String text) {
        String total = "+";
        String command = " [checkPageContains " + '"' + text + '"' + "]";
        driver.get(driver.getCurrentUrl());
        double startText = System.currentTimeMillis();
        if (!driver.getPageSource().contains(text)) {
            error++;
            total = "!";
        }
        double finishText = System.currentTimeMillis();
        log.getCommandTime(total, command, startText, finishText);
        driver.quit();
    }

    /**
     * contain the number of failed tests
     *
     * @return number failed tests
     */
    public int getFail() {
        return error;
    }

}

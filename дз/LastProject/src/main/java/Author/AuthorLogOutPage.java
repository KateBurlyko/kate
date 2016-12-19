package Author;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains author's login pages' elements
 */
public class AuthorLogOutPage {
    private WebDriver driver;

    /**
     * Constructor author's login page
     *
     * @param driver - chrome driver
     */
    public AuthorLogOutPage(ChromeDriver driver) {
        this.driver = driver;
    }


    /**
     * enter the button Login
     *
     * @return author's home page
     */
    public AuthorHomePage goToHomePage() {
        driver.findElement(By.id("wp-admin-bar-site-name")).click();
        return new AuthorHomePage((ChromeDriver) driver);
    }

    /**
     * enter the button Log out
     *
     * @return author's home page
     */
    public AuthorHomePage clickLogOut() {
        driver.findElement(By.linkText("Log out")).click();
        return new AuthorHomePage((ChromeDriver) driver);
    }

    public String getHomePageUrl() {
        return driver.getCurrentUrl();
    }
}
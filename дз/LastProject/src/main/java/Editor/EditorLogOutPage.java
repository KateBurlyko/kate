package Editor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains editor's login pages' elements
 */
public class EditorLogOutPage {
    private WebDriver driver;

    /**
     * Constructor editor's login page
     *
     * @param driver - chrome driver
     */
    public EditorLogOutPage(ChromeDriver driver) {
        this.driver = driver;
    }


    /**
     * enter the button Login
     *
     * @return editor's home page
     */
    public EditorHomePage goToHomePage() {
        driver.findElement(By.id("wp-admin-bar-site-name")).click();
        return new EditorHomePage((ChromeDriver) driver);
    }

    public EditorHomePage clickLogOut(){
        driver.findElement(By.linkText("Log out")).click();
        return new EditorHomePage((ChromeDriver) driver);
    }

    public String getHomePageUrl() {
        return driver.getCurrentUrl();
    }
}
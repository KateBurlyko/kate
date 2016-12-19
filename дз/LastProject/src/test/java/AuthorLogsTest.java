import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Author.AuthorHomePage;
import Author.AuthorLogOutPage;
import Author.AuthorLoginPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 *
 */
public class AuthorLogsTest {

    private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
    private ChromeDriver driver;
    private AuthorLoginPage authorLoginPage;
    private AuthorHomePage authorHomePage;
    private AuthorLogOutPage authorLogOutPage;
    querries.ConnectToMySQL c = new querries.ConnectToMySQL();

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        c.addEditor();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        authorLoginPage = new AuthorLoginPage(driver);
        authorLoginPage.openLoginPage();
        c.addAuthor();
        authorLoginPage.setUserName("Author");
        authorLoginPage.setPassword("1");
        authorHomePage = authorLoginPage.enterLoginPageAuthor();
    }

    @Test
    public void testLoginAuthor() {
        assertEquals(URL_HOME_PAGE, authorHomePage.getHomePageUrl());
    }

    @Test
    public void testLogOutAuthor() {
        authorLogOutPage = new AuthorLogOutPage(driver);
        authorLogOutPage.goToHomePage();
        authorLogOutPage.clickLogOut();
        assertEquals("http://localhost:8888/wp-login.php?loggedout=true", authorHomePage.getHomePageUrl());
    }

    @AfterMethod
    public void tearDown() {
        c.deleteEditor();
        driver.close();
    }
}

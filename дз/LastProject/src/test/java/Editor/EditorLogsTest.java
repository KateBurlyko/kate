package Editor;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import querries.ConnectToMySQL;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * in first test editor login
 * in second test editor log in and log out
 */
@Test(singleThreaded = true)
public class EditorLogsTest {
    private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
    private ChromeDriver driver;
    private EditorLoginPage editorLoginPage;
    private EditorHomePage editorHomePage;
    private EditorLogOutPage editorLogOutPage;
    ConnectToMySQL c = new ConnectToMySQL();

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        c.addEditor();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        editorLoginPage = new EditorLoginPage(driver);
        editorLoginPage.openLoginPage();
        editorLoginPage.setUserName("Editor");
        editorLoginPage.setPassword("1");
        editorHomePage = editorLoginPage.enterLoginPageEditor();
    }

    @Test
    public void testLoginEditor() {
        assertEquals(URL_HOME_PAGE, editorHomePage.getHomePageUrl());
    }

    @Test
    public void testLogOutEditor() {
        editorLogOutPage = new EditorLogOutPage(driver);
        editorLogOutPage.goToHomePage();
        editorLogOutPage.clickLogOut();
        assertEquals("http://localhost:8888/wp-login.php?loggedout=true", editorHomePage.getHomePageUrl());
    }

    @AfterMethod
    public void tearDown() {
        c.deleteEditor();
        driver.close();
    }
}
import Editor.EditorHomePage;
import Editor.EditorLogOutPage;
import Editor.EditorLoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created by Janek on 18-дек-16.
 */
public class LogEditor {
    private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
    private ChromeDriver driver;
    private EditorLoginPage editorLoginPage;
    private EditorHomePage editorHomePage;
    private EditorLogOutPage editorLogOutPage;
    ConnectToMySQL c = new ConnectToMySQL();

    @BeforeMethod
    public void SetUp() {
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
    public void TearDown() {
        c.deleteEditor();
        driver.close();
    }
}

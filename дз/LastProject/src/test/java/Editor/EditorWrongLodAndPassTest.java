package Editor;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import querries.ConnectToMySQL;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * editor try to login with wrong login and password
 */
@Test(singleThreaded = true)
public class EditorWrongLodAndPassTest {
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
    }

    @Test
    public void wrongLogin() {
        editorLoginPage.openLoginPage();
        editorLoginPage.setUserName("Edito");
        editorLoginPage.setPassword("1");
        editorHomePage = editorLoginPage.enterLoginPageEditor();
        assertEquals("ERROR: Invalid username. Lost your password?", driver.findElement(By.id("login_error")).getText());
    }

    @Test
    public void wrongPass() {
        editorLoginPage.openLoginPage();
        editorLoginPage.setUserName("Editor");
        editorLoginPage.setPassword("2");
        editorHomePage = editorLoginPage.enterLoginPageEditor();
        assertEquals("ERROR: The password you entered for the username Editor is incorrect. Lost your password?",
                driver.findElement(By.id("login_error")).getText());
        //assert()driver.findElement(By.className("trash")).getText();
    }

    @Test
    public void wrongPassAndLogin() {
        editorLoginPage.openLoginPage();
        editorLoginPage.setUserName("Edito");
        editorLoginPage.setPassword("2");
        editorHomePage = editorLoginPage.enterLoginPageEditor();
        assertEquals("ERROR: Invalid username. Lost your password?",
                driver.findElement(By.id("login_error")).getText());
        //assert()driver.findElement(By.className("trash")).getText();
    }

    @AfterMethod
    public void tearDown() {
        c.deleteEditor();
        driver.close();
    }
}

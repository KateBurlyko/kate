package Editor;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import querries.ConnectToMySQL;

import java.util.concurrent.TimeUnit;

/**
 *
 */
@Test(singleThreaded = true)
public class EditorClickDateAndTitlePublishTest {
    private ChromeDriver driver;
    private Editor.EditorLoginPage editorLoginPage;
    private Editor.EditorHomePage editorHomePage;
    private Editor.EditorPublish editorPublish;
    ConnectToMySQL c = new ConnectToMySQL();

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        c.addEditor();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        editorLoginPage = new Editor.EditorLoginPage(driver);
        editorLoginPage.openLoginPage();
        editorLoginPage.setUserName("Editor");
        editorLoginPage.setPassword("1");
        editorHomePage = editorLoginPage.enterLoginPageEditor();
    }


    @Test
    public void test3DateOfPublish() {
        editorPublish = new Editor.EditorPublish(driver);
        editorPublish.goToPosts();
        driver.findElement(By.linkText("Date")).click();
        assert (driver.getCurrentUrl().contains("order=desc"));
        driver.findElement(By.linkText("Date")).click();
        assert (driver.getCurrentUrl().contains("order=asc"));
    }

    @Test
    public void test4TitleOfPublish() {
        editorPublish = new Editor.EditorPublish(driver);
        editorPublish.goToPosts();
        driver.findElement(By.linkText("Title")).click();
        assert (driver.getCurrentUrl().contains("order=asc"));
        driver.findElement(By.linkText("Title")).click();
        assert (driver.getCurrentUrl().contains("order=desc"));
    }

    @AfterMethod
    public void tearDown() {
        c.deleteEditor();
        driver.close();
    }
}

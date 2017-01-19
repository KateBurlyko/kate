import Editor.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Janek on 18-дек-16.
 */
public class EditorClickDateAndTitlePublish {
    private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
    private ChromeDriver driver;
    private EditorLoginPage editorLoginPage;
    private EditorHomePage editorHomePage;
    private EditorPublish editorPublish;
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
    public void test3DateOfPublish() {
        editorPublish = new EditorPublish(driver);
        editorPublish.goToPosts();
        driver.findElement(By.linkText("Date")).click();
        assert (driver.getCurrentUrl().contains("order=desc"));
        driver.findElement(By.linkText("Date")).click();
        assert (driver.getCurrentUrl().contains("order=asc"));
    }

    @Test
    public void test4TitleOfPublish() {
        editorPublish = new EditorPublish(driver);
        editorPublish.goToPosts();
        driver.findElement(By.linkText("Title")).click();
        assert (driver.getCurrentUrl().contains("order=asc"));
        driver.findElement(By.linkText("Title")).click();
        assert (driver.getCurrentUrl().contains("order=desc"));
    }
    @AfterMethod
    public void TearDown() {
        c.deleteEditor();
        driver.close();
    }
}

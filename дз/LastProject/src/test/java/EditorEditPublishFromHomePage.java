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
public class EditorEditPublishFromHomePage {
    private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
    private ChromeDriver driver;
    private EditorLoginPage editorLoginPage;
    private EditorHomePage editorHomePage;
    private EditorPublish editorPublish;
    private EditorAddPost editorAddPost;
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
    public void test8editFromSitePage() {
        editorPublish = new EditorPublish(driver);
        driver.findElement(By.xpath(".//*[@id='wp-admin-bar-site-name']/a")).click();
        driver.findElement(By.linkText("How can we help?")).click();
        driver.findElement(By.className("post-edit-link")).click();
        assert(driver.getCurrentUrl().contains("action=edit"));
    }
    @AfterMethod
    public void TearDown() {
        c.deleteEditor();
        driver.close();
    }
}

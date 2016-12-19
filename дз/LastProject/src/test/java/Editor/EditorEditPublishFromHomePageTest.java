package Editor;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import querries.ConnectToMySQL;

import java.util.concurrent.TimeUnit;

/**
 * editor go to home page and try to edit published post
 */
@Test(singleThreaded = true)
public class EditorEditPublishFromHomePageTest {
    //  private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
    private ChromeDriver driver;
    private Editor.EditorLoginPage editorLoginPage;
    private Editor.EditorHomePage editorHomePage;
    private Editor.EditorPublish editorPublish;
    private Editor.EditorAddPost editorAddPost;
    ConnectToMySQL c = new ConnectToMySQL();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        c.addEditor();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        editorLoginPage = new Editor.EditorLoginPage(driver);
        editorLoginPage.openLoginPage();
        editorLoginPage.setUserName("Editor");
        editorLoginPage.setPassword("1");
        editorHomePage = editorLoginPage.enterLoginPageEditor();
        editorAddPost = new Editor.EditorAddPost(driver);
        editorAddPost.setTitle("MySQL Editions");
        editorAddPost.setPost("MySQL is the world's most popular open source database. Whether you are a fast growing web property, technology ISV or large enterprise," +
                " MySQL can cost-effectively help you deliver high performance," +
                " scalable database applications. MySQL Community Edition is the freely downloadable version of the world's most popular open source database.\n" +
                "\n" +
                "Learn more about the MySQL Community Edition\n" +
                "Download the MySQL Community Edition\n" +
                "Commercial customers have the flexibility of choosing from multiple editions to meet specific business and technical requirements:\n" +
                "\n" +
                "MySQL Standard Edition\n" +
                "MySQL Enterprise Edition\n" +
                "MySQL Cluster Carrier Grade Edition\n" +
                "ISVs, OEMs and VARs can learn more about MySQL as an Embedded Database");
        editorAddPost = editorHomePage.enterSaveDraft();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.linkText("Posts")).click();
        driver.findElement(By.linkText("MySQL Editions")).click();
        driver.findElement(By.id("publish")).click();
    }

    @Test
    public void test8editFromSitePage() {
        editorPublish = new Editor.EditorPublish(driver);
        driver.findElement(By.xpath(".//*[@id='wp-admin-bar-site-name']/a")).click();
        driver.findElement(By.linkText("MySQL Editions")).click();
        driver.findElement(By.className("post-edit-link")).click();
        assert (driver.getCurrentUrl().contains("action=edit"));
    }

    @AfterMethod
    public void tearDown() {
        //  driver.findElement(By.linkText("Move to Trash")).click();
        c.deleteEditor();
        driver.close();
    }
}

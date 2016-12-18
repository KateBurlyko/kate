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
public class DeletePublishPost {
    private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
    private ChromeDriver driver;
    private EditorLoginPage editorLoginPage;
    private EditorHomePage editorHomePage;
    private EditorPublish editorPublish;
    private EditorAddPost editorAddPost;
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
        editorAddPost = new EditorAddPost(driver);
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
        driver.findElement(By.linkText("Posts")).click();
        editorPublish.goToDraft();
        editorPublish.goToEdit();
        editorPublish.setPublish();
    }


    @Test
    public void test9DelPublish() {
        editorPublish = new EditorPublish(driver);
        editorPublish.goToPosts();
        editorPublish.goToPublish();
        editorPublish.delPublish();
        assert (driver.getCurrentUrl().contains("post_type=post"));
        // assertEquals ((driver.findElement(By.linkText("Undo"))), "Undo");
//        editorPublish.undoPublish();
//        assert (driver.getCurrentUrl().contains("paged=1"));
    }
    @AfterMethod
    public void TearDown() {
        c.deleteEditor();
        driver.close();
    }
}

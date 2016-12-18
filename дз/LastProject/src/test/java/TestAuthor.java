import Author.AuthorAddPost;
import Author.AuthorHomePage;
import Author.AuthorLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Janek on 03.12.2016.
 */
public class TestAuthor {
    private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
    private ChromeDriver driver;
    private AuthorLoginPage authorLoginPage;
    private AuthorHomePage authorHomePage;
    private AuthorAddPost authorAddPost;
    ConectionToSql c = new ConectionToSql();

    @BeforeMethod
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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
    public void testAddPost() {
        authorAddPost = new AuthorAddPost(driver);
        authorAddPost.setTitle("How can we help?");
        authorAddPost.setPost("Welcome to the Oracle Help Center. Whether you are new to Oracle " +
                "or an advanced user, you can find useful information about our products and services," +
                " ranging from getting started guides to advanced features.\n");
        authorAddPost = authorHomePage.enterSaveDraft();
        assertEquals(URL_HOME_PAGE, authorAddPost.getAddPostPageUrl());
        driver.findElement(By.linkText("Posts")).click();
    }
@Test
public void teste(){
        c.addPost();
}

    @AfterMethod
    public void TearDown() {
       c.deleteAuthor();
        driver.close();
    }
}

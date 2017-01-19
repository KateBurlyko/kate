import Editor.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Janek on 03.12.2016.
 */
public class TestPostEditor {
    private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
    private ChromeDriver driver;
    private EditorLoginPage editorLoginPage;
    private EditorHomePage editorHomePage;
    private EditorPublish editorPublish;
    private EditorAddPost editorAddPost;
    private EditorLogOutPage editorLogOutPage;
    ConectionToSql c = new ConectionToSql();

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
    public void test7addComment() {
        editorPublish = new EditorPublish(driver);
        driver.findElement(By.xpath(".//*[@id='wp-admin-bar-site-name']/a")).click();
        driver.findElement(By.linkText("How can we help?")).click();
        driver.findElement(By.xpath(".//*[@id='comment']")).click();
        driver.findElement(By.xpath(".//*[@id='comment']")).sendKeys("Good post!");
        driver.findElement(By.id("submit")).click();
        assert(driver.getCurrentUrl().contains("comment"));
 //        assert(driver.getCurrentUrl().contains("action=edit"));
    }

    @Test
    public void test6addTheSameComment() {
        editorPublish = new EditorPublish(driver);
        driver.findElement(By.xpath(".//*[@id='wp-admin-bar-site-name']/a")).click();
        driver.findElement(By.linkText("How can we help?")).click();
        driver.findElement(By.xpath(".//*[@id='comment']")).click();
        driver.findElement(By.xpath(".//*[@id='comment']")).sendKeys("Wondrful!");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.xpath(".//*[@id='comment']")).click();
        driver.findElement(By.xpath(".//*[@id='comment']")).sendKeys("Wondrful!");
        driver.findElement(By.id("submit")).click();
        assert(driver.getCurrentUrl().contains("wp-comments-post"));
    }

    @AfterMethod
    public void TearDown() {
        c.deleteEditor();
        driver.close();
    }
}


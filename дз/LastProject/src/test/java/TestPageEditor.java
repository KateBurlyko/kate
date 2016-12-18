import Editor.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Janek on 18-дек-16.
 */
public class TestPageEditor {
    private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/";
    private ChromeDriver driver;
    private EditorLoginPage editorLoginPage;
    private EditorHomePage editorHomePage;
    ConnectToMySQL c = new ConnectToMySQL();

    @BeforeMethod
    public void SetUp() {
        driver = new ChromeDriver();
        c.addEditor();
        driver.manage().timeouts().implicitlyWait(48, TimeUnit.SECONDS);
        editorLoginPage = new EditorLoginPage(driver);
        editorLoginPage.openLoginPage();
        editorLoginPage.setUserName("Editor");
        editorLoginPage.setPassword("1");
        editorHomePage = editorLoginPage.enterLoginPageEditor();
    }

    @Test
    public void addNewPage() {
        driver.findElement(By.linkText("Pages")).click();
        driver.findElement(By.linkText("Add New")).click();
        driver.findElement(By.id("title")).sendKeys("About Belarus");
        driver.findElement(By.id("qt_content_strong")).click();
        driver.findElement(By.id("qt_content_em")).click();
        driver.findElement(By.name("content")).sendKeys("The Republic of Belarus (Belarus) is located in the Eastern part of Europe." +
                " In the West it borders on Poland, in the North - West - Lithuania," +
                " in the North - Latvia, in the North - East and East - Russia, " +
                "in the South - Ukraine. Belarus is divided into six regions (oblast):" +
                " Brest oblast, Vitebsk oblast, Gomel oblast, Grodno oblast, Minsk oblast and Mogilev oblast. " +
                "The capital of Belarus is the city of Minsk, which is the biggest political," +
                " economic, scientific and cultural centre of the country. " +
                "The population of Minsk is 1.729 million people.");
        driver.findElement(By.id("save-post")).click();
        assert (driver.getCurrentUrl().contains("action=edit"));
    }

    @Test
    public void DraftPagepublish() {
        driver.findElement(By.linkText("Pages")).click();
        driver.findElement(By.className("draft")).click();
        driver.findElement(By.linkText("About Belarus")).click();
        driver.findElement(By.id("publish")).click();
        assert (driver.getCurrentUrl().contains("action=edit"));
    }

    @Test
    public void editPublishedPage() {
        driver.findElement(By.linkText("Pages")).click();
        driver.findElement(By.linkText("About Belarus")).click();
        driver.findElement(By.id("publish")).click();
        driver.findElement(By.linkText("View page")).click();
        assert(driver.getCurrentUrl().contains("http://localhost:8888/?page_id="));
        driver.findElement(By.className("post-edit-link")).click();
        assert(driver.getCurrentUrl().contains("&action=edit"));
    }

    @Test
    public void deletePublishedPage() {
        driver.findElement(By.linkText("Pages")).click();
        driver.findElement(By.linkText("About Belarus")).click();
       driver.findElement(By.linkText("Move to Trash")).click();
       assert(driver.getCurrentUrl().contains("post_type=page"));
        driver.findElement(By.linkText("Undo")).click();
        assert (driver.getCurrentUrl().contains("paged=1"));
    }



    @AfterMethod
    public void TearDown() {
        c.deleteEditor();
        driver.close();
    }
}

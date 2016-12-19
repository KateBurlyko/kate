import Subscriber.SubscriberHomePage;
import Subscriber.SubscriberLoginPage;
import Subscriber.SubscriberPostComment;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import querries.ConnectToMySQL;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Janek on 03.12.2016.
 */
public class TestSubscriber {
    private static String URL_HOME_PAGE = "http://localhost:8888/wp-admin/profile.php";
    private static String URL_POST_COMMENT = "Reply";
    private ChromeDriver driver;
    SubscriberLoginPage subscriberLoginPage;
    SubscriberHomePage subscriberHomePage;
    SubscriberPostComment subscriberPostComment;
    ConnectToMySQL c = new ConnectToMySQL();

    @BeforeMethod
    public void SetUp() {
        driver = new ChromeDriver();
        c.addSubscriber();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        subscriberLoginPage = new SubscriberLoginPage(driver);
        subscriberLoginPage.openLoginPage();
        subscriberLoginPage.setUserName("Subscriber");
        subscriberLoginPage.setPassword("1");
        subscriberHomePage = subscriberLoginPage.enterLoginPageSubscriber();
    }

    /**
     * subscriber logs in
     */
    @Test
    public void testLoginSubscriber() {
        assertEquals(URL_HOME_PAGE, subscriberHomePage.getHomePageUrl());
    }

    /**
     * subscriber add comment to post
     */
    @Test
    public void testPostAdd() {
        subscriberPostComment = new SubscriberPostComment(driver);
        subscriberPostComment.goToTest();
        subscriberPostComment.goToPost();
        subscriberPostComment.addComment("Amazing!");
        subscriberPostComment = subscriberHomePage.enterPostComment();

        assertEquals(URL_POST_COMMENT, subscriberPostComment.getPostCommentPageUrl());
    }

    @AfterMethod
    public void TearDown() {
        c.deleteSubscriber();
        driver.close();
    }
}
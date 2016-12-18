package Editor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by HP on 04.12.2016.
 */
public class EditorPublish {
  private WebDriver driver;

  /**
   * Constructor editor's login page
   *
   * @param driver - chrome driver
   */
  public EditorPublish(ChromeDriver driver) {
    this.driver = driver;
  }

  /**
   * go to posts
   */
  public void goToPosts() {
    driver.findElement(By.partialLinkText("Post")).click();

  }

  /**
   * go to drafts
   */
  public void goToDraft() {
    driver.findElement(By.className("draft")).click();
  }

  /**
   * go to edit
   */
  public void goToEdit() {
    driver.findElement(By.className("row-title")).click();
  }

  /**
   * publish the post
   */
  public void setPublish() {
    driver.findElement(By.id("publish")).click();
  }

  public void goToPublish(){
    driver.findElement(By.linkText("MySQL Editions")).click();
  }

  public void delPublish(){
    driver.findElement(By.linkText("Move to Trash")).click();
  }

  public void undoPublish(){
    driver.findElement(By.linkText("Undo")).click();
  }

  public void addNewCategory(){
    driver.findElement(By.partialLinkText("Add New Category")).click();
  }

  public void clickAddCategory(){
    driver.findElement(By.linkText("Add New Category")).sendKeys("caaaat");
  }

}

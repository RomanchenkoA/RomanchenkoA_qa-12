import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

  FirefoxDriver wd;

  @BeforeClass
  public void setUp() throws Exception {
    wd = new FirefoxDriver(new FirefoxOptions()
            .setLegacy(true));
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    openAddressbook();
    login("admin", "secret");
  }

  @AfterClass
  public void tearDown() {
    wd.quit();
  }


  public void returnToGroupsPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(String name, String header, String footer) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(name);
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(header);
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(footer);
  }

  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  public void openAddressbook() {

    wd.get("http://localhost/addressbook/");
  }


  public void login(String userName, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(userName);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }



  public void goToGroupsPage() {
    wd.findElement(By.linkText("groups")).click();
  }




  public static boolean isAlertPresent(FirefoxDriver wd) {
    return TestBase.isAlertPresent(wd);
  }

}

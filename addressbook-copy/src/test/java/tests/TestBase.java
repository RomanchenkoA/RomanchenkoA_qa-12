package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

  protected ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

  @BeforeClass
  public void setUp() throws Exception {
    app.start();
  }


  @AfterClass
  public void tearDown() {
    app.stop();
  }





}

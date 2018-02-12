package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {

  protected ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
  Logger logger = LoggerFactory.getLogger(TestBase.class);
  @BeforeClass
  public void setUp() throws Exception {
    app.start();
  }

  @BeforeMethod
  public void logTestStart(Method method, Object[] p){
    logger.info("Start test " + method.getName() + " with parameter " + p);
  }
  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method method){
    logger.info("Stop test" + method.getName());
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }





}

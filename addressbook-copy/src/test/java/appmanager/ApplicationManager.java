package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private  String browser;
    WebDriver wd;

    private GroupHelper groupHelper = new GroupHelper(wd);
    private NavigationHelper navigationHelper = new NavigationHelper(wd);
    private SessionHelper sessionHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }



    public void start() {

             if(browser.equals(BrowserType.FIREFOX)){
             wd = new FirefoxDriver(new FirefoxOptions()
                       .setLegacy(true));
        }else
             if(browser.equals(BrowserType.CHROME)) {
             wd = new ChromeDriver();
        }else
             if(browser.equals(BrowserType.IE)){
             wd = new InternetExplorerDriver();
        }


      wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      sessionHelper = new SessionHelper(wd);
      sessionHelper.openAddressbook("http://localhost/addressbook/");
      groupHelper = new GroupHelper(wd);
      navigationHelper = new NavigationHelper(wd);
      sessionHelper.login("admin", "secret");
    }

    public void stop() {
      wd.quit();
    }

     public void goToGroupsPage() {
      groupHelper.click(By.linkText("groups"));
    }

    public GroupHelper groups() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}

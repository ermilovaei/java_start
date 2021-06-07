package ru.stqa.stjv.adressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private ContactHelper contactHelper;
  private GroupHelper groupHelper;

  public void init() {
   wd = new FirefoxDriver();
   wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   groupHelper = new GroupHelper(wd);
   contactHelper = new ContactHelper(wd);
   navigationHelper = new NavigationHelper(wd);
   sessionHelper = new SessionHelper(wd);

   wd.get("http://localhost/addressbook/addressbook/index.php");
   sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }



}

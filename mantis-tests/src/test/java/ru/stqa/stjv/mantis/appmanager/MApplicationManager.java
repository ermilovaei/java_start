package ru.stqa.stjv.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MApplicationManager {
  private final String browser;
  private final Properties properties;
  WebDriver wd;
  private MSessionHelper sessionHelper;
  private MNavigationHelper navigationHelper;
  private MAdminHelper adminHelper;
  private MMailHelper mailHelper;
  private MHttpSession httpSession;

  public MAdminHelper admin() {
    return adminHelper;
  }


  public MSessionHelper session() {
    return sessionHelper;
  }


  public MNavigationHelper goTo() {
    return navigationHelper;
  }

  public MApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");

    properties.load(new FileReader(String.format("src/test/resources/%s.properties", target)));

    if (browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }


    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    sessionHelper = new MSessionHelper(wd);
    navigationHelper = new MNavigationHelper(wd);
    adminHelper = new MAdminHelper(wd);
    wd.get(properties.getProperty("web.baseUrl", "http://localhost/mantisbt-1.3.20/mantisbt-1.3.20/"));

  }


 public MMailHelper mail() {
    if (mailHelper == null)
    {
      mailHelper = new MMailHelper(this);
    }
    return mailHelper;
  }

public MHttpSession newSession() {
    return new MHttpSession(this);
}


  public void stop() {
    wd.quit();
  }


  public String getProperties(String key) {
   return properties.getProperty(key);
  }
}

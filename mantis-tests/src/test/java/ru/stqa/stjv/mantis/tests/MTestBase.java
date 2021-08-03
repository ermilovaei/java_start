package ru.stqa.stjv.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.stjv.mantis.appmanager.MApplicationManager;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class MTestBase {

  protected static final MApplicationManager app = new MApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  public boolean isIssueOpen(int issueId) throws MalformedURLException, ServiceException, RemoteException {
  String issueStatus = app.soap().getIssueStatus(issueId);
  boolean b = !issueStatus.equals("resolved") && !issueStatus.equals("closed");
   return !issueStatus.equals("resolved") && !issueStatus.equals("closed");


  }
  public void skipIfNotFixed(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }



  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }



}

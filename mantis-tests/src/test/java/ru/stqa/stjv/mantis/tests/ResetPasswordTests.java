package ru.stqa.stjv.mantis.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.stjv.mantis.appmanager.MHttpSession;
import ru.stqa.stjv.mantis.model.MailMassage;

import java.util.List;

public class ResetPasswordTests extends MTestBase {
  private WebDriver wd;

  @BeforeMethod

  public void startWebServer() {
    app.mail().start();
  }


  @Test
  public void testResetPassword()  throws Exception {
    app.session().login(System.getProperty("web.adminLogin", "administrator"), System.getProperty("web.admilPassword","123"));
    app.goTo().configureUsers();
    String userLogin = app.admin().randomUserLogin();
    app.goTo().userPage(userLogin);
    app.admin().resetPassword();

    List<MailMassage> mailMessages = app.mail().waitForMail(1,10000);
    String confirmationLink = findConfirmationLink (mailMessages);
    String newPassword = "000";
    app.goTo().resetPassword(confirmationLink, newPassword);
   // app.session().login(userLogin, newPassword);
    MHttpSession httpSession = app.newSession();
    Assert.assertTrue(httpSession.login(userLogin, newPassword));

    Assert.assertTrue(httpSession.isLoggedInAs(userLogin));
  }

  private String findConfirmationLink(List<MailMassage> mailMessages) {
    MailMassage mailMassage = mailMessages.get(0);
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMassage.text);
  }

  @AfterMethod (alwaysRun = true)

  public void stopWebServer() {
    app.mail().stop();
  }

}

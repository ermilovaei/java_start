package ru.stqa.stjv.mantis.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ResetPasswordTests extends MTestBase {
  private WebDriver wd;

  @Test
  public void testResetPassword()  throws Exception {
    app.session().login(System.getProperty("web.adminLogin", "administrator"), System.getProperty("web.admilPassword","123"));
    //app.goTo().configure();
    app.goTo().configureUsers();

    //driver.findElement(By.linkText("qqq")).click();
    //driver.findElement(By.xpath("//form[@id='edit-user-form']/fieldset/div[3]")).click();
    //driver.findElement(By.xpath("//input[@value='Сбросить пароль']")).click();

  }

}

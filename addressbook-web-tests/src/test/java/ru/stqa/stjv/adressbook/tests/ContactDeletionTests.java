package ru.stqa.stjv.adressbook.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.stjv.adressbook.model.contactData;

public class ContactDeletionTests extends TestBase {
  private WebDriver wd;

  @Test
  public void testContactDeletion() throws Exception {
    if (! app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(new contactData("contact", "contact last", "street, 1, 1", "234-54-333", "err@dd.tt", "28", "April", "1980"));
      app.getNavigationHelper().returnToHomePage();
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().contactDeletionAlertAccept();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before - 1);
  }

}

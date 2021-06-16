package ru.stqa.stjv.adressbook.tests;

import java.util.concurrent.TimeUnit;
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
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().contactDeletionAlertAccept();

  }

}

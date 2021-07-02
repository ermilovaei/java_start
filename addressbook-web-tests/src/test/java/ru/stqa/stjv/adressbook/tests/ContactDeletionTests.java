package ru.stqa.stjv.adressbook.tests;

import java.util.List;
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
    contactData contact = new contactData("contact", "contact last", "street, 1, 1","test@email.com", "234-54-333");
    if (! app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(contact);
      app.getNavigationHelper().returnToHomePage();
    }

    List<contactData> beforeList = app.getContactHelper().getContactList();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().contactDeletionAlertAccept();
    int after = app.getContactHelper().getContactCount();

    List<contactData> afterList = app.getContactHelper().getContactList();
    Assert.assertEquals(after,before - 1);
    beforeList.remove(before - 1);
    Assert.assertEquals(afterList,beforeList);
  }

}

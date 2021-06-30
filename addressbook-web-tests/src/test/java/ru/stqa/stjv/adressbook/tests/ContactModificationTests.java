package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.contactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification()  {
    app.getNavigationHelper().goToContactsPage();
    if (! app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(new contactData("contact", "contact last", "street, 1, 1", "234-54-333", "err@dd.tt", "28", "April", "1980"));
      app.getNavigationHelper().returnToHomePage();
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().initContactModification(before - 1);
    app.getContactHelper().fillContactData(new contactData("c name", "new last", "new street, 1, 1", "234-54-333", "err@dd.tt", "14", "June", "1981"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before);
  }

}

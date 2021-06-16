package ru.stqa.stjv.adressbook.tests;

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
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(new contactData("new name", "new last", "new street, 1, 1", "234-54-333", "err@dd.tt", "14", "June", "1981"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
  }

}

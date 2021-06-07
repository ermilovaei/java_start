package ru.stqa.stjv.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.contactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification()  {
    app.getNavigationHelper().goToContactsPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(new contactData("new name", "new last", "new street, 1, 1", "234-54-333", "err@dd.tt", "14", "June", "1981"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
  }

}

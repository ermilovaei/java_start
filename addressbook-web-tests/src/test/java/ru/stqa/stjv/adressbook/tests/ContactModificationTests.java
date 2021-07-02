package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.contactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification()  {
    app.getNavigationHelper().goToContactsPage();
    if (! app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(new contactData("contact last", "contact", "street, 1, 1", "err@dd.tt", "23454333", "28", "April", "1980"));
      app.getNavigationHelper().returnToHomePage();
    }

    int before = app.getContactHelper().getContactCount();
    List<contactData> beforeList = app.getContactHelper().getContactList();

    app.getContactHelper().initContactModification(before - 1);
    contactData contact = new contactData(beforeList.get(beforeList.size() - 1).getId(), "new last" , "c name",  "new street, 1, 1", "err@dd.tt", "23454333");

    app.getContactHelper().fillContactData(contact);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();

    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before);

    List<contactData> afterList = app.getContactHelper().getContactList();

    beforeList.remove(beforeList.size() - 1);
    beforeList.add(contact);

    Comparator<? super contactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    beforeList.sort(byID);
    afterList.sort(byID);

    Assert.assertEquals(beforeList, afterList);
  }

}

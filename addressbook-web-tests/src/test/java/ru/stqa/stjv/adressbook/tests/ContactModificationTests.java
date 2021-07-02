package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.contactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  private void ensurePreconditions() {
    app.getNavigationHelper().goToContactsPage();
    if (! app.getContactHelper().isThereAContact())
    {
      app.getContactHelper().createContact(new contactData("contact last", "contact", "street, 1, 1", "err@dd.tt", "23454333", "28", "April", "1980"));
      app.getNavigationHelper().returnToHomePage();
    }
  }

  @Test
  public void testContactModification()  {
    List<contactData> beforeList = app.getContactHelper().getContactList();
    int index = beforeList.size() - 1;
    contactData contact = new contactData(beforeList.get(index).getId(), "new last" , "c name",  "new street, 1, 1", "err@dd.tt", "23454333");

    app.getContactHelper().modifyContact(index, contact);
    app.getNavigationHelper().returnToHomePage();

    List<contactData> afterList = app.getContactHelper().getContactList();
    Assert.assertEquals(beforeList.size(), afterList.size());

    beforeList.remove(index);
    beforeList.add(contact);

    Comparator<? super contactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    beforeList.sort(byID);
    afterList.sort(byID);

    Assert.assertEquals(beforeList, afterList);
  }




}

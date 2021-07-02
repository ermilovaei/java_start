package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.contactData;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().getContactCount();
    List<contactData> beforeList = app.getContactHelper().getContactList();

    contactData contact = new contactData( "contact last7", "contact7","street, 7, 1","err7@dd.tt", "23454333",  "28", "April", "1980");

    app.getContactHelper().createContact(contact);
    app.getNavigationHelper().returnToHomePage();

    int after = app.getContactHelper().getContactCount();
    List<contactData> afterList = app.getContactHelper().getContactList();

    Assert.assertEquals(after,before + 1);

    beforeList.add(contact);

    Comparator<? super contactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    beforeList.sort(byID);
    afterList.sort(byID);

    Assert.assertEquals(beforeList,afterList);

  }


}

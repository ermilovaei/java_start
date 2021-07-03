package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.contactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    int before = app.contact().getContactCount();
    List<contactData> beforeList = app.contact().list();

    contactData contact = new contactData( "contact last7", "contact7","street, 7, 1","err7@dd.tt", "23454333",  "28", "April", "1980");

    app.contact().create(contact);
    app.goTo().homePageBack();

    int after = app.contact().getContactCount();
    List<contactData> afterList = app.contact().list();

    Assert.assertEquals(after,before + 1);

    beforeList.add(contact);

    Comparator<? super contactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    beforeList.sort(byID);
    afterList.sort(byID);

    Assert.assertEquals(beforeList,afterList);

  }


}

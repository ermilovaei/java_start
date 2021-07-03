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
    app.goTo().ContactsPage();
    if (app.contact().list().size() == 0)
    {
      app.contact().create(new contactData("contact last", "contact", "street, 1, 1", "err@dd.tt", "23454333", "28", "April", "1980"));
      app.goTo().homePageBack();
    }
  }

  @Test
  public void testContactModification()  {
    List<contactData> before = app.contact().list();
    int index = before.size() - 1;
    contactData contact = new contactData(before.get(index).getId(), "new last" , "c name",  "new street, 1, 1", "err@dd.tt", "23454333");

    app.contact().modify(index, contact);
    app.goTo().homePageBack();

    List<contactData> after = app.contact().list();
    Assert.assertEquals(before.size(), after.size());

    before.remove(index);
    before.add(contact);

    Comparator<? super contactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byID);
    after.sort(byID);

    Assert.assertEquals(before, after);
  }




}

package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.contactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  private void ensurePreconditions() {
    app.goTo().ContactsPage();
    if (app.contact().all().size() == 0)
    {
      app.contact().create(new
              contactData().withLastName("contact last").withFirstName("contact").
              withAdress("street, 1, 1").withEmailFirst("err@dd.tt").withTelephoneHome("23454333").
              withBDate("28").withBMonth("April").withBYear("1980"));
      app.goTo().homePageBack();

    }
  }

  @Test
  public void testContactModification()  {
    Set<contactData> before = app.contact().all();
   contactData  moifiedContact = before.iterator().next();

    contactData contact = new contactData().withId(moifiedContact.getId()).withLastName("new last").withFirstName("c name").
                              withAdress("new street, 1, 1").withEmailFirst("err@dd.tt").withTelephoneHome("23454333").
                              withBDate("11").withBMonth("April").withBYear("1999");


    app.contact().modify(contact);
    app.goTo().homePageBack();

    Set<contactData> after = app.contact().all();
    Assert.assertEquals(before.size(), after.size());

    before.remove(moifiedContact);
    before.add(contact);

    Assert.assertEquals(before, after);
  }




}

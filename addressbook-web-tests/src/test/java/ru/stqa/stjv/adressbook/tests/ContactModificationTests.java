package ru.stqa.stjv.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.ContactData;
import ru.stqa.stjv.adressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  private void ensurePreconditions() {
    app.goTo().ContactsPage();
    if (app.contact().all().size() == 0)
    {
      app.contact().create(new
              ContactData().withLastName("contact last").withFirstName("contact").
              withAdress("street, 1, 1").withEmailFirst("err@dd.tt").withTelephoneHome("23454333").
              withBDate("28").withBMonth("April").withBYear("1980"));
      app.goTo().homePageBack();

    }
  }

  @Test
  public void testContactModification()  {

    Contacts before = app.contact().all();
    ContactData moifiedContact = before.iterator().next();

    ContactData contact = new ContactData().withId(moifiedContact.getId()).withLastName("new last").withFirstName("c name").
                              withAdress("new street, 1, 1").withEmailSecond("e.rtt@d.yd.tt").withTelephoneWork("555 55 53").
                              withBDate("11").withBMonth("April").withBYear("1999");


    app.contact().modify(contact);
    app.goTo().homePageBack();
    assertThat(app.contact().count(), equalTo(before.size()));

    Contacts after = app.contact().all();
    MatcherAssert.assertThat(after,
            CoreMatchers.equalTo(before.withOut(moifiedContact).withAdded(contact)));
  }




}

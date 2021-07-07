package ru.stqa.stjv.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.ContactData;
import ru.stqa.stjv.adressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

  @BeforeMethod
  private void init() {
    app.goTo().ContactsPage();
  }

  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();

    ContactData contact = new ContactData().withLastName("last name").withFirstName("First name").
            withAdress("street, 1, 1").withEmailFirst("err@dd.tt").withTelephoneHome("23454333").
            withBDate("28").withBMonth("April").withBYear("1980");

    app.contact().create(contact);
    app.goTo().homePageBack();

    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


  }

}

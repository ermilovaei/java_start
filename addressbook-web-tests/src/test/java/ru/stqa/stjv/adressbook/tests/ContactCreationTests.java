package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.contactData;

import java.util.Set;

public class ContactCreationTests extends TestBase{

  @BeforeMethod
  private void init() {
    app.goTo().ContactsPage();
  }

  @Test
  public void testContactCreation() throws Exception {
    Set<contactData> before = app.contact().all();

    contactData contact = new  contactData().withLastName("last name").withFirstName("First name").
            withAdress("street, 1, 1").withEmailFirst("err@dd.tt").withTelephoneHome("23454333").
            withBDate("28").withBMonth("April").withBYear("1980");

    app.contact().create(contact);
    app.goTo().homePageBack();


    Set<contactData> after = app.contact().all();
    Assert.assertEquals(after.size(),before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);

    Assert.assertEquals(before, after);

  }


}

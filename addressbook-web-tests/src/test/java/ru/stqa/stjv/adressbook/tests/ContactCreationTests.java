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
            withAdress("street, 1, 1").
            withBDate("28").withBMonth("April").withBYear("1980")
            .withEmailFirst("err@dd.tt").withEmailSecond("email.Second@rrr.rr").whithEmailThird("em_ai-l@Thi.rd")
            .withTelephoneHome("+7(234)54333").withTelephoneMobile("2323-232 2323.00")
            .withTelephoneWork("333.444#55").withTelephoneSecondaryHome("222 222 222");

    app.contact().create(contact);
    app.goTo().homePageBack();

    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


  }

}

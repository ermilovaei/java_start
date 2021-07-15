package ru.stqa.stjv.adressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.stjv.adressbook.model.ContactData;
import ru.stqa.stjv.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactDeletionTests extends TestBase {
  private WebDriver wd;

  @BeforeMethod
  private void ensurePreconditions() {
    app.goTo().ContactsPage();
    if (app.db().contacts().size() == 0)
    {
     app.contact().create(new
             ContactData().withLastName("contact last").withFirstName("contact").
              withAdress("street, 1, 1").withEmailFirst("err@dd.tt").withTelephoneHome("23454333").
              withBDate("28").withBMonth("April").withBYear("1980"));
      app.goTo().homePageBack();
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    Contacts before = app.db().contacts();

    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1) );

    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(deletedContact)));
  }



}

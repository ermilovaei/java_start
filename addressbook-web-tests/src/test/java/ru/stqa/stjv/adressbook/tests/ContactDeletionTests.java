package ru.stqa.stjv.adressbook.tests;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.stjv.adressbook.model.contactData;


public class ContactDeletionTests extends TestBase {
  private WebDriver wd;

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
  public void testContactDeletion() throws Exception {
    Set<contactData> before = app.contact().all();

    contactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);

    Set<contactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(after,before);
  }



}

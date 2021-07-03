package ru.stqa.stjv.adressbook.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.stjv.adressbook.model.contactData;

public class ContactDeletionTests extends TestBase {
  private WebDriver wd;

  @BeforeMethod
  private void ensurePreconditions() {
    app.goTo().ContactsPage();
    if (app.contact().list().size() == 0)
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
    List<contactData> before = app.contact().list();
    int index = before.size() - 1;


    app.contact().delete(index);


    List<contactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(after,before);
  }



}

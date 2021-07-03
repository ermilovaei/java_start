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
      app.contact().create(new contactData("contact last", "contact", "street, 1, 1", "err@dd.tt", "23454333", "28", "April", "1980"));
      app.goTo().HomePageBack();
    }
  }

  @Test
  public void testContactDeletion() throws Exception {
    contactData contact = new contactData("contact", "contact last", "street, 1, 1","test@email.com", "234-54-333");
    List<contactData> before = app.contact().list();
    int index = before.size() - 1;


    app.contact().delete(index);


    List<contactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(after,before);
  }



}

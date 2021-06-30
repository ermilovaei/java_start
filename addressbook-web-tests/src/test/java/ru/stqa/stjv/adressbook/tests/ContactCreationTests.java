package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.contactData;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new contactData("contact", "contact last", "street, 1, 1", "234-54-333", "err@dd.tt", "28", "April", "1980"));
    app.getNavigationHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before + 1);
  }


}

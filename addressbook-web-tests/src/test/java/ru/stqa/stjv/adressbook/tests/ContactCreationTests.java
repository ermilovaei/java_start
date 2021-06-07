package ru.stqa.stjv.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.contactData;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() throws Exception {

    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactData(new contactData("contact", "contact last", "street, 1, 1", "234-54-333", "err@dd.tt", "28", "April", "1980"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
  }


}

package ru.stqa.stjv.adressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() throws Exception {

    initContactCreation();
    fillContactData(new contactData("contact", "contact last", "street, 1, 1", "234-54-333", "err@dd.tt", "18", "June", "1991"));
    submitContactCreation();
    returnToHomePage();
  }


}

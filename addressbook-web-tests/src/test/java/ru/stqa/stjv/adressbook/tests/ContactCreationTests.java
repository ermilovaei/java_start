package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.contactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

  @BeforeMethod
  private void init() {
    app.goTo().ContactsPage();
  }

  @Test
  public void testContactCreation() throws Exception {

    int before = app.contact().getContactCount();
    List<contactData> beforeList = app.contact().list();

    contactData contact = new  contactData().withLastName("last name").withFirstName("First name").
            withAdress("street, 1, 1").withEmailFirst("err@dd.tt").withTelephoneHome("23454333").
            withBDate("28").withBMonth("April").withBYear("1980");

    app.contact().create(contact);
    app.goTo().HomePageBack();

    int after = app.contact().getContactCount();
    List<contactData> afterList = app.contact().list();

    Assert.assertEquals(after,before + 1);

    beforeList.add(contact);

    Comparator<? super contactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    beforeList.sort(byID);
    afterList.sort(byID);

    Assert.assertEquals(beforeList,afterList);

  }


}

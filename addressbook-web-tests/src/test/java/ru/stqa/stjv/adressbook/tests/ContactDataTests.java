package ru.stqa.stjv.adressbook.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDataTests extends TestBase{
  public static ContactData contact;
  public static ContactData contactInfoFromEditForm;

  @BeforeClass
  private void ensurePreconditions() {
    app.goTo().ContactsPage();
    if (app.contact().all().size() == 0)
    {
      app.contact().create(new
              ContactData().withLastName("contact last").withFirstName("contact").
              withAdress("street, 1, 1")
              .withEmailFirst("err@dd.tt").withEmailSecond("email.Second@rrr.rr").whithEmailThird("em_ai-l@Thi.rd")
              .withTelephoneHome("+7(234)54333").withTelephoneMobile("2323-232 2323.00")
              .withTelephoneWork("333.444#55"));

      app.goTo().homePageBack();

    }
  }

  @BeforeClass
  public static void getTestDataContact(){
    app.goTo().ContactsPage();
    contact = app.contact().all().iterator().next();
    contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }



  @Test
  public void testContactPones(){
   assertThat(contact.getAllTelephones(), equalTo(contactInfoFromEditForm.mergePhones(contactInfoFromEditForm)));
  }

  @Test
  public void testContactEmails(){
    assertThat(contact.getAllEmails(), equalTo(contactInfoFromEditForm.mergeEmails(contactInfoFromEditForm)));
  }

  @Test
  public void testContactAddress(){
    assertThat(contact.getAdress(), equalTo(contactInfoFromEditForm.getAdress()));

  }



  public static String clened (String phone) {
    return phone.replaceAll("/s","").replaceAll("[-().( )]","");
 }
}

package ru.stqa.stjv.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.ContactData;
import ru.stqa.stjv.adressbook.model.Contacts;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
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
   assertThat(contact.getAllTelephones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  @Test
  public void testContactEmails(){
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  @Test
  public void testContactAddress(){
    assertThat(contact.getAdress(), equalTo(contactInfoFromEditForm.getAdress()));

  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getTelephoneHome(),
            contact.getTelephoneMobile(),
            contact.getTelephoneWork(),
            contact.getTelephoneSecondaryHome())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactDataTests::clened)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmailFirst(),
            contact.getEmailSecond(),
            contact.getEmailThird())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String clened (String phone) {
    return phone.replaceAll("/s","").replaceAll("[-().( )]","");
 }
}

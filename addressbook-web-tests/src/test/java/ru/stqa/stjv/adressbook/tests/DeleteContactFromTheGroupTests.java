package ru.stqa.stjv.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.ContactData;
import ru.stqa.stjv.adressbook.model.Contacts;
import ru.stqa.stjv.adressbook.model.GroupData;

public class DeleteContactFromTheGroupTests extends TestBase {

  @BeforeMethod
  private void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().GroupsPage();
      app.group().create(new GroupData()
              .withName("group to del Contact").withHeader("test group header").withFooter("new group footer"));
    }
    app.goTo().ContactsPage();
    if (app.db().contacts().size() == 0)
    {
      ContactData contact = new
            ContactData().withLastName("contact last").withFirstName("contact to add group").
            withAdress("street, 1, 1").withEmailFirst("err@dd.tt")
            .withEmailSecond("e.rtt@d.yd.tt").whithEmailThird("e.rtt@d.yd.tt")
            .withTelephoneWork("555 55 53").withTelephoneHome("23454333").withTelephoneMobile("555 55 53")
            .withTelephoneSecondaryHome("555 55 53").
                    withBDate("28").withBMonth("April").withBYear("1980");
      app.contact().create(contact);
      contact = app.contact().all().iterator().next();
      app.goTo().ContactsPage();
      app.contact().addContactToTheGroup(contact, app.db().groups().iterator().next());
    }

  }


  @Test
  public void testDeleteContactFromTheGroup() {

    ContactData contactToDeleteFromGroup  = app.db().contacts().iterator().next();
    if (contactToDeleteFromGroup.getGroups().size() == 0)
    {
      app.goTo().ContactsPage();
      app.contact().addContactToTheGroup(contactToDeleteFromGroup, app.db().groups().iterator().next());
    }
    app.goTo().ContactsPage();
    app.contact().deleteContactFromTheGroup(contactToDeleteFromGroup, app.db().groups().iterator().next());

  }


}

package ru.stqa.stjv.adressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.ContactData;
import ru.stqa.stjv.adressbook.model.Contacts;
import ru.stqa.stjv.adressbook.model.groupData;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class AddContactToTheGroupTests extends TestBase{

  @BeforeMethod
  private void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().GroupsPage();
      app.group().create(new groupData()
              .withName("group for Contact").withHeader("test group header").withFooter("new group footer"));
    }

    if (app.db().contacts().size() == 0)
    {
      app.goTo().ContactsPage();
      app.contact().create(new
              ContactData().withLastName("contact last").withFirstName("contact to add group").
              withAdress("street, 1, 1").withEmailFirst("err@dd.tt")
              .withEmailSecond("e.rtt@d.yd.tt").whithEmailThird("e.rtt@d.yd.tt")
              .withTelephoneWork("555 55 53").withTelephoneHome("23454333").withTelephoneMobile("555 55 53")
              .withTelephoneSecondaryHome("555 55 53").
                      withBDate("28").withBMonth("April").withBYear("1980"));
      app.goTo().homePageBack();
    }

  }


@Test
  public void testAddContactToTheGroup() {

  ContactData contactAdded = app.db().contacts().iterator().next();
  int idContactAdded = contactAdded.getId();
  groupData groupForContact = new groupData();

    if (app.db().groups().size() == contactAdded.getGroups().size())
    {
        app.goTo().GroupsPage();
        app.group().create(new groupData()
                .withName("group for Contact").withHeader("test group header").withFooter("new group footer"));
    }


    for (groupData group : app.db().groups())
    {
      if  (! contactAdded.getGroups().contains(group))
      {
        groupForContact = group;
        break;
      }
    }
  app.goTo().ContactsPage();
  app.contact().addContactToTheGroup(contactAdded,groupForContact);

  Contacts allContacts = app.db().contacts();

  for (ContactData contact: allContacts) {
    if (contact.getId() == idContactAdded) {
      contactAdded = contact;
      break;
    }
  }
  assertThat(contactAdded.getGroups(), hasItem(groupForContact));

  }
}

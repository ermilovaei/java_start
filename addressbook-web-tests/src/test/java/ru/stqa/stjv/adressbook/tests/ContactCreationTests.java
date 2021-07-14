package ru.stqa.stjv.adressbook.tests;

import com.google.gson.Gson;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.ContactData;
import ru.stqa.stjv.adressbook.model.Contacts;
import ru.stqa.stjv.adressbook.model.GroupData;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

  @BeforeMethod
  private void init() {
    app.goTo().ContactsPage();
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }

      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());

      return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }

  @Test (dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) throws Exception {
    Contacts before = app.contact().all();

    app.contact().create(contact);
    app.goTo().homePageBack();

    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


  }

}

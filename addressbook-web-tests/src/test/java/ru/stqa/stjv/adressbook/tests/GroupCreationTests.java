package ru.stqa.stjv.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.GroupData;
import ru.stqa.stjv.adressbook.model.Groups;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase{

  @BeforeMethod
  private void init() {
    app.goTo().GroupsPage();
  }

  @Test
  public void testGroupCreation() throws Exception {

    app.goTo().GroupsPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("group name").withHeader("test group header").withFooter("test group footer");
    app.group().create(group);
    Groups after = app.group().all();

    assertThat(after.size(), equalTo(before.size()+1));
    assertThat(after, equalTo(before.withAdded(
            group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}




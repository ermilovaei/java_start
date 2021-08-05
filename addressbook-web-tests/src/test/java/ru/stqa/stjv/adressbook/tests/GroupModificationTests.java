package ru.stqa.stjv.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.GrouppData;
import ru.stqa.stjv.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class GroupModificationTests extends TestBase {

  @BeforeMethod
  private void ensurePreconditions() {
    app.goTo().GroupsPage();
    if(app.db().groups().size() == 0)
    {
      app.group().create(new GrouppData().withName("group name").withHeader("test group header").withFooter("test group footer"));
    }

  }

  @Test
  public void testGroupModification(){

  Groups before = app.db().groups();
  GrouppData moifiedGroup = before.iterator().next();
  GrouppData group = new GrouppData().withId(moifiedGroup.getId()).withName("new group").withHeader("test group header").withFooter("new group footer");

  app.group().modify(group);
  assertThat(app.group().count(), equalTo(before.size()));

  Groups after = app.db().groups();
    assertThat(after,
            equalTo(before.withOut(moifiedGroup).withAdded(group)));

  verifyGroupListInUI();

  }


}

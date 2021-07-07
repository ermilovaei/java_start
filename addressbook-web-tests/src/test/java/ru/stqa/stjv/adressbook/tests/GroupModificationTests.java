package ru.stqa.stjv.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.GroupData;
import ru.stqa.stjv.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class GroupModificationTests extends TestBase {

  @BeforeMethod
  private void ensurePreconditions() {
    app.goTo().GroupsPage();
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("group name").withHeader("test group header").withFooter("test group footer"));
    }

  }

  @Test
  public void testGroupModification(){

  Groups before = app.group().all();
  GroupData moifiedGroup = before.iterator().next();
  GroupData group = new GroupData().withId(moifiedGroup.getId()).withName("new group").withHeader("test group header").withFooter("new group footer");

  app.group().modify(group);
  assertThat(app.group().count(), equalTo(before.size()));

  Groups after = app.group().all();
    assertThat(after,
            equalTo(before.withOut(moifiedGroup).withAdded(group)));

  }

}

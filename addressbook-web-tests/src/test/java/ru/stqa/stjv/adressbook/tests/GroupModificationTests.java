package ru.stqa.stjv.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.stjv.adressbook.model.groupData;

import java.util.Set;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  private void ensurePreconditions() {
    app.goTo().GroupsPage();
    if (app.group().all().size() == 0){
      app.group().create(new groupData().withName("group name").withHeader("test group header").withFooter("test group footer"));
    }

  }

  @Test
  public void testGroupModification(){

  Set<groupData> before = app.group().all();
  groupData moifiedGroup = before.iterator().next();
  groupData group = new groupData().withId(moifiedGroup.getId()).withName("new group").withHeader("test group header").withFooter("new group footer");

  app.group().modify(group);

  Set<groupData> after = app.group().all();

  Assert.assertEquals(after.size(),before.size());
  before.remove(moifiedGroup);
  before.add(group);


  Assert.assertEquals(before, after);

  }



}
